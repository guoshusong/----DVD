package azs.Reflection.ReflectionExam;
//利用反射初步验证用户输入信息
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class Answer_1607 extends JFrame {
    private JTextField textField_2;
    private JTextField textField_1;
    private JTextField textField;

    /*
    * Launch the application
    * @param args
    * */
    public static void main(String[] args) {
        try {
            Answer_1607 frame = new Answer_1607();
            frame.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    *Create the frame
    * */
    public Answer_1607(){
        super();
        setBounds(100,100,500,375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel,BorderLayout.CENTER);

        final JLabel label = new JLabel();
        label.setText("姓名：");
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(label,gridBagConstraints);

        textField = new JTextField();
        textField.setName("姓名");
        textField.setColumns(20);//设置列宽
        final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
        gridBagConstraints_5.gridx = 1;
        gridBagConstraints_5.gridy = 0;
        panel.add(textField,gridBagConstraints_5);

        final JLabel label_1 = new JLabel();
        label_1.setText("性别");
        final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
        gridBagConstraints_1.gridx = 0;
        gridBagConstraints_1.gridy = 1;
        panel.add(label_1,gridBagConstraints_1);

        final JPanel panel_1 = new JPanel();
        final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 1;
        panel.add(panel_1,gridBagConstraints_4);

        final JRadioButton radioButton_1 = new JRadioButton();
        radioButton_1.setText("男");
        panel_1.add(radioButton_1);

        final JRadioButton radioButton_2 = new JRadioButton();
        radioButton_2.setText("女");
        panel_1.add(radioButton_2);

        final JLabel label_2 = new JLabel();
        label_2.setText("出生日期");
        textField_2.setColumns(20);
        final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
        gridBagConstraints_6.gridx = 1;
        gridBagConstraints_6.gridy = 2;
        panel.add(textField_1,gridBagConstraints_6);

        final JLabel label_3 = new JLabel();
        label_3.setText("身份证号");
        final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
        gridBagConstraints_3.gridy = 3;
        gridBagConstraints_3.gridx = 0;
        panel.add(label_3,gridBagConstraints_3);

        textField_2 =new JTextField();
        textField_2.setName("身份证号");
        textField_2.setColumns(20);
         final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
         gridBagConstraints_7.gridy = 3;
         gridBagConstraints_7.gridx = 1;
         panel.add(textField_2,gridBagConstraints_7);

         final JButton button = new JButton();
         button.setText("确定");
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Field[] fileds = Answer_1607.class.getDeclaredFields(); //通过Java反射机制获得类中的所有属性
                 for (int i = 0; i < fileds.length; i++){
                     Field field = fileds[i];
                     if (field.getType().equals(JTextField.class)){
                         field.setAccessible(true);//只验证JTextField类型的属性
                         JTextField textField = null;//默认情况下不允许访问私有属性，如果设为true则允许访问
                         try {
                             textField = (JTextField) field.get(Answer_1607.this);//获得本类中的对应属性
                         }catch (Exception ex){
                             ex.printStackTrace();
                         }
                         if (textField.getText().trim().length() == 0){ //查看给属性是否为空   trim去掉两端的空格
                             String info = "请填写" + textField.getName() + "!";
                             JOptionPane.showMessageDialog(null,info,"友情提示",JOptionPane.INFORMATION_MESSAGE);
                             textField.requestFocus();//令为空的文本框获得焦点
                             return;
                         }
                     }
                 }
             }
         });
        final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
        gridBagConstraints_8.gridx = 1;
        gridBagConstraints_8.gridy = 4;
        panel.add(button,gridBagConstraints_8);
    }
}
