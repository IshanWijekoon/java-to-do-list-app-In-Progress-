package to_do_list;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class frame extends JFrame implements ActionListener{
	
	JButton addButton1, addButton2;
	
	
	frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when we press close button it will close
		setSize(500, 500); // setting size
		setVisible(true); // make the frame visible
		setTitle("Task Handler");
		setResizable(false);
		
		addButton1 = new JButton();
		addButton2 = new JButton();
		
		addButton1.setBounds(300, 175, 150, 50);
		addButton1.setText("Add Task");
		addButton1.setFocusable(false);
		addButton1.setFont(new Font("poppins", Font.BOLD, 20));
		addButton1.setForeground(Color.white);
		addButton1.setBackground(Color.black);
		addButton1.setBorder(BorderFactory.createEtchedBorder());
		addButton1.addActionListener(this);
		
		addButton2.setBounds(300, 250, 150, 50);
		addButton2.setText("Delete Task");
		addButton2.setFocusable(false);
		addButton2.setFont(new Font("poppins", Font.BOLD, 20));
		addButton2.setForeground(Color.white);
		addButton2.setBackground(Color.black);
		addButton2.setBorder(BorderFactory.createEtchedBorder());
		addButton2.addActionListener(this);

		add(addButton1);
		add(addButton2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addButton1) {
			
			this.setEnabled(false);
			addTaskWindow AddWindow = new addTaskWindow(frame.this);
		}
		
		if(e.getSource()==addButton2) {
			System.out.println("Deleted");
			
		}
	}

	
	
}
