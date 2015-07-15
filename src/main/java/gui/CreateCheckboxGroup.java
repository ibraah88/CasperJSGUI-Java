package gui;

import pojo.IndividualTest;
import pojo.TestList;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kelvinchin on 6/27/15.
 */


public class CreateCheckboxGroup {
    public static ArrayList<IndividualTest> getIndividualTestArrayList(TestList testList){
        ArrayList<String> testNameOnly = testList.getTestNameOnly();
        ArrayList<String> testCleanPath = testList.getTestCleanPath();
        ArrayList<String> testNameNoJS = testList.getTestNameNoJS();
        ArrayList<String> testPathOnly = testList.getTestPathOnly();
        ArrayList<String> fullPathOfTests = testList.getFullPathOfTests();



        ArrayList<IndividualTest> individualTestArrayList = new ArrayList<IndividualTest>();

        for(int x = 0; x < testNameOnly.size(); x++)
        {
            IndividualTest temp = new IndividualTest();
            temp.setFullTestPath(fullPathOfTests.get(x));
            temp.setJustTestName(testNameOnly.get(x));
            temp.setTestPath(testPathOnly.get(x));
            temp.setTestPrintText(testNameNoJS.get(x) + " ----- " + "(" + testCleanPath.get(x) + ")");
            individualTestArrayList.add(temp);
        }

        return individualTestArrayList;
    }

    public static ArrayList<JCheckBox> getFinalCheckboxList(TestList testList){
        ArrayList<String> testNameOnly = testList.getTestNameOnly();
        ArrayList<String> testCleanPath = testList.getTestCleanPath();
        ArrayList<String> testNameNoJS = testList.getTestNameNoJS();
        ArrayList<JCheckBox> allCheckboxes = new ArrayList<JCheckBox>();

        ArrayList<String> finalPrint = new ArrayList<String>();
        for(int x = 0; x < testNameOnly.size(); x++) {
            finalPrint.add(testNameNoJS.get(x) + " ----- " + "(" + testCleanPath.get(x) + ")");
        }

        Collections.sort(finalPrint);

        for(int x = 0; x < finalPrint.size(); x++) {
            JCheckBox a = new JCheckBox(finalPrint.get(x));
            allCheckboxes.add(a);
        }

        return allCheckboxes;
    }
}
