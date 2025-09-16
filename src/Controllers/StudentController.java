package Controllers;

import Models.Student;
import Models.StudentData;
import Views.StudentGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
    public StudentController(StudentData model, StudentGUI view) {
        view.setAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                String studentID = view.getStudentID();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    view.showError("You must fill out all fields");
                    return;
                }

                Student element = new Student(firstName, lastName, Integer.parseInt(studentID));
                model.addStudent(element);
                view.addStudent(element);
                view.clearForm();
            }
        });
        view.setRemoveStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = view.getSelectedStudent();
                if(student == null){
                    view.showError("You must select a student");
                    return;
                }

                model.removeStudent(student);
                view.removeStudent(student);
            }
        });
    }
}
