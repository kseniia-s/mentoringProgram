package module3.settings;

import module3.pageObjects.BasePage;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Object> data = new HashMap<>();
    private BasePage currentPage;

    public BasePage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(BasePage currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isDataSet(String key) {
        return data.containsKey(key);
    }

    public void setData(String key, Object value) {
        data.put(key, value);
    }

    public Object getData(String key) {
        return data.get(key);
    }
}
