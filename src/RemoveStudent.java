import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RemoveStudent extends JFrame{
    private JTextField adm;
    private JButton cancel;
    private JButton rem;
    private JPanel remv;
    JFrame f=new JFrame("Remove Student");
    RemoveStudent(){
        f.setContentPane(remv);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);
        f.setResizable(false);

        rem.addActionListener(e -> {
            String a = adm.getText();
            if (a.equals("")) {
                JOptionPane.showMessageDialog(rem, "All Fields Must Be Filled");
            } else {
                int admno = Integer.parseInt(a);
                try {
                    String url = Keys.URL;
                    String user = Keys.USER;
                    String password = Keys.PASSWORD;
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement sta = con.createStatement();
                    String query = "delete from studentdetails where adm=" + admno;
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(rem, "Data not present.");
                    } else {
                        JOptionPane.showMessageDialog(rem, "Student details is successfully removed");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                adm.setText(null);
            }
        });
        cancel.addActionListener(e -> {
            f.dispose();
            new AdminWindow();
        });
    }
}
