package casper;

import org.apache.commons.io.IOUtils;
import pojo.IndividualTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by kelvinchin on 6/29/15.
 */
public class RunCasperPhantom {
    public static String runCasperPhantomCommand(String testName, String serverEnvironment, ArrayList<IndividualTest> allTestArray, String funcTestsPath){
        String output = "";
        try {
            System.out.println("Server Environment: " + serverEnvironment);
            String serverURL = getServerEnvironmentURL(serverEnvironment);
            for(int x = 0; x < allTestArray.size(); x++){
                IndividualTest temp = allTestArray.get(x);
                String tempTestName = temp.getTestPrintText();
//                System.out.println("tempTestName="+tempTestName);
                if(testName.equals(tempTestName))
                {
                    String fullTestPath = temp.getFullTestPath();
//                    System.out.println("fullTestPath="+fullTestPath);
//                    System.out.println("serverURL=" + serverURL);
//                    System.out.println("funcTestsPath="+funcTestsPath);
//                    String commandLineString = "/usr/bin/open -a Terminal -c && cd " + funcTestsPath + " && casperjs test " + fullTestPath + " --verbose--log-level=debug --includes=include.js --pre=pre.js --site=" + serverURL + " --ignore-ssl-errors=true --web-security=false";
//                    System.out.println("user.dir = " + System.getProperty("user.dir"));
//                    System.out.println("os.version="+System.getProperty("os.version"));
//                    System.out.println(System.getProperty("os.name"));
//                    System.out.println("fullTestPath="+fullTestPath);
                    String casperCommand = "casperjs test " + fullTestPath + " --verbose--log-level=debug --includes=include.js --pre=pre.js --site=" + serverURL + " --ignore-ssl-errors=true --web-security=false";

                    ProcessBuilder pb;

                    if(System.getProperty("os.name").contains("Windows")) {
                        pb = new ProcessBuilder("cmd", "/c", " cd " + funcTestsPath + " && " + casperCommand);
                    }
                    else
                    {
                        pb = new ProcessBuilder("/bin/bash", "-c", " cd " + funcTestsPath + " ; " + casperCommand);// + "| sed -E \"s/\\x1B\\[([0-9]{1,2}(;[0-9]{1,2})?)?[m|K]//g\"");
                    }


                    Process process = pb.start();
                    int errCode = process.waitFor();
                    output = output(process.getInputStream());


                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("DONE!");

        return output;
    }

    private static String output(InputStream inputStream) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.replace("[37;46;1m","").replace("\u001B[32;1m", "").replace("\u001B[33m#", "").replace("\u001B[37;42;1m", "").replace("[0m","").trim();
                sb.append(line + System.getProperty("line.separator"));
            }

        } finally {
            br.close();
        }
        return sb.toString();
    }

    private static String getServerEnvironmentURL(String serverEnvironment){
        String serverURL;

        if(serverEnvironment.equals("Prod")){
            serverURL = "http://www.hudl.com";
        }
        else if(serverEnvironment.equals("Stag")){
            serverURL = "http://www.staghudl.com";
        }
        else if(serverEnvironment.contains("Thor")){
            String[] parts = serverEnvironment.split(" ");
            serverURL = "http://" + parts[1] +".thorhudl.com";
        }
        else {
            serverURL = "http://" + serverEnvironment.trim() +".thorhudl.com";
        }

//        System.out.println("serverURL="+serverURL);
        return serverURL;
    }
}
