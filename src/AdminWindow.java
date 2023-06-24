import javax.swing.*;
import java.awt.*;

public class AdminWindow extends JFrame{
    private JButton addStudentButton;
    private JButton removeStudentButton;
    private JPanel admin;
    private JButton back;
    JFrame f=new JFrame("Admin Window");

    public AdminWindow() {
        f.setContentPane(admin);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);
        f.setResizable(false);

        addStudentButton.addActionListener(e -> {
            f.dispose();
            new AddStudent();
        });
        removeStudentButton.addActionListener(e ->  {
                f.dispose();
                new RemoveStudent();
        });
        back.addActionListener(e -> {
                f.dispose();
                new Home();
        });
    }
}
