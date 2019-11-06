package reflect;

import java.lang.reflect.Constructor;

/**
 * @author Ling
 * Created on 2019/11/6
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception{
        Class personClass = Person.class;
        /*
        		2. 获取构造方法们
			* Constructor<?>[] getConstructors()
			* Constructor<T> getConstructor(类<?>... parameterTypes)

			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			* Constructor<?>[] getDeclaredConstructors()
         */
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        // 创建对象
        Object person = constructor.newInstance("张三", 3);
        System.out.println(person);

        // 创建空参的对象，使用简化的方法
        Object o = personClass.newInstance();
        System.out.println(o);
    }
}
