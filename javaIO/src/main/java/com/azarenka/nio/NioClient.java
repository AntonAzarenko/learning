package com.azarenka.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import static java.nio.ByteBuffer.allocate;

public class NioClient {
    static int PORT = 9090;
    static String ADDRESS = "localhost";
    private ByteBuffer buffer = allocate(16);

    public void run() throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);
        channel.connect(new InetSocketAddress(ADDRESS, PORT));
        ArrayBlockingQueue<String> blockingDeque = new ArrayBlockingQueue<String>(2);
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if (line.equals('q')) {
                    System.exit(0);
                }
                try {
                    blockingDeque.put(line);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SelectionKey key = channel.keyFor(selector);
                key.interestOps(SelectionKey.OP_WRITE);
                selector.wakeup();
            }

        }).start();
        while (true) {
            selector.select();
            for (SelectionKey selectionKey : selector.selectedKeys()) {
                if (selectionKey.isConnectable()) {
                    channel.finishConnect();
                    selectionKey.interestOps(SelectionKey.OP_WRITE);
                } else if (selectionKey.isReadable()) {
                    buffer.clear();
                    channel.read(buffer);
                    System.out.println("Recieved = " + buffer.array());
                } else if (selectionKey.isWritable()) {
                    String write = blockingDeque.poll();
                    if (write != null) {
                        channel.write(ByteBuffer.wrap(write.getBytes()));
                    }
                    selectionKey.interestOps(SelectionKey.OP_READ);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NioClient().run();
    }
}
