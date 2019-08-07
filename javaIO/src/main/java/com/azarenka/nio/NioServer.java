package com.azarenka.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.nio.ByteBuffer.allocate;

public class NioServer {
    private Selector selector;
    private ByteBuffer buffer = allocate(8192);
    private EchoWorker echoWorker = new EchoWorker();
    private final List<ChangeRequest> changeRequestList = new LinkedList<ChangeRequest>();
    private final Map<ServerSocketChannel, List<ByteBuffer>> pendingData = new HashMap<>();

    public NioServer() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        InetSocketAddress isa = new InetSocketAddress(NioClient.ADDRESS, NioClient.PORT);
        serverSocketChannel.socket().bind(isa);
    }

    public void run() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        new NioServer().run();
    }
}
