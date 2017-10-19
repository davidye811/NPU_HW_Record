/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guidemo;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author ken
 */
public class SimpleFrame1 implements ActionListener {
    JButton button;
    public static void main(String[] args) {
        SimpleFrame1 gui = new SimpleFrame1();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Click me");
        
        button.addActionListener(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);    
    }
    
    public void actionPerformed(ActionEvent event){
        button.setText("I've been clicked!");
    }
}
