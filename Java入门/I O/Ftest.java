package azs.IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ftest extends JFrame {
    private JScrollPane scrollPane;//滚动面板
    private JPanel jContentPane = null;//创建面板对象
    private  JTextArea jTextArea = null;//创建文本域对象
    private JPanel controlPanel = null;//创建面板对象
    private JButton openButton = null;//创建按钮对象
    private  JButton closeButton = null;//创建按钮对象

    private JTextArea getJTextArea(){
        if (jTextArea == null){
            jTextArea = new JTextArea();
        }
        return  jTextArea;
    }
    private JPanel getControlPanel(){
        if (controlPanel == null){
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setVgap(1);//设置组件之间垂直间距
            controlPanel = new JPanel();
            controlPanel.setLayout(flowLayout);
            controlPanel.add(getOpenButton(),null);
            controlPanel.add(getCloseButton(),null);
        }
        return controlPanel;
    }
    public JButton getOpenButton(){
        if (openButton == null){
            openButton = new JButton();
            openButton.setText("写入文件");
            openButton.addActionListener(new java.awt.event.ActionListener(){ //按钮的单机事件

                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("word.txt");//创建文件对象
                    try {
                        FileWriter out = new FileWriter(file);
                        String s = jTextArea.getText();
                        out.write(s);//将信息写入磁盘文件
                        out.close();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            });
        }
        return openButton;
    }
    private JButton getCloseButton(){
        if (closeButton == null){
            closeButton = new JButton();
            closeButton.setText("读取文本");
            closeButton.addActionListener(new  java.awt.event.ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("world.txt");
                    try {
                        FileReader in = new FileReader(file);
                        char byt[] = new char[1024];
                        int len = in.read(byt);
                        jTextArea.setText(new String(byt,0,len));
                        in.close();
                    }catch (Exception e1){
                            e1.printStackTrace();
                    }
                }
            });
        }
        return closeButton;
    }
    public Ftest(){
        super();
        initialize();
    }
    public void  initialize(){
        this.setSize(300,200);
        this.setContentPane(getJControlPanel());
        this.setTitle("JFrame");
    }
    public  JPanel getJControlPanel(){
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getScrollPane(), BorderLayout.CENTER);
            jContentPane.add(getControlPanel(), BorderLayout.SOUTH);
        }
        return jContentPane;
    }
    public static void main(String[] args) { // 主方法
        Ftest thisClass = new Ftest(); // 创建本类对象
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisClass.setVisible(true); // 设置该窗体为显示状态
    }
    /**
     * @return
     */
    protected JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getJTextArea());
        }
        return scrollPane;
    }
}
