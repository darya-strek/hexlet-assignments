package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;

    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        writeDataToFile(data);
    }

    private void writeDataToFile(Map<String, String> dataMap) {
        String dataString = Utils.serialize(dataMap);
        Utils.writeFile(this.path, dataString);
    }

    private Map<String, String> getDataFromFile() {
        String dataString = Utils.readFile(this.path);
        Map<String, String> dataMap = Utils.unserialize(dataString);
        return dataMap;
    }

    @Override
    public void set(String key2, String value2) {
        Map<String, String> dataMap = this.getDataFromFile();
        dataMap.remove(key2);
        dataMap.put(key2, value2);
        this.writeDataToFile(dataMap);
    }

    @Override
    public void unset(String key) {
        Map<String, String> dataMap = this.getDataFromFile();
        dataMap.remove(key);
        this.writeDataToFile(dataMap);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> dataMap = this.getDataFromFile();
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return this.getDataFromFile();
    }
}
// END
