package xiancheng;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class SwingAndThread extends JFrame {
    private JLabel jl = new JLabel();
    private static Thread t;
    private int count;
    private Container container = getContentPane();

    public SwingAndThread(){
        setBounds(300,200,250,100);
        container.setLayout(null);
        URL url = SwingAndThread.class.getResource("/1.gif"); // 获取图片的URL
        Icon icon = new ImageIcon(url); // 实例化一个Icon
        jl.setIcon(icon); // 将图标放置在标签中
        // 设置图片在标签的最左方
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10,10,200,50);
        jl.setOpaque(true);//设置控件不透明
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 200){
                    jl.setBounds(count,10,200,50);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    count += 4;
                    if (count == 4) {
                        count = 10 ;
                    }
                }
            }
        });
        t.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingAndThread();
    }
}
