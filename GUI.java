import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;

class GUI extends JFrame{
	JLabel la=new JLabel();
	
	JTextField t=new JTextField("Enter the number here");
	javax.swing.border.Border b=BorderFactory.createLineBorder(Color.black, 3);
	t.setBorder(b);
	GUI(){
		super("Number Converter");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		//setIconImage();
		add(t);
		setVisible(true);
	}
	public static void main(String[] args){
		new GUI();
	}
}