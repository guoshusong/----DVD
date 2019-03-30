package azs.Reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Annotation;


public class Main_05 {
    public static void main(String[] args) {
        Class recordC = null;
        try {
            recordC = Class.forName("Record");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("-----构造方法的描述如下----");
        Constructor[] declaredConstructors = recordC.getDeclaredConstructors(); // 获取所有构造方法
        for (int i = 0; i < declaredConstructors.length; i++){
            Constructor constructor = declaredConstructors[i];
            if (constructor.isAnnotationPresent(Constructor_Annotation.class)){ // 查看是否具有指定类型
                Constructor_Annotation ca = (Constructor_Annotation)constructor.getAnnotation(Constructor_Annotation.class);
                System.out.println(ca.value());//获得注释信息
            }
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++){
                int length = parameterAnnotations[j].length;
                if (length == 0)//如果长度为0表示没有为该注释添加参数
                    System.out.println("未添加Annotation参数");
                else
                    for (int k = 0; k < length; k++){
                        File_Method_Parameter_Annotation pa = (File_Method_Parameter_Annotation)parameterAnnotations[j][k];
                        System.out.println(" " + pa.describe());//获得参数描述
                        System.out.println(" "+pa.type());//获得参数类型
                    }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("---字段的描述如下----");
        Field[] decalaredFields = recordC.getDeclaredFields();
        for (int i = 0; i < decalaredFields.length; i++){
            Field field = decalaredFields[i];
            if (field.isAnnotationPresent(File_Method_Parameter_Annotation.class)){
                File_Method_Parameter_Annotation fa = field.getAnnotation(File_Method_Parameter_Annotation.class);
                System.out.print("    " + fa.describe()); // 获得字段的描述
                System.out.println("    " + fa.type()); // 获得字段的类型
            }
        }
        System.out.println();

        System.out.println("---方法的描述如下-----");
        Method[] methods = recordC.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++){
            Method method = methods[i];
            if (method.isAnnotationPresent(File_Method_Parameter_Annotation.class)){
                File_Method_Parameter_Annotation ma = method.getAnnotation(File_Method_Parameter_Annotation.class);
                System.out.println(ma.describe());
                System.out.println(ma.type());
            }
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++){
                int length = parameterAnnotations[j].length; // 获得指定参数注释的长度
                if (length == 0) // 如果长度为0表示没有为该参数添加注释
                    System.out.println("    未添加Annotation的参数");
                else
                    for (int k = 0; k < length; k++) {
                        // 获得指定类型的注释
                        File_Method_Parameter_Annotation pa = (File_Method_Parameter_Annotation) parameterAnnotations[j][k];
                        System.out.print("    " + pa.describe()); // 获得参数的描述
                        System.out.println("    " + pa.type()); // 获得参数的类型
                    }
            }
            System.out.println();
        }
    }
}
