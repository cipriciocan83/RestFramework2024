package api.utilities;

import java.util.ResourceBundle;

public class Utils {
    public static String getUrlFromPropertiesFile( String key) {
        // loads the properties file
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes.getString(key);
    }
}
