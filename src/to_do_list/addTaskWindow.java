package to_do_list;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addTaskWindow extends JDialog implements ActionListener {

    JButton addBtn;
    JTextField textField;
    frame parentFrame;

    public addTaskWindow(frame parent) {
        super(parent, "Add Task", true); // modal dialog
        this.parentFrame = parent;

        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));

        addBtn = new JButton("Add");
        addBtn.addActionListener(this);

        add(new JLabel("Enter Task:"));
        add(textField);
        add(addBtn);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String task = textField.getText().trim();
            if (!task.isEmpty()) {
                frame.tasks.add(task);
                parentFrame.refreshTaskList();
            } else {
                JOptionPane.showMessageDialog(this, "Task cannot be empty.");
            }
            dispose(); // closes the dialog
        }
    }
}
