package pojo;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kelvinchin on 6/28/15.
 */
public class TestList {
    ArrayList<String> fullPathOfTests = new ArrayList<String>();
    ArrayList<String> testNameOnly = new ArrayList<String>();
    ArrayList<String> testPathOnly = new ArrayList<String>();
    ArrayList<String> testCleanPath = new ArrayList<String>();
    ArrayList<String> testNameNoJS = new ArrayList<String>();

    public TestList(List<File> listOfTests){

        for(int x = 0; x < listOfTests.size(); x++)
        {
            this.testNameOnly.add(listOfTests.get(x).getName());
            this.testPathOnly.add(listOfTests.get(x).getParentFile().getAbsolutePath());
            this.fullPathOfTests.add(listOfTests.get(x).getAbsolutePath());

            String fullPath = listOfTests.get(x).getAbsolutePath();
//            System.out.println("fullpath= " + fullPath);
//            System.out.println("File.separator="+File.separator);

            Pattern pattern;
            if(System.getProperty("os.name").contains("Windows")) {
                pattern = Pattern.compile("(.*)(monolith.*|cluster.*)(\\\\)");
            }
            else
            {
                pattern = Pattern.compile("(.*)(monolith.*|cluster.*)(" + File.separator + ")");
            }
            Matcher matcher = pattern.matcher(fullPath);
            while (matcher.find()) {
                this.testCleanPath.add(matcher.group(2));
            }

            String temp = this.testNameOnly.get(x);
            Pattern pattern2 = Pattern.compile("(.*)\\.js");
            Matcher matcher2 = pattern2.matcher(temp);
            while (matcher2.find()) {
                this.testNameNoJS.add(matcher2.group(1));
            }
        }
    }

    public ArrayList<String> getTestNameNoJS() {
        return testNameNoJS;
    }

    public void setTestNameNoJS(ArrayList<String> testNameNoJS) {
        this.testNameNoJS = testNameNoJS;
    }

    public ArrayList<String> getTestCleanPath() {
        return testCleanPath;
    }

    public void setTestCleanPath(ArrayList<String> testCleanPath) {
        this.testCleanPath = testCleanPath;
    }

    public ArrayList<String> getFullPathOfTests() {
        return fullPathOfTests;
    }

    public void setFullPathOfTests(ArrayList<String> fullPathOfTests) {
        this.fullPathOfTests = fullPathOfTests;
    }

    public ArrayList<String> getTestNameOnly() {
        return testNameOnly;
    }

    public void setTestNameOnly(ArrayList<String> testNameOnly) {
        this.testNameOnly = testNameOnly;
    }

    public ArrayList<String> getTestPathOnly() {
        return testPathOnly;
    }

    public void setTestPathOnly(ArrayList<String> testPathOnly) {
        this.testPathOnly = testPathOnly;
    }


}
