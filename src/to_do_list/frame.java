package to_do_list;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class frame extends JFrame implements ActionListener {

    JButton addButton, deleteButton;
    DefaultListModel<String> taskListModel;
    JList<String> taskList;
    static ArrayList<String> tasks = new ArrayList<>();

    public frame() {
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(25, 25, 250, 400);

        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        addButton.setBounds(300, 175, 150, 50);
        styleButton(addButton);

        deleteButton.setBounds(300, 250, 150, 50);
        styleButton(deleteButton);

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);

        setTitle("Task Handler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        setResizable(false);

        add(scrollPane);
        add(addButton);
        add(deleteButton);
        setVisible(true);
    }

    private void styleButton(JButton btn) {
        btn.setFocusable(false);
        btn.setFont(new Font("Poppins", Font.BOLD, 20));
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        btn.setBorder(BorderFactory.createEtchedBorder());
    }

    public void refreshTaskList() {
        taskListModel.clear();
        for (String task : tasks) {
            taskListModel.addElement(task);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            new addTaskWindow(this); // no need to disable
        }

        if (e.getSource() == deleteButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
                refreshTaskList();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a task to delete.");
            }
        }
    }
}
