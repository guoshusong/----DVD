package azs.Generic;

public class UseCase1 {
    public enum Constants2{
        CONSTANTS_A,CONSTANTS_B
    }
    //定义一个方法，参数为枚举类型对象
    public static void doit2(Constants2 c){
        switch (c){
            case CONSTANTS_A:
                System.out.println("doit2() Constants_A");
                break;
            case CONSTANTS_B:
                System.out.println("doit2() Constants_B");
                break;
        }
    }

    public static void main(String[] args) {
        UseCase1.doit2(Constants2.CONSTANTS_A);
        UseCase1.doit2(Constants2.CONSTANTS_B);
    }
}
