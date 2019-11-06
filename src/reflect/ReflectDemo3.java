package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Ling
 * Created on 2019/11/6
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception{
        Class personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        Method eat = personClass.getMethod("eat");
        Person p = new Person();
        eat.invoke(p);

        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}
