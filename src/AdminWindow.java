import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new AddStudent();
            }
        });
        removeStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new RemoveStudent();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Home();
            }
        });
    }
}
