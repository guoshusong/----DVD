package TCP;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClien extends JFrame {
    private PrintWriter writer;
    Socket socket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();
    Container cc;
    public MyClien(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {
            //绑定事件
            @Override
            public void actionPerformed(ActionEvent e) {
                //将文本框中的信息写入流
                writer.println(tf.getText());
                //将文本框中的信息显示在文本域中
                ta.append(tf.getText()+'\n');
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");
            }
        });
    }
    private void connect(){
        ta.append("尝试链接\n");//文本域中提示信息
        try {
            socket = new Socket("127.0.0.1",8998);
            writer = new PrintWriter(socket.getOutputStream(),true);//auotoFlush 自动刷新
            ta.append("完成链接\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClien clienc = new MyClien("向服务器发送数据");
        clienc.setSize(200,200);
        clienc.setVisible(true);
        clienc.connect();
    }
}
