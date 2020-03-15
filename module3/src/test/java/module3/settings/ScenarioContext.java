package module3.settings;

public class ScenarioContext {

//    static {
//        new ScenarioContext();
//    }

    static final class ContextLocal extends ThreadLocal<Context> {

        @Override
        protected Context initialValue() {
            return new Context();
        }
    }

    private static final ThreadLocal<Context> userThreadLocal = new ContextLocal();

    public static Context context() {
        return userThreadLocal.get();
    }
}
