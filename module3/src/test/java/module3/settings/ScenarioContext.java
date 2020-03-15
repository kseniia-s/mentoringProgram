package module3.settings;

public class ScenarioContext {

    public static void initContext(Context context) {
        userThreadLocal.set(context);
    }

    private static ThreadLocal<Context> userThreadLocal = new ThreadLocal<>();

    public static Context context() {
        return userThreadLocal.get();
    }

}
