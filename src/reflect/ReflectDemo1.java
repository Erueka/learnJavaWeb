package reflect;

import java.lang.reflect.Field;

/*
* Class对象功能：
	* 获取功能：
		1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取指定名称的 public修饰的成员变量

			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)
		2. 获取构造方法们
			* Constructor<?>[] getConstructors()
			* Constructor<T> getConstructor(类<?>... parameterTypes)

			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			* Constructor<?>[] getDeclaredConstructors()
		3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)

		4. 获取全类名
			* String getName()
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        /*
            * Field：成员变量
            * 操作：
                1. 设置值
                    * void set(Object obj, Object value)
                2. 获取值
                    * get(Object obj)

                3. 忽略访问权限修饰符的安全检查
                    * setAccessible(true):暴力反射
         */
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field f : fields)
            System.out.println(f);

        System.out.println("----------------------");
        Field a = personClass.getField("publicA");
        System.out.println(a);

        System.out.println("----------------------");
        // 获取对象成员变量publicA的值
        Person p = new Person();
        Object o = a.get(p);
        System.out.println(o);
        // 设置publicA的值
        a.set(p,"publicA");
        System.out.println(p);

        System.out.println("----------------------");
        // 无视修饰符，获取所有
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields)
            System.out.println(f);

        Field name = personClass.getDeclaredField("name");
        // 暴力反射
        name.setAccessible(true);
        name.set(p,"张三");
        Object o1 = name.get(p);
        System.out.println(o1);
    }
}
