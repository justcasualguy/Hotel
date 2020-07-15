package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class XPaths {
    private static Properties xpaths;
    private final String path = "/xpaths.properties";

    public static void init(){
        try {
            InputStream stream = XPaths.class.getClassLoader().getResourceAsStream("xpaths.properties");
            xpaths.load(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getXPath(String name){
        if(xpaths==null) {
            xpaths = new Properties();
            init();
        }
        return xpaths.getProperty(name);
    }
}
