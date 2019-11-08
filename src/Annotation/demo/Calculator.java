package Annotation.demo;

/**
 * @author Ling
 * Created on 2019/11/8
 */
public class Calculator {
    @Check
    public void add(){
        int res = 1 + 1;
        System.out.println("1+1="+res);
    }

    @Check
    public void sub() {
        int res = 1 - 1;
        System.out.println("1-1="+res);
    }

    @Check
    public void div() {
        int res = 3/0;
        System.out.println("3/0="+res);
    }
}
