package azs.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest2 {
    public static void main(String[] args){
        File file = new File("word.txt");
        try {
            //创建FileOutputStream对象
            FileOutputStream out = new FileOutputStream(file);
            //创建byte数组
            byte buy[] = "我有一头小毛驴我从来也不骑".getBytes();
            out.write(buy);
            out.close();
        }catch (Exception e){
            e.printStackTrace();;
        }
        try {
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1024];//创建byte数组
            int len = in.read(byt);//从文件中读取信息
            System.out.println("文件中的信息是"+ new String(byt,0,len));
            in.close();
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
