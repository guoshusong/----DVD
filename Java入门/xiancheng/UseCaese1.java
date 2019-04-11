package xiancheng;

import javax.swing.*;
import java.awt.*;

public class UseCaese1 extends JFrame {
    public static final long serialVersionUID = 1L;
    final JProgressBar jProgressBar = new JProgressBar();

    public UseCaese1(){
        getContentPane().add(jProgressBar, BorderLayout.NORTH);
        jProgressBar.setStringPainted(true);

        Thread thread = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true){
                    jProgressBar.setValue(++count);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    public static void main(String[] args) {
        init(new UseCaese1(), 100, 100);

    }

    public static void init(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
