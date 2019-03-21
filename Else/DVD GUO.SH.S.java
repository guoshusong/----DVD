/*

郭树耸

DATE：2018-10-28

 */
import java.util.Scanner;

public class bake {
    public static void main(String[] args) {
        // 定义用于存储数组信息的数组
        String[] names = new String[10];// DVD 名称
        int[] status = new int[10];
        int[] count = new int[10];
        int[] date = new int[10];

        // 初始化DVD信息
        names[0] = "无双";
        status[0] = 1;// 已借出
        count[0] = 12;
        date[0] = 26;

        names[1] = "昨日青空";
        status[1] = 0;// 未借出
        count[1] = 0;
        date[1] = 0;

        names[2] = "奇缘历险";
        status[2] = 0;// 未借出
        count[2] = 10;
        date[2] = 0;

        Scanner input = new Scanner(System.in);

        // 菜单切换
        int choose = 0;
        do {
            System.out
                    .println("-----------欢迎使用王文今天就要撸死在这里DVD管理器------------------------------------------------");
            System.out
                    .println("-------------------------------------------------------------------------------");
            System.out.println("1.新增DVD");
            System.out.println("2.查看DVD");
            System.out.println("3.删除DVD");
            System.out.println("4.借出DVD");
            System.out.println("5.归还DVD");
            System.out.println("6.退出DVD");
            System.out
                    .println("------------------------------------------------------------------------------");
            System.out.print("\n请选择编号:");
            int no = input.nextInt();
            switch (no) {
                case 1:
                    System.out.println("------>新增DVD");
                    System.out.print("请输入新增DVD名称：");
                    String name = input.next();
                    // 定义标志性变量,用于记录第一次出现null的索引位置
                    int index = -1;// 默认表示没有null位置
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] == null) {
                            index = i;// 记录null位置的索引位置
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("货架已满，无法新增DVD!");
                    } else {
                        names[index] = name;
                        System.out.println("成功新增DVD《" + name + "》！");
                    }

                    System.out
                            .println("-------------------------------------------------------------------------");
                    System.out.print("输入0返回:");
                    choose = input.nextInt();
                    break;
                case 2:
                    System.out.println("------>查看DVD");
                    System.out.println("序号\t\tDVD名称\t\tDVD状态\t\t借出次数\t\t借出日期");
                    // 循环遍历数组
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null) {
                            System.out.println((i + 1) + "\t\t" + names[i] + "\t\t"
                                    + ((status[i] == 0) ? "未借出" : "已借出") + "\t\t"
                                    + count[i] + "\t\t" + date[i]);
                        }
                    }
                    System.out
                            .println("----------------------------------------------------------------------------");
                    System.out.print("输入0返回:");
                    choose = input.nextInt();
                    break;
                case 3:
                    System.out.println("------>删除DVD");
                    System.out.print("请输入要删除的DVD:");
                    String delName = input.next();
                    int delIndex = -1;// 标记没有被删除的dvd
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && names[i].equals(delName)
                                && status[i] == 0) {// 删除dvd存在，并可以删除
                            delIndex = i;
                            // 删除，其实就是移位
                            for (int j = delIndex; j < names.length - 1; j++) {
                                names[j] = names[j + 1];
                                status[j] = status[j + 1];
                                count[j] = count[j + 1];
                                date[j] = date[j + 1];
                            }
                            // 将最后一个索引位置的元素设置为null
                            names[names.length - 1] = null;
                            status[names.length - 1] = 0;
                            count[names.length - 1] = 0;
                            date[names.length - 1] = 0;
                            System.out.println("成功删除《" + delName + "》DVD!");
                            break;
                        }
                        if (names[i] != null && names[i].equals(delName)
                                && status[i] == 1) {
                            delIndex = i;
                            System.out.println("您要删除的《" + delName
                                    + "》DVD 被借出，不能删除！");
                            break;
                        }
                    }
                    if (delIndex == -1) {
                        System.out.println("被删除的《" + delName + "》DVD不存在！");
                    }

                    System.out
                            .println("---------------------------------------------------------------------------");
                    System.out.print("输入0返回:");
                    choose = input.nextInt();
                    break;
                case 4:
                    System.out.println("------>借出DVD");
                    System.out.print("请输入您要借的DVD名称：");
                    String borrowName = input.next();
                    boolean flag = false;// 默认表示要借出的DVD不存在
                    // 循环判断要借出的DVD是否存在
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && borrowName.equals(names[i])) {
                            if (status[i] == 0) {
                                flag = true;// 表示存在
                                System.out.print("请输入当前日期(号):");
                                date[i] = input.nextInt();// 接收日期并赋数组对应索引位置的元素中
                                status[i] = 1;// 更新状态
                                count[i] = count[i] + 1;// 更新次数
                                System.out.println("成功借出《" + borrowName + "》DVD!");
                                break;
                            } else {
                                flag = true;// 表示存在
                                System.out.println("您要借出的DVD《" + borrowName
                                        + "》已借出，不能借出！");
                                break;
                            }
                        }
                        // if(names[i]!=null && borrowName.equals(names[i]) &&
                        // status[i]==0){//借出的dvd名称存在并且状态为可借状态
                        // flag = true;//表示存在
                        // System.out.print("请输入当前日期(号):");
                        // date[i] = input.nextInt();//接收日期并赋数组对应索引位置的元素中
                        // status[i] = 1;//更新状态
                        // count[i] = count[i]+1;//更新次数
                        // break;
                        // }
                        // if(names[i]!=null && borrowName.equals(names[i]) &&
                        // status[i]==1){//借出的dvd名称存在并且状态为可借状态
                        // flag = true;//表示存在
                        // System.out.println("您要借出的DVD《"+borrowName+"》已借出，不能借出！");
                        // break;
                        // }
                    }
                    if (!flag) {
                        System.out.println("您要借出的《" + borrowName + "》DVD 不存在！");
                    }

                    System.out
                            .println("--------------------------------------------------------------------------");
                    System.out.print("输入0返回:");
                    choose = input.nextInt();
                    break;
                case 5:
                    System.out.println("------>归还DVD");
                    System.out.print("请输入您要归还的DVD名称:");
                    String reName = input.next();
                    // 循环遍历数组并查找归还DVD是否存在
                    boolean reflag = false;// 默认表示要归还的DVD不存在
                    // 循环判断要借出的DVD是否存在
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && reName.equals(names[i])) {
                            if (status[i] == 1) {//表示此DVD已借出
                                reflag = true;// 表示存在
                                System.out.print("请输入当前归还日期(号):");
                                int rdate = input.nextInt();
                                status[i] = 0;// 更新状态
                                System.out.println("成功归还《" + reName + "》DVD!");
                                // 计算租金
                                if (rdate > date[i]) {
                                    System.out.println("共租赁了" + (rdate - date[i])
                                            + "天，租金共计：" + (rdate - date[i]) + "元！");
                                } else {
                                    System.out.println("日期不合法！");
                                }
                                break;
                            }else {//未借出
                                reflag = true;// 表示存在
                                System.out.println("您要归还的DVD《" + reName + "》未借出，无法归还！");
                                break;
                            }
                        }
                    }
                    if (!reflag) {
                        System.out.println("您要归还的《" + reName + "》DVD 不存在！");
                    }

                    System.out
                            .println("--------------------------------------------------------------------------");
                    System.out.print("输入0返回:");
                    choose = input.nextInt();
                    break;
                case 6:
                    System.out.println("------>退出DVD");
                    System.exit(1);// 退出系统
                    break;

                default:
                    System.out.print("没有此功能！");
                    System.out
                            .println("--------------------------------------------------------------------------");
                    System.out.print("输入0返回:");
                    choose = input.nextInt();
                    break;
            }

        } while (choose == 0);
        System.out.println("感谢您的使用！");

    }

}
//作者：郭树耸        
//DATE:2018-10-29
