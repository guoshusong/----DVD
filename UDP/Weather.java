package UDP;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Weather extends Thread{
    String weather = "哔哩哔哩，能听到吗";
    int port = 9898;
    InetAddress iaddress = null;
    MulticastSocket socket = null;//声明多点广播套接字
    Weather(){
        try {
            iaddress = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.setTimeToLive(1);//指定发送范围是本地网络
            socket.joinGroup(iaddress);//加入广播组
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            DatagramPacket packet = null;
            byte data[] = weather.getBytes();//声明字节数组
            packet = new DatagramPacket(data,data.length,iaddress,port);//将数据打包
            System.out.println(new String(data));//将广播信息输出
            try {
                socket.send(packet);
                sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Weather w = new Weather();
        w.start();
    }
}
