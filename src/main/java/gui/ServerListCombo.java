package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by kelvinchin on 6/26/15.
 */
public class ServerListCombo {
    public static JComboBox getServerListCombo()
    {
        final JComboBox jComboBox = new JComboBox();
        jComboBox.setEditable(false);


        jComboBox.addItem("Prod");
        jComboBox.addItem("Stag");
        jComboBox.addItem("Branch Name");

        for(int x = 1; x <= 38; x++)
        {
            jComboBox.addItem("Thor " + x);
        }

        jComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = jComboBox.getSelectedItem();
                boolean editable = selectedItem instanceof String && ((String) selectedItem).equals("Branch Name");
                jComboBox.setEditable(editable);
            }
        });

        /*
         * Here you can add a new item to your JComboBox when it becomes editable
         */
        jComboBox.getEditor().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object newItem = jComboBox.getEditor().getItem();
                DefaultComboBoxModel dcbm = (DefaultComboBoxModel) jComboBox.getModel();
                dcbm.addElement(newItem);
                dcbm.setSelectedItem(newItem);
            }
        });

        return jComboBox;
    }
}
