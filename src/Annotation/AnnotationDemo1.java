package Annotation;

/**
 * @author Ling
 * Created on 2019/11/8
 */

@SuppressWarnings("all")
public class AnnotationDemo1 {

    @Override
    public String toString() {
        return "HaHa";
    }

    @Deprecated
    public void show1() {

    }

    public void show2() {

    }

    @MyAnnotation(num = 3, over = @Override, nums = {1, 2, 3})
    public void demo() {
        show1();
        show2();
    }
}
