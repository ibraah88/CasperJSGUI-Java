package toolbox;

/**
 * Created by kelvinchin on 6/27/15.
 */

/**
 * System properties. The following properties are guaranteed to be defined:
 * <dl>
 * <dt>java.version         <dd>Java version number
 * <dt>java.vendor          <dd>Java vendor specific string
 * <dt>java.vendor.url      <dd>Java vendor URL
 * <dt>java.home            <dd>Java installation directory
 * <dt>java.class.version   <dd>Java class version number
 * <dt>java.class.path      <dd>Java classpath
 * <dt>os.name              <dd>Operating System Name
 * <dt>os.arch              <dd>Operating System Architecture
 * <dt>os.version           <dd>Operating System Version
 * <dt>file.separator       <dd>File separator ("/" on Unix)
 * <dt>path.separator       <dd>Path separator (":" on Unix)
 * <dt>line.separator       <dd>Line separator ("\n" on Unix)
 * <dt>user.name            <dd>User account name
 * <dt>user.home            <dd>User home directory
 * <dt>user.dir             <dd>User's current working directory
 * </dl>
 */


/*
WINDOWS

java.version = 1.8.0_45
java.vendor = Oracle Corporation
java.vendor.url = http://java.oracle.com/
java.home = C:\Program Files\Java\jdk1.8.0_45\jre
java.class.version = 52.0
java.class.path = 1.8.0_45
os.name = Windows 8.1
os.arch = amd64
os.version = 6.3
user.name = kelvin.chin
user.name = kelvin.chin
user.home = C:\Users\kelvin.chin
user.dir = C:\Users\kelvin.chin\IdeaProjects\HelloWorld

 */


/*
MAC

java.version = 1.8.0_45
java.vendor = Oracle Corporation
java.vendor.url = http://java.oracle.com/
java.home = /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre
java.class.version = 52.0
java.class.path = 1.8.0_45
os.name = Mac OS X
os.arch = x86_64
os.version = 10.10.3
user.name = kelvinchin
user.name = kelvinchin
user.home = /Users/kelvinchin
user.dir = /Users/kelvinchin/IdeaProjects/CasperJSGUI




*/


public class BasicFunctions {
    public static String getOperatingSystem(){
        System.out.println("java.version = " + System.getProperty("java.version"));
        System.out.println("java.vendor = " + System.getProperty("java.vendor"));
        System.out.println("java.vendor.url = " + System.getProperty("java.vendor.url"));
        System.out.println("java.home = " + System.getProperty("java.home"));
        System.out.println("java.class.version = " + System.getProperty("java.class.version"));
        System.out.println("java.class.path = " + System.getProperty("java.version"));
        System.out.println("os.name = " + System.getProperty("os.name"));
        System.out.println("os.arch = " + System.getProperty("os.arch"));
        System.out.println("os.version = " + System.getProperty("os.version"));
        System.out.println("user.name = " + System.getProperty("user.name"));
        System.out.println("user.name = " + System.getProperty("user.name"));
        System.out.println("user.home = " + System.getProperty("user.home"));
        System.out.println("user.dir = " + System.getProperty("user.dir"));

        return "";
    }

}
