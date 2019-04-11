package azs.Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)

@Retention(RetentionPolicy.RUNTIME)
public @interface Constructor_Annotation {
    String value()default "默认构造方法";//定义一个具有默认值的String成员变量
}
