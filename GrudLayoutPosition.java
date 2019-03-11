package azs;

import javax.swing.*;
import java.awt.*;

public class GrudLayoutPosition extends JFrame {
    public GrudLayoutPosition(){
        Container container = getContentPane();
        setLayout(new GridLayout(7,3,5,5));
        for (int i = 0;i < 20; i++){
            container.add(new JButton("button"+i));
        }
        setSize(200,200);
        setVisible(true);
        setTitle("bibli");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String [] args){
        new GrudLayoutPosition();
    }
}