/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guidemo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author ken
 */
public class SimpleFrame3 {
    JFrame frame;
    JLabel label;
    
    public static void main(String[] args) {
        SimpleFrame3 gui = new SimpleFrame3();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton labelButton = new JButton("Change label");
        // instead of passing (this), we pass a new instance of LabelListener
        labelButton.addActionListener(new LabelListener() );
        
        JButton colorButton = new JButton("Change color");
        // instead of passing (this), we pass a new instance of colorListener
        colorButton.addActionListener(new colorListener());
        
        label = new JLabel("I am a legend");
        MyPanel panel = new MyPanel();
        
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        
        frame.setSize(500, 300);
        frame.setVisible(true);    
    }
    
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            label.setText("You hit me");
        }
    }
    
    class colorListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }
 }
