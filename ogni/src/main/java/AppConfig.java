import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final String CONFIG_FILE = "config.properties";
    private static final String APP_CONFIG_FILE = "application.properties";

    public static void main(String[] args) {
        Properties configProperties = loadProperties(CONFIG_FILE);
        Properties appProperties = loadProperties(APP_CONFIG_FILE);

        String username = appProperties.getProperty("db.username", configProperties.getProperty("db.username"));
        String password = appProperties.getProperty("db.password", configProperties.getProperty("db.password"));

        // Use username and password as needed
    }

    private static Properties loadProperties(String filename) {
        Properties properties = new Properties();
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream(filename)) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
