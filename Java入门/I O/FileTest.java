package azs.IO;

import java.io.File;
import java.io.*;

public class FileTest {
    public void main(String[] args){
        File file = new File("world.txt");
        if (file.exists()){
            file.delete();
            System.out.println("文件已经删除");
        } else {                                    //如果文件不存在
            try {                       //try语句块捕捉可能出现的异常
                file.createNewFile();
                System.out.println("文件已经创建");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

