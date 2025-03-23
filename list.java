import javax.swing.*;
import java.awt.*;


public class list {
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;

    public list() {
        frame = new JFrame("To-Do List");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");

        addButton.addActionListener(e -> addTask());
        removeButton.addActionListener(e -> removeTask());

        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addButton);
        panel.add(removeButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task);
            taskField.setText("");
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(list::new);
    }
}

