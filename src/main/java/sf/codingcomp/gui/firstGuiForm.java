package sf.codingcomp.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jskelton8 on 3/23/2017.
 */
public class firstGuiForm {
    private JButton submitButton;
    private JPanel firstPanel;

    public firstGuiForm() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "My first form message!");
            }
        });
    }

    public static void main(String[] args){
        JFrame jFrame = new JFrame("StartUpClass");
        jFrame.setContentPane(new firstGuiForm().firstPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
