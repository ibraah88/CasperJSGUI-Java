package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kelvinchin on 6/26/15.
 */
public class MenuBarObject{

    public static JMenuBar getMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu optionsMenu = new JMenu("Options");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem fileSearch = new JMenuItem("Search");
        fileSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked Search");
            }
        });

        JMenuItem fileExport = new JMenuItem("Export Test List (To Desktop)");
        fileExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked Export Test List (To Desktop)");
            }
        });

        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit");
            }
        });

        fileMenu.add(fileSearch);
        fileMenu.add(fileExport);
        fileMenu.add(fileExit);

        JMenuItem optionsAutoCloseCmd = new JMenuItem("Auto Close Cmd");
        optionsAutoCloseCmd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Auto Close Cmd");
            }
        });

        JMenuItem optionsUseCommandPrompt = new JMenuItem("Use Command Prompt");
        optionsUseCommandPrompt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Use Command Prompt");
            }
        });

        optionsMenu.add(optionsAutoCloseCmd);
        optionsMenu.add(optionsUseCommandPrompt);

        JMenuItem helpRerunSetup = new JMenuItem("Re-run Setup");
        helpRerunSetup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Re-run Setup");
            }
        });

        JMenuItem helpCheckForUpdates = new JMenuItem("Check for Updates");
        helpCheckForUpdates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Check for Updates");
            }
        });

        JMenuItem helpSetupCasperPhantom = new JMenuItem("Setup Casper/Phantom");
        helpSetupCasperPhantom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Setup Casper/Phantom");

            }
        });

        JMenuItem helpAbout = new JMenuItem("About");
        helpAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("About");
            }
        });

        helpMenu.add(helpRerunSetup);
        helpMenu.add(helpCheckForUpdates);
        helpMenu.add(helpSetupCasperPhantom);
        helpMenu.add(helpAbout);

        jMenuBar.add(fileMenu);
        jMenuBar.add(optionsMenu);
        jMenuBar.add(helpMenu);

        return jMenuBar;
    }
}

