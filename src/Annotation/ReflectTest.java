package Annotation;

import java.lang.reflect.Method;

/**
 * @author Ling
 * Created on 2019/11/6
 * 需求：写一个"框架"，不能改变该类的任何代码的前提下，
 * 可以帮我们创建任意类的对象，并且执行其中任意方法
 *
 * 使用注解而不是配置文件
 */
@Reflect(className = "reflect.Person", methodName = "sleep")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 1、解析注解
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 下面这句其实就是再内存种生成了一个盖住是接口的子类实现对象；
        Reflect annotation = reflectTestClass.getAnnotation(Reflect.class);
        String className = annotation.className();
        String methodName = annotation.methodName();

        // 开始使用反射
        // 1、将类加载进内存
        Class aClass = Class.forName(className);
        // 2、创建对象
        Object obj = aClass.newInstance();
        // 3、获取method
        Method method = aClass.getMethod(methodName);
        // 4、执行method
        method.invoke(obj);
    }
    // 意义：改代码需要重新编译重新上线，而改配置文件改完就完事了。
    // 看到配置文件里有全类名，第一时间应该想到这里用了反射机理。
}