package TCP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {
    private BufferedReader reader;//创建BufferedReader对象
    private ServerSocket server;//创建ServerSocket对象
    private Socket socket;//创建Socket对象
    void getserver(){
        try {
            server = new ServerSocket(8998);
            System.out.println("服务器套接字已经创建完成");
            while (true) {
                System.out.println("等待客户机的链接");
                socket = server.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getClientMessage(){
        try {
            while (true) {
                System.out.println("客户机" + reader.readLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
                reader = null;
            }
            if (socket != null) {
                socket.close();
                socket = null;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTcp tcp = new MyTcp();
        tcp.getserver();
    }
}
