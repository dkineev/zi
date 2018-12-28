package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    static JButton serverPublicAndPrivateKey, serverDecipher, serverClear;
    static JButton userInputText, userCipher, userSend, userClear;
    static JPanel  panelServer, panelButtonServer, panelUser, panelButtonUser, panelUserText;
    static JTextArea textServer, textUser;
    static JTextField textInputUser;
    static  JScrollPane scrollServer, scrollUser;
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    TestActionListener testActionListener = new TestActionListener();

    private int lx = screenSize.width;
    private int ly = screenSize.height;
    private String text;

    static Server server;
    static User user;

    public Frame(){
        JFrame serverFrame = new JFrame("Server");

        serverFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        serverFrame.setBounds(lx / 3,ly / 30, 720, 430);
        serverFrame.setResizable(false);

        panelServer = new JPanel();
        panelButtonServer = new JPanel();

        panelServer.setBorder(new TitledBorder(new EtchedBorder(),"Server Output"));
        textServer = new JTextArea(20,60);
        scrollServer = new JScrollPane(textServer);
        scrollServer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelServer.add(scrollServer);

        serverPublicAndPrivateKey = new JButton("Calculate public and private key");
        serverDecipher = new JButton("Decrypt cipher");
        serverClear = new JButton("Clear Server");

        panelButtonServer.add(serverPublicAndPrivateKey);
        panelButtonServer.add(serverDecipher);
        panelButtonServer.add(serverClear);

        serverFrame.getContentPane().add(BorderLayout.CENTER, panelServer);
        serverFrame.getContentPane().add(BorderLayout.SOUTH, panelButtonServer);

        serverPublicAndPrivateKey.addActionListener(testActionListener);
        serverDecipher.addActionListener(testActionListener);
        serverClear.addActionListener(testActionListener);

        serverFrame.setVisible(true);

        JFrame userFrame = new JFrame("User");

        userFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        userFrame.setBounds(lx / 3,ly / 2, 720, 470);
        userFrame.setResizable(false);

        panelUser = new JPanel();
        panelButtonUser = new JPanel();
        panelUserText = new JPanel();

        panelUser.setBorder(new TitledBorder(new EtchedBorder(),"Input User"));
        textUser = new JTextArea(20, 60);
        scrollUser = new JScrollPane(textUser);
        scrollUser.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelUser.add(scrollUser);

        userInputText = new JButton("Input Text");
        userCipher = new JButton("Cipher Text");
        userSend = new JButton("Sending to Server");
        userClear = new JButton("Clear User");

        textInputUser = new JTextField(40);

        panelButtonUser.add(userCipher);
        panelButtonUser.add(userSend);
        panelButtonUser.add(userClear);

        panelUserText.add(userInputText);
        panelUserText.add(textInputUser);

        userFrame.getContentPane().add(BorderLayout.NORTH, panelUserText);
        userFrame.getContentPane().add(BorderLayout.CENTER, panelUser);
        userFrame.getContentPane().add(BorderLayout.SOUTH, panelButtonUser);

        userInputText.addActionListener(testActionListener);
        userCipher.addActionListener(testActionListener);
        userSend.addActionListener(testActionListener);
        userClear.addActionListener(testActionListener);

        userFrame.setVisible(true);

        server = new Server();
        user = new User();
    }

    class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try{
                if(e.getSource() == serverPublicAndPrivateKey){
                    server.calculatePublicAndPrivateKey();

                    textServer.append("Calculate Public Keys: ");
                    textServer.append("D = " + server.getPublicKeyD() + " ");
                    textServer.append("N = " + server.getPublicKeyN() + "\n");
                    textServer.append("Calculate Private Key: ");
                    textServer.append("E = " + server.getPrivateKeyE() + "\n");
                    textServer.append("\n");

                    user.setPublicKey(server.getPublicKeyD(), server.getPublicKeyN());
                    textUser.append("Public Keys D and N received!" + "\n");
                    textUser.append("D = " + user.getPublicKeyD() + "\n");
                    textUser.append("N = " + user.getPublicKeyN() + "\n");
                    textUser.append("\n");
                }

                if(e.getSource() == serverDecipher){
                    if (server.sendCipher) {
                        server.setMessage();
                        textServer.append("Decrypted message: " + server.getText() + "\n");
                        textServer.append("\n");
                    }else {JOptionPane.showMessageDialog(null, "User didn't Send Cipher!");}
                }

                if(e.getSource() == serverClear){
                    textServer.setText(null);
                    server.clear();
                }

                if(e.getSource() == userInputText){
                    text = textInputUser.getText();
                    user.setMessageText(text);

                    textInputUser.setText(null);
                    textUser.append("Text Entered: " + user.getMessageText() + "\n");
                    textUser.append("Text Code: " + user.getMessageNumber() + "\n");
                    textUser.append("\n");
                }

                if(e.getSource() == userCipher){
                    if (user.sendKey){
                        user.setCipher();
                        textUser.append("Cipher Code: " + user.getCipherNumber() + "\n");
                        textUser.append("\n");
                    }else {JOptionPane.showMessageDialog(null,"Enter Key and Text!");}
                }

                if(e.getSource() == userSend){
                    if (user.cipherInstalled) {
                        server.setCipher(user.getCipher());
                        server.sendCipher = true;

                        textUser.append("Cipher Sent to Server!" + "\n");
                        textUser.append("\n");

                        textServer.append("Cipher Received from User!" + "\n");
                        textServer.append("Cipher Code: "  + server.getCipherNumberText() + "\n");
                        textServer.append("\n");
                    }else {JOptionPane.showMessageDialog(null, "Encrypt the text!");}
                }

                if(e.getSource() == userClear){
                    textUser.setText(null);
                    user.clear();
                }
            }catch (Exception ex){JOptionPane.showMessageDialog(null,"Error system!");}
        }
    }
}
