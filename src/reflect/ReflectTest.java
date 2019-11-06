package reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Ling
 * Created on 2019/11/6
 * 需求：写一个"框架"，不能改变该类的任何代码的前提下，
 * 可以帮我们创建任意类的对象，并且执行其中任意方法
 */
public class ReflectTest {
    /*
    	* 实现：
			1. 配置文件
			2. 反射
		* 步骤：
			1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
			2. 在程序中加载读取配置文件
			3. 使用反射技术来加载类文件进内存
			4. 创建对象
			5. 执行方法
     */
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        // load()方法：从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象
        // 怎么找到配置文件呢？（获取class目录文件下的配置文件）
        // 通过获取类加载器，类加载器对象有一个getource方法
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        // 获取配置文件的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

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
