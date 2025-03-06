package config;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class ConfigReader {
    private static Map<String, String> config;

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.yaml")) {
            if (input == null) {
                throw new RuntimeException("config.yaml not found in resources folder");
            }
            Yaml yaml = new Yaml();
            config = yaml.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.yaml: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return config.get(key);
    }
}
