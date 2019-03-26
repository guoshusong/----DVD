package azs.IO;
//数据输入/输出流
//允许应用程序以与机器无关的方式从底层输入流中读取基本Java数据类型
//当读取一个数据时，不必关心这个数值应当是哪种字节
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Example_01 {
    public static void main(String[] args){
        try {
            FileOutputStream fs = new FileOutputStream("word.txt");
            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("使用UTF方法写入数据");//写入磁盘数据文件
            ds.writeChars("使用Chars方法写入数据");
            ds.writeBytes("使用Bytes方法写入数据");
            ds.close();
            FileInputStream fis = new FileInputStream("wprd.txt");
            DataInputStream  dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
