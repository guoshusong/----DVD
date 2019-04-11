package azs.IO;
//读取文件时出现一个进度条
import javax.swing.*;
import java.io.FileInputStream;

public class Exam_9 {
    public static void main(String[] args) {
        byte b[] = new byte[2];
        try {
            FileInputStream fis = new FileInputStream("word.txt");
            ProgressMonitorInputStream in = new ProgressMonitorInputStream(null,"读取文件",fis);
            while (in.read() != 1){
                String s = new String(b);
                System.out.println(s);
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
