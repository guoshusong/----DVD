package xiancheng;

import javax.swing.*;
import java.awt.*;

public class PriorityTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private Thread threadA;
    private Thread threadB;
    private Thread threadC;
    private Thread threadD;

    public PriorityTest(){
        getContentPane().setLayout(new GridLayout(4,1));
        final JProgressBar jProgressBar = new JProgressBar();
        final JProgressBar jProgressBar2 = new JProgressBar();
        final JProgressBar jProgressBar3 = new JProgressBar();
        final JProgressBar jProgressBar4 = new JProgressBar();
        getContentPane().add(jProgressBar);
        getContentPane().add(jProgressBar2);
        getContentPane().add(jProgressBar3);
        getContentPane().add(jProgressBar4);
        jProgressBar.setStringPainted(true);
        jProgressBar2.setStringPainted(true);
        jProgressBar3.setStringPainted(true);
        jProgressBar4.setStringPainted(true);
        threadA = new Thread(new MytThread(jProgressBar));
        threadB = new Thread(new MytThread(jProgressBar2));
        threadC = new Thread(new MytThread(jProgressBar3));
        threadD = new Thread(new MytThread(jProgressBar4));
        setPriority("threadA",5,threadA);
        setPriority("threadB",4,threadB);
        setPriority("threadC",3,threadC);
        setPriority("threadC",2,threadD);
    }
    public static void setPriority(String threadName, int priority, Thread t){
        t.setPriority(priority);
        t.setName(threadName);
        t.start();
    }
    public static void main(String[] args) {
        init(new PriorityTest(), 100, 100);
    }
    public static void init(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
    public final class MytThread implements Runnable{
        private final JProgressBar  bar;
        int count = 0;
        private MytThread(JProgressBar bar){
            this.bar = bar;
        }

        @Override
        public void run() {
            while (true){
                bar.setValue(count += 10);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("当前线程被中断");
                }
            }

        }
    }
}

