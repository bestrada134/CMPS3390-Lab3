import Controllers.StudentController;
import Models.StudentData;
import Views.StudentGUI;

public class StudentApp {
    public static void main(String[] args) {
        StudentGUI view = new StudentGUI();
        StudentData model = new StudentData();
        new StudentController(model, view);
        view.setVisible(true);
    }
}
