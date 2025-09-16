package Views;

import Models.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame{
    private JPanel panel1;
    private JList<Student> studentList;
    private JPanel studentInput;
    private JLabel labelFirstName;
    private JTextField InputFirstName;
    private JLabel labelLastName;
    private JTextField InputLastName;
    private JTextField InputSID;
    private JLabel labelSID;
    private JPanel studentAction;
    private JButton buttonAddStudent;
    private JButton buttonRemoveStudent;
    private DefaultListModel<Student> studentListData;


    public StudentGUI(){
        setContentPane(panel1);
        setSize(500,500);
        setTitle("Student List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentListData = new DefaultListModel<>();
        studentList.setModel(studentListData);
    }

    public String getFirstName() {
        return InputFirstName.getText();
    }
    public String getLastName() {
        return InputLastName.getText();
    }
    public String getStudentID() {
        return InputSID.getText();
    }
    public Student getSelectedStudent(){
        return studentList.getSelectedValue();
    }

    public void addStudent(Student student){
        studentListData.addElement(student);
    }
    public void removeStudent(Student student){
        studentListData.removeElement(student);
    }
    public void clearForm(){
        InputFirstName.setText("");
        InputLastName.setText("");
        InputSID.setText("");
    }

    public void setAddStudentListener(ActionListener listener) {
        buttonAddStudent.addActionListener(listener);
    }
    public void setRemoveStudentListener(ActionListener listener) {
        buttonRemoveStudent.addActionListener(listener);
    }
    public void showError(String error){
        JOptionPane.showMessageDialog(null, error);
    }
}
