import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class NoteBook extends JFrame implements ActionListener{
	JTextArea area; 
	JScrollPane sp;
	String text = "";
	NoteBook(){
		super("NoteBook");
		setBounds(240, 100, 1000, 600);
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem newmenu = new JMenuItem("New");
		newmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.META_MASK));
		newmenu.addActionListener(this);
		
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.META_MASK));
		open.addActionListener(this);

		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK));
		save.addActionListener(this);

		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.META_MASK));
		print.addActionListener(this);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		exit.addActionListener(this);

		file.add(newmenu);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);

		JMenu edit = new JMenu("Edit");
		
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.META_MASK));
		copy.addActionListener(this);

		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.META_MASK));
		paste.addActionListener(this);

		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.META_MASK));
		cut.addActionListener(this);

		JMenuItem select = new JMenuItem("Select All");
		select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.META_MASK));
		select.addActionListener(this);

		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		edit.add(select);

		JMenu help = new JMenu("Help");
		
		JMenuItem about = new JMenuItem("About this App");
		about.addActionListener(this);
		help.add(about);

		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		setJMenuBar(menubar);
		
		area = new JTextArea();
		area.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		sp = new JScrollPane(area);
		sp.setBorder(BorderFactory.createEmptyBorder());
		add(sp, BorderLayout.CENTER);

	 }
	  public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("New")) {
			area.setText("");
			
		}else if(ae.getActionCommand().equals("Open")) {
			JFileChooser choose = new JFileChooser();
			choose.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
			choose.addChoosableFileFilter(restrict);
			
			int action = choose.showOpenDialog(this);
			if(action != JFileChooser.APPROVE_OPTION) {
               return;
			}
			File file = choose.getSelectedFile();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				area.read(reader, null);
			}catch(Exception e) {}
			
		}else if(ae.getActionCommand().equals("Save")) {
			final JFileChooser saveas = new JFileChooser();
			saveas.setApproveButtonText("Save");
			int action = saveas.showOpenDialog(this);
			if(action != JFileChooser.APPROVE_OPTION) {
				return;
			}
			File filename = new File(saveas.getSelectedFile()+".txt");
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(filename));
				area.write(writer);
			}catch(IOException e) {
                e.printStackTrace();
			}
		}else if(ae.getActionCommand().equals("Print")) {
			try {
				area.print();
			}catch(Exception e) {}
		}else if(ae.getActionCommand().equals("Exit")) {
			System.exit(0);
			
		}else if(ae.getActionCommand().equals("Copy")) {
			text = area.getSelectedText();
			
		}else if(ae.getActionCommand().equals("Paste")) {
			area.insert(text, area.getCaretPosition());
	
		}else if(ae.getActionCommand().equals("Cut")) {
			text = area.getSelectedText();
			area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
			
		}else if(ae.getActionCommand().equals("Select All")) {
			area.selectAll();
		}else if(ae.getActionCommand().equals("About this App")) {
			new AboutApp().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new NoteBook().setVisible(true);

	}
}
