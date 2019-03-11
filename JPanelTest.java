package azs;

import javax.swing.*;
import java.awt.*;
/*
* JPanel面板可以聚集一些组件类布局，JPanel也是一种容器。
* */
public class JPanelTest extends JFrame {
    public JPanelTest(){
        Container c = getContentPane();
        setLayout(new GridLayout(2,1,10,10));//将整个容器设置为两行一列的布局。
        JPanel p1 = new JPanel(new GridLayout(1,3,10,10));
        JPanel p2 = new JPanel(new GridLayout(1,2,10,10));
        JPanel p3 = new JPanel(new GridLayout(1,2,10,10));
        JPanel p4 = new JPanel(new GridLayout(2,1,10,10));
        p1.add(new JButton("1"));
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String [] args){
        new JPanelTest();
    }
}
