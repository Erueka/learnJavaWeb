package Annotation;

import java.lang.annotation.Annotation;

/**
 * @author Ling
 * Created on 2019/11/8
 */
public @interface MyAnnotation{
    String name() default "zhangsan";
    int num();
    Override over();
    int[] nums();
}
