package run;

import casper.RunCasperPhantom;
import gui.CreateCheckboxGroup;
import gui.DirectoryBrowser;
import gui.MenuBarObject;
import gui.ServerListCombo;
import pojo.IndividualTest;
import pojo.TestList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class RunMe {
    private static JFrame frame = new JFrame("Shitty Java GOO (for Mac)");

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createJFrame();
            }
        });
    }

    private static void createJFrame(){
        DirectoryBrowser directoryBrowser = new DirectoryBrowser();
        final String path = directoryBrowser.getFuncTestsLocation();
//        System.out.println(path);
        java.util.List<File> allTests = directoryBrowser.getAllTests(path);
        TestList testListObject = new TestList(allTests);

        final JComboBox jComboBox = ServerListCombo.getServerListCombo();
        final ArrayList<IndividualTest> allTestArray = CreateCheckboxGroup.getIndividualTestArrayList(testListObject);

        final ArrayList<JCheckBox> allCheckboxes = CreateCheckboxGroup.getFinalCheckboxList(testListObject);
        Box box = Box.createVerticalBox();


        for(int x = 0; x < allCheckboxes.size(); x++) {
            box.add(allCheckboxes.get(x));
        }

        JScrollPane jscrlpBox = new JScrollPane(box);

        frame.setJMenuBar(MenuBarObject.getMenuBar());
        frame.add(jComboBox, BorderLayout.EAST);
        frame.add(jscrlpBox, BorderLayout.WEST);

        JButton button = new JButton("Run");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String whichServer = jComboBox.getSelectedItem().toString();

                for (int x = 0; x < allCheckboxes.size(); x++) {
                    JCheckBox temp = allCheckboxes.get(x);
                    if (temp.isSelected()) {
                        String output = RunCasperPhantom.runCasperPhantomCommand(temp.getText(), whichServer, allTestArray, path);
                        JTextArea jTextArea = new JTextArea();
                        jTextArea.append(output);
                        System.out.println(output);
                        JOptionPane.showMessageDialog(frame, jTextArea, temp.getText(), JOptionPane.PLAIN_MESSAGE);

                    }
                }
            }
        });


        frame.add(button, BorderLayout.PAGE_END);
        frame.setSize(770, 685);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}