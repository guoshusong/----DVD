package azs;

import javax.swing.*;
import java.awt.*;

public class DrawIocn implements Icon {
    private int width;
    private int height;

    @Override
    public int getIconHeight() {
        return this.height;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    public DrawIocn(int width, int height){
        this.width=width;
        this.height=height;
    }
    @Override
    public void paintIcon(Component arg0, Graphics arg1, int x, int y) {
        arg1.fillOval(x,y,width,height);//绘制一个图形
    }
    public static void main(String [] args){
        DrawIocn icon = new DrawIocn(15,15);
        JLabel j = new JLabel("测试",icon,SwingConstants.CENTER);// 创建一个标签，并设置标签上的文字在标签正中间
        JFrame jf = new JFrame();//创建一个JFrame窗口
        Container c = jf.getContentPane();
        c.add(j);
        JButton jb = new JButton("测试");
        c.add(jb);
        j.setSize(200,200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
