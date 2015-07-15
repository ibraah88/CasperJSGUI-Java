package run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DialogTest {
    static final SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

    public static void main(String[] args) {

        final JFrame frame = new JFrame("Dialog test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createPanelToPopDialog(frame));
        frame.setSize(500, 200);
        frame.show();
    }

    static JPanel createPanelToPopDialog(final JFrame parent) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton button = new JButton("Pop a Dialog");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(parent, true);
                dialog.add(createPanelToPopDialog(parent));
                dialog.setSize(500, 200);
                dialog.show();
            }
        });
        panel.add(button, BorderLayout.SOUTH);
        panel.add(new JLabel("Created at " + SDF.format(new Date())));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }
}