package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;// this package is imported for socket programming
import java.io.*;


public class sever2 implements ActionListener {
    // actionlistner comes from awt this is an event

    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();// here defining a vertical box that when we send the msg it will get on right side of a frame vertically one by one
    static JFrame f = new JFrame();
    static  DataOutputStream dout=new DataOutputStream(OutputStream.nullOutputStream());
    // Jframe is new class comes from swing package
    // we going to the sever frame

    sever2() {

        f.setLayout(null);
        // this is the green color panel we have created

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(12, 123, 110));// color of the panel
        p1.setBounds(0, 0, 450, 70);//size of panel on frame
        p1.setLayout(null);
        f.add(p1);

        // 1st image icon of back button
        ImageIcon i1 = new ImageIcon(("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);// image croped
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);//size of image on panel
        p1.add(back);
        // p1.add coz we added on panel p1 if we did'nt then i will be shown on frame under panel then it will not be visible


        // here giving control to the mouse to do wrok on frame
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        //getting img icon of profile
        ImageIcon i4 = new ImageIcon(("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);


        // getting img icon of video
        ImageIcon i7 = new ImageIcon(("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);

        // getting img icon of phone
        ImageIcon i10 = new ImageIcon(("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);


        // image icon of more
        ImageIcon i13 = new ImageIcon(("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);

        // this the contact name of server
        JLabel name = new JLabel("Gaitonde");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);


        // this is the status of server is he active or not
        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));// this the font we have taken
        p1.add(status);

        // new panel for text
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);// location of new panel
        f.add(a1);

        // this the text box we have taken
        text = new JTextField();
        text.setBounds(5, 655, 310, 40); //loaction of text feild
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);


        // this the program of button
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));// color of button
        send.setForeground(Color.WHITE);
        send.addActionListener(this); // this is an event on send button it work as sending chatt
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);

        f.setSize(450, 700);
        f.setLocation(200, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
    }



    public void actionPerformed(ActionEvent ae){
        // actionperformed is working on action listner. in actionlistner we give event and here we have to give what work will be done by that action
        try {
            String out = text.getText();
            JPanel p2 = formatLabel(out);

            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START);

            dout.writeUTF(out);// sending msg

            text.setText("");

            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));

        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        panel.add(time);

        return panel;
    }




    public static void main(String[] args) {
        new sever2();

        try {
            // making server socket
            ServerSocket skt = new ServerSocket(6001);
            while(true) {
                // we have infinite loop for server
                Socket s = skt.accept();// accpting all msgs
                DataInputStream din = new DataInputStream(s.getInputStream());// comes from io package,this for reciveing msg
                dout = new DataOutputStream(s.getOutputStream());// sending msgs

                while(true) {
                    String msg = din.readUTF();// this method for reading the recieved msg
                    JPanel panel = formatLabel(msg);// called this function for displaying the recieved msg

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);//recived msg will be display on left side on frame ,start line of frame
                    vertical.add(left);
                    f.validate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // at the time of making server we will get errors thats why we r s=using the try catch for catch expections
        }
    }

}

