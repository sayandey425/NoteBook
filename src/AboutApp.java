import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutApp extends JFrame implements ActionListener{
	JButton b1;        

    AboutApp(){	
    	super("About the NoteBook");

        setBounds(380, 120, 700,600);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/note2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(260, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(150, 40, 400, 150);
        add(l1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/notelogo.jpg"));
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(50, 228, 70, 70);
        add(l2);
        
        JLabel l3 = new JLabel("<html>NoteBook <br><br>A note taking Software<br>Created by Sayan Dey, Developed using Java.<br><br>NoteBok is a word processing program, <br>which allows changing of text in a computer file.<br>NoteBook is a simple text editor for basic text-editing<br> which enables users to create documents. </html>");
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        l3.setBounds(150, 178, 500, 300);
        add(l3);
        
        b1 = new JButton("OK");
        b1.setBounds(580, 500, 80, 25);
        b1.addActionListener(this);
        add(b1);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
	public static void main(String[] args) {
        new AboutApp().setVisible(true);
	}
}
