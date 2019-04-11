package azs.Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface File_Method_Parameter_Annotation {
    String describe();
    Class type() default void.class;//定义一个具有默认值的Class型成员
}
