package Annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Ling
 * Created on 2019/11/8
 * 一个简单的测试框架
 */
public class Checker {
    public static void main(String[] args) throws IOException {
        // 获取对象
        Calculator calculator = new Calculator();
        // 获取字节码
        Class calculatorClasslass = calculator.getClass();
        // 获取方法
        Method[] methods = calculatorClasslass.getMethods();

        int count = 0;
        BufferedWriter bf = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method m : methods) {
            // 判断是否有Check注解
            if (m.isAnnotationPresent(Check.class)){
                try {
                    m.invoke(calculator);
                } catch (Exception e) {
                    // 保存错误信息
                    bf.write(m.getName()+"方法错误。");
                    bf.newLine();
                    bf.write("错误类型："+e.getCause().getClass().getSimpleName());
                    bf.newLine();
                    bf.write("错误原因："+e.getCause().getMessage());
                    bf.newLine();
                    bf.write("------------------------");
                    bf.newLine();
                }
            }
        }
        bf.write("total error: "+count);
        bf.close();
    }
}
