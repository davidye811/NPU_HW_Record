/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guidemo;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author ken
 */
public class SimpleFrame4 {
    int x = 0;
    int y = 0;
    
    public static void main(String[] args) {
        SimpleFrame4 gui = new SimpleFrame4();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 300);
        frame.setVisible(true);    
        
        for(int i = 0; i < 200; i++) {
            x++;
            y++;
            
            panel.repaint();;
            
            try {
                Thread.sleep(50);
            } catch (Exception ex){}
        }
        
    }
    
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            // Fill in the entire panel with the background color, before 
            // painting the circle each time.
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.yellow);
            g.fillOval(x, y, 50, 50);
        }
    }
 }
