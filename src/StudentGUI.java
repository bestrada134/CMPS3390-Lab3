import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame{
    private JPanel panel1;
    private JList<String> studentList;
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

    public StudentGUI(){
        setContentPane(panel1);
        setSize(500,500);
        setTitle("Student List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> studentListData = new DefaultListModel<>();

        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = InputFirstName.getText();
                String lastName = InputLastName.getText();
                String studentID = InputSID.getText();
                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    return;
                }

                String element = String.format("%s %s (%s)", firstName,lastName,studentID);
                studentListData.addElement(element);
                studentList.setModel(studentListData);
                InputFirstName.setText("");
                InputLastName.setText("");
                InputSID.setText("");

                InputFirstName.grabFocus();
            }
        });
        buttonRemoveStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIndex = studentList.getSelectedIndex();
                if(studentIndex < 0){
                    return;
                }
                studentListData.remove(studentIndex);
            }
        });
    }
}
