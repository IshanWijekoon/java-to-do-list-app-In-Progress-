package to_do_list;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addTaskWindow extends JFrame implements ActionListener{
	
	JButton addBtn;
	JTextField textField;
	ArrayList<String> tasks = new ArrayList<>(); // create an array list object
	
	private JFrame parentFrame;
	
	public addTaskWindow(JFrame parent) {
		parentFrame = parent;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setTitle("Task Handler");
		setResizable(false);
		
		addBtn = new JButton("Add");
		addBtn.addActionListener(this);
		
		add(addBtn);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250, 40));
		
		add(textField);
		
		pack();
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addBtn) {
			System.out.println("Welcome "+ textField.getText());
			
			parentFrame.setEnabled(true);
			
			tasks.add(textField.getText());
			System.out.println(tasks);
			dispose();
		}
	}
	
	
}
