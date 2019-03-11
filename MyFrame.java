package azs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyJDialog extends JDialog{
    //实例化一个JDialog类对象，指定对话框的父窗体、窗体标题和类型
        public MyJDialog(MyFrame frame){
            super(frame,"窗口",true);
            Container container = getContentPane();
            container.add(new JLabel("对话框"));
            setBounds(120,120,100,100);
        }
}
public class MyFrame extends JFrame {
    public static void  main(String [] args){
        new MyFrame();
    }
    public MyFrame(){
        Container container = getContentPane();//创建一个容器
        container.setLayout(null);
        /*未设置Layout时，java默认为flowLayout布局的，设置为null即为清空布局管理器，之后添加组件，
        常常是设置组件左上角坐标相对于容器左上角（0，0）的x,y值来确定组件的位置，
        即使更改容器大小也不会改变位置。这种方式常常用于窗体大小固定的容器里。*/
        JLabel jl = new JLabel("这啥也不是");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jl);
        JButton bl = new JButton("弹出一个对话框");
        bl.setBounds(10,10,100,21);
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyJDialog(MyFrame.this).setVisible(true);
            }
        });
        container.add(bl);
    }
}
