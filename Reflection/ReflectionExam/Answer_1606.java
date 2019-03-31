package azs.Reflection.ReflectionExam;

import java.lang.reflect.Array;

public class Answer_1606 {
    public static void main(String[] args) {
        Test test = new Test();
        test.print();
        test.is = (int[]) addArrayLength(test.is, 10);
        test.ss = (String[]) addArrayLength(test.ss, 10);

        test.print();
    }

    public static Object addArrayLength(Object array, int newLength) {
        Object newArray = null;
        Class componentType = array.getClass().getComponentType();
        newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(array, 0, newArray, 0, Array.getLength(array));
        return newArray;
    }

    static class Test {
        public int[] is = {1, 2, 3};
        public String[] ss = {"a", "b", "c"};

        public void print() {
            for (int index = 0; index < is.length; index++) {
                System.out.println("is[" + index + "] = " + is[index]);
            }
            System.out.println();
            for (int index = 0; index < ss.length; index++) {
                System.out.println("ss[" + index + "] = " + ss[index]);
            }
            System.out.println();
        }
    }
}
