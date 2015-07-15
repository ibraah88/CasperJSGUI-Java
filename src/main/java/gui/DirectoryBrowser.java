package gui;

import org.apache.commons.io.FileUtils;
import toolbox.Constants;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.prefs.Preferences;

/**
 * Created by kelvinchin on 6/27/15.
 */
public class DirectoryBrowser {
    private  Preferences prefs = Preferences.userRoot().node(this.getClass().getName());


    public void setExistingPath(String path)
    {
        prefs.put(Constants.FUNC_TESTS_DIR, path);
    }

    public String getFuncTestsLocation(){
//        prefs.remove(Constants.FUNC_TESTS_DIR);
        String lastOutputDir = prefs.get(Constants.FUNC_TESTS_DIR, "");
        File testDir = new File(lastOutputDir);
        if(lastOutputDir.trim().equalsIgnoreCase("") || lastOutputDir == null || !testDir.exists()) {
//            while(!lastOutputDir.contains("skywalker") || !lastOutputDir.contains("FuncTests")) {
                JOptionPane.showMessageDialog(null, "Choose the skywalker FuncTests directory");
                JFileChooser f = new JFileChooser();

                f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                f.showSaveDialog(null);

                setExistingPath(f.getSelectedFile().getAbsolutePath());

                lastOutputDir = f.getSelectedFile().getAbsolutePath();
//            }
        }
        return lastOutputDir;
    }

    public List<File> getAllTests(String path){
        File dir = new File(path + File.separator + "tests");
        String[] filesTypes = {"js"};
        List<File> allTests = (List<File>) FileUtils.listFiles(dir, filesTypes, true);

//        for(int x = 0; x < allTests.size(); x++)
//        {
//            System.out.println(allTests.get(x));
//        }

        try{
//            System.out.println("absolluteFile = " + allTests.get(0).getAbsoluteFile());
//            System.out.println("getName = " + allTests.get(0).getName()); //just name
//            System.out.println("CanonicalPath = " + allTests.get(0).getCanonicalPath());
//            System.out.println("getPath = " + allTests.get(0).getPath());
//            System.out.println("getParentFile = " + allTests.get(0).getParentFile().getAbsolutePath());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allTests;
    }
}
