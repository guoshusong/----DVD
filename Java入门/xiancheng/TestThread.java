package xiancheng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestThread extends JFrame {
    public static final long serialVersionUID = 1l;
    JPanel jPanel1= new JPanel();
    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    MyThread thread = null;
    protected boolean isContinue;
    public TestThread(){
        try{
         jblnit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void jblnit() throws Exception{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startButton.setText("start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton_actionPerformed(e);
            }
        });
        stopButton.setText("stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopButton_actionPerformed(e);
            }
        });
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(startButton);
        startButton.setBounds(36, 105, 82, 30);
        jPanel1.add(stopButton);
        stopButton.setBounds(160, 108, 100, 31);
    }
    void startButton_actionPerformed(ActionEvent e){
        if (thread != null)
                isContinue = false;
            thread = new MyThread();
            thread.start();

    }
    void stopButton_actionPerformed(ActionEvent e){
        if (thread != null)
            isContinue=false;
        thread = null;
    }

    public static void main(String[] args) {
        TestThread test = new TestThread();
        test.setBounds(300,300,300, 80);
        test.setVisible(true);
    }

    public class MyThread extends Thread {
        public MyThread() {
            isContinue=true;
        }

        public void run() {
            System.out.println("\n\n");
            while (true && isContinue) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("哔哩哔哩干杯");
            }
        }
    }
}
