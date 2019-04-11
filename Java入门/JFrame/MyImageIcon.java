package azs;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImageIcon extends JFrame {
    public MyImageIcon(){
        Container container =getContentPane();
        JLabel jl = new JLabel("你好");
        URL url = MyImageIcon.class.getResource("imageButton.jpg");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);//设置标签为不透明的状态
        container.add(jl);
        setSize(250,100);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void  main(String [] args){
        new MyImageIcon();
    }
}
