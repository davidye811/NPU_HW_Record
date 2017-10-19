package A6;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrameContainJPanel {
	 JFrame frame;
	JLabel label;
	static Menu mm = new Menu();
	public static void main(String[] argv){
		JFrameContainJPanel a= new JFrameContainJPanel();
		a.go();
	}
    public void go()
    {
    	JFrameContainJPanel a=new JFrameContainJPanel();
        JFrame jf=new JFrame("Frame");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jpanel=new JPanel();
        jpanel.setLayout(null);
        
        Container c=jf.getContentPane();
        //c.add(jpanel,BorderLayout.CENTER);
        jf.setLayout(null);
        c.add(jpanel);
        
        JButton bt1,bt2,bt3;
        bt1=new JButton("add");
        bt2=new JButton("delete");
        bt3=new JButton("search");
        
        bt1.addActionListener(new AddAction());
        bt2.addActionListener(new deleteAction());
        bt3.addActionListener(new searchAction());
        bt1.setBounds(10,10,80,20);
        bt2.setBounds(10,50,80,20);
        bt3.setBounds(10,90,80,20);
        
        jpanel.add(bt1);
        jpanel.add(bt2);
        jpanel.add(bt3);
        
        //jpanel.setLocation(70,70);
        
        jf.setBounds(0,0,800,600);
        
        jpanel.setBounds(50,0,750,600);
            
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         }
    class AddAction implements ActionListener {

    	public void actionPerformed(ActionEvent event) {
    		String name = JOptionPane.showInputDialog("Name(String)");
    		String Address = JOptionPane.showInputDialog("Address(String)");
    		ArrayList<Integer> numbers=new ArrayList<Integer>();
    		String get_number = (JOptionPane.showInputDialog("number(int)")); 
    		
    		while(get_number!=null||get_number!=""){
    			int number;
    			try
    			{
    				number = Integer.parseInt(get_number);
    			}
    			catch (NumberFormatException nfe)
    			{
    			   // bad data - set to sentinel
    				number = 0;
    				break;
    			}
    			numbers.add(number);
    			get_number = JOptionPane.showInputDialog("number(int)"); 
    		}
    		Contact ContactToAdded = new Contact(name,Address,numbers);
    		mm.add(ContactToAdded);
    		
    	}
    		

    }
    class deleteAction implements ActionListener {

    	public void actionPerformed(ActionEvent event) {
    	
    	String name = JOptionPane.showInputDialog("Name(String)");
    	if(name!=null)
    	mm.delete(name);
    	}
    		

    }
    class searchAction implements ActionListener {

    	public void actionPerformed(ActionEvent event) {
    	String name = JOptionPane.showInputDialog("Name(String)");
    	if(name!=null)
    	System.out.println(mm.Search(name));
    	}
    		

    }
  

}
