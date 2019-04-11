package UDP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receive extends JFrame implements Runnable,ActionListener {
    int port;
    InetAddress group = null;
    MulticastSocket socket = null;
    JButton ince = new JButton("开始接收");
    JButton stop = new JButton("停止接收");
    JTextArea inceAr = new JTextArea(10,10);
    JTextArea inced = new JTextArea(10,10);//显示接收广播的文本域
    Thread thread;
    boolean b = false;
    public Receive(){
        super("广播数据");//调用父类方法
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread = new Thread(this);
        ince.addActionListener(this);
        stop.addActionListener(this);
        inceAr.setForeground(Color.blue);
        JPanel north = new JPanel();
        north.add(ince);
        north.add(stop);
        add(north,BorderLayout.NORTH);
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,2));
        center.add(inceAr);
        center.add(inced);
        add(center,BorderLayout.CENTER);
        validate();//刷新
        port = 9898;
        try {
            group = InetAddress.getByName("224.255.10.0");//指定接收地址
            socket = new MulticastSocket(port);//绑定多点广播套接字
            socket.joinGroup(group);
        }catch (Exception e){
            e.printStackTrace();
        }
        setBounds(100,50,360,380);
        setVisible(true);
    }
    @Override
    public void run() {
        while (true) {
            byte data[] = new byte[1024];
            DatagramPacket packet = null;
            packet = new DatagramPacket(data,data.length,group,port);//待接收的数据包
            try {
                socket.receive(packet);//接收数据包
                String message = new String(packet.getData(),0,packet.getLength());//获取数据包中的内容
                inceAr.setText("正在接收的内容: \n" + message);
                inced.append(message + "\n");
            }catch (Exception e){
                e.printStackTrace();
            }
            if (b == true) {
                break;
            }

        }
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == ince) { //单击按钮ince触发的事件
            ince.setBackground(Color.RED);
            stop.setBackground(Color.ORANGE);
            if (!(thread.isAlive())) { //线程不处于新建状态
                thread = new Thread(this);
            }
            thread.start();
            b = false;
        }
        if (e.getSource() == stop) {
            ince.setBackground(Color.GREEN);
            stop.setBackground(Color.ORANGE);
            b = true;
        }
    }
    public static void main(String[] args) {
        Receive rec = new Receive();
        rec.setSize(460,200);
    }
}
