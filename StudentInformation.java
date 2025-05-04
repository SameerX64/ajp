package experiment03_student_info;

import javax.swing.*;
import java.awt.event.*;

public class StudentInformation implements ActionListener {

    JFrame frame;
    JTextField[] studentFields = new JTextField[7];
    JTextField[] subjectNames = new JTextField[5];
    JTextField[] subjectMarks = new JTextField[5];
    JButton submitButton, resetButton;

    String[] studentLabels = {"Name", "Branch", "Year", "Roll No", "Email", "Phone", "Semester"};

    public StudentInformation() {
        frame = new JFrame("Student Result Form");
        frame.setLayout(null);
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        frame.setVisible(true);
    }

    private void initComponents() {
        int y = 50;
        for (int i = 0; i < studentFields.length; i++, y += 40) {
            JLabel label = new JLabel(studentLabels[i] + ":");
            label.setBounds(50, y, 150, 25);
            studentFields[i] = new JTextField();
            studentFields[i].setBounds(200, y, 300, 25);
            frame.add(label);
            frame.add(studentFields[i]);
        }

        for (int i = 0; i < 5; i++, y += 40) {
            JLabel label = new JLabel("Subject " + (i + 1) + " Name:");
            subjectNames[i] = new JTextField();
            subjectMarks[i] = new JTextField();
            label.setBounds(50, y, 150, 25);
            subjectNames[i].setBounds(200, y, 150, 25);
            subjectMarks[i].setBounds(400, y, 100, 25);
            frame.add(label);
            frame.add(subjectNames[i]);
            frame.add(subjectMarks[i]);
        }

        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        submitButton.setBounds(150, y + 20, 100, 30);
        resetButton.setBounds(300, y + 20, 100, 30);

        submitButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.add(submitButton);
        frame.add(resetButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < studentFields.length; i++) {
                    result.append(studentLabels[i]).append(": ").append(studentFields[i].getText()).append("\n");
                }

                int total = 0;
                for (int i = 0; i < 5; i++) {
                    int mark = Integer.parseInt(subjectMarks[i].getText());
                    total += mark;
                    result.append("Subject ").append(i + 1).append(": ").append(subjectNames[i].getText())
                            .append(" - Marks: ").append(mark).append("\n");
                }

                double percentage = total / 5.0;
                result.append("\nPercentage: ").append(percentage).append("%");

                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to submit?",
                        "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                if (confirm == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(frame, result.toString(), "Student Result", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric marks!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            for (JTextField field : studentFields) field.setText("");
            for (JTextField field : subjectNames) field.setText("");
            for (JTextField field : subjectMarks) field.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentInformation();
    }
}
