package com.azarenka;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DownloadManager extends JFrame implements Observer {
    private JTextField addTextField;
    private DownloadTableModel tableModel;
    private JTable table;
    private JButton pauseButton;
    private JButton cancelButton;
    private Download selectedDownload;
    private boolean clearing;

    public DownloadManager() throws HeadlessException {
        setTitle("Download Manager");
        setSize(800, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                actionExit();
            }
        });
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu();
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem fileExitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        fileExitMenuItem.addActionListener(e -> actionExit());
    }

    private void actionExit() {
        System.exit(0);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
