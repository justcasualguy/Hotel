package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalProperties {
    private static Properties global;
    private final String path = "/global.properties";

    public static void init(){
        try {
            InputStream stream = GlobalProperties.class.getClassLoader().getResourceAsStream("global.properties");
            global.load(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String name){
        if(global ==null) {
            global = new Properties();
            init();
        }
        return global.getProperty(name);
    }
    public static void tryProp(){
        InputStream stream = GlobalProperties.class.getClassLoader().getResourceAsStream("global.properties");
        System.out.println(stream);
    }
}
