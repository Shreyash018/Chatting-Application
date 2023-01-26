package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Objects;

public class server extends JFrame implements ActionListener {
    // Jframe class comes from swing package
    // program of frame
    server(){

        // this is the green color panel we have created
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84)); // color of panel rgb
        p1.setBounds(0,0,450,70);// location of panel
       // p1.setLayout();
        add(p1);
//
        // this program for back button  arrow img beside profile
          ImageIcon i1 = new ImageIcon("icons/3.png");// loctaion of image icon in file
          //setIconImage(i1.getImage());
          Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT); //adjusting size of image icon
          ImageIcon i3 = new ImageIcon(i2);
          JLabel back = new JLabel(i3);
          back.setBounds(20,20,25,25); // location of image icon on pannel
          p1.add(back);// here we havee to add icon on panael thast why p1. add

        back.addMouseListener(new MouseAdapter(){
            public <MouseEvent> void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        // this program for profile icon
        // loctaion of image icon in file
        ImageIcon i4 = new ImageIcon("icons/1.png");
        //setIconImage(i1.getImage());
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT); //adjusting size of image icon
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        back.setBounds(40,10,50,50); // location of image icon on pannel
        p1.add(profile);// here we havee to add icon on panael thast why p1. add

        ImageIcon i7 = new ImageIcon("icons/video.png");
        //setIconImage(i1.getImage());
        Image i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT); //adjusting size of image icon
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        back.setBounds(300,20,30,30); // location of image icon on pannel
        p1.add(video);// here we havee to add icon on panael thast why p1. add

        ImageIcon i10 = new ImageIcon("icons/phone.png");
        //setIconImage(i1.getImage());
        Image i11 = i10.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT); //adjusting size of image icon
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i6);
        back.setBounds(360,20,50,50); // location of image icon on pannel
        p1.add(phone);// here we havee to add icon on panael thast why p1. add



        // this is the frame we have created
            setSize(450,700);
            setLocation(200,50);
            getContentPane().setBackground(Color.white);
            setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

    }



    public static void main(String[] args) {
        new server();

    }
}
