/**
 * 2016-07-12: Created by Danial Goodwin
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// More info: https://www.hackerrank.com/challenges/can-you-access
public class ReflectionPractice {

    private static void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        int num = 7;
        try {
//            Inner innerObject = new Inner();
//            Inner.Private priv = innerObject.new Private();
            Inner.Private privateObject = new Inner().new Private();
            Class<?> privateClass = Class.forName("ReflectionPractice$Inner$Private");
            Method powMethod = privateClass.getDeclaredMethod("powerof2", int.class);
            powMethod.setAccessible(true);
            String answer = (String) powMethod.invoke(privateObject, num);
            log(answer);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }

}
