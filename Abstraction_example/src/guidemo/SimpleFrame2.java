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

public class SimpleFrame2 implements ActionListener {
    JFrame frame;
    public static void main(String[] args) {
        SimpleFrame2 gui = new SimpleFrame2();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button = new JButton("Change color");
        button.addActionListener(this);
        
        MyPanel panel = new MyPanel();
        
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 300);
        frame.setVisible(true);    
    }
    
    public void actionPerformed(ActionEvent event){
        frame.repaint();
    }
}
