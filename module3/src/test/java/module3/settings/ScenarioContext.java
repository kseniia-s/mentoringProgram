package module3.settings;

public class ScenarioContext {

    private static ThreadLocal<Context> userThreadLocal = new ThreadLocal<>();

    public static void initContext(Context context) {
        userThreadLocal.set(context);
    }

    public static Context context() {
        return userThreadLocal.get();
    }

}
