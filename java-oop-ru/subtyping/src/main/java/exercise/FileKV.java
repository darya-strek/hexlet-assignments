package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> data;

    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        writeDataToFile(data);
    }

    private void writeDataToFile(Map<String, String> data) {
        String dataString = Utils.serialize(data);
        Utils.writeFile(this.path, dataString);
    }

    private Map<String, String> getDataFromFile() {
        String dataString = Utils.readFile(this.path);
        Map<String, String> data = Utils.unserialize(dataString);
        return data;
    }

    @Override
    public void set(String key2, String value2) {
        Map<String, String> data = this.getDataFromFile();
        data.remove(key2);
        data.put(key2, value2);
        this.writeDataToFile(data);
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = this.getDataFromFile();
        data.remove(key);
        this.writeDataToFile(data);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = this.getDataFromFile();
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return this.getDataFromFile();
    }
}
// END
