/*

������

DATE��2018-10-28

 */
import java.util.Scanner;

public class bake {
    public static void main(String[] args) {
        // �������ڴ洢������Ϣ������
        String[] names = new String[10];// DVD ����
        int[] status = new int[10];
        int[] count = new int[10];
        int[] date = new int[10];

        // ��ʼ��DVD��Ϣ
        names[0] = "��˫";
        status[0] = 1;// �ѽ��
        count[0] = 12;
        date[0] = 26;

        names[1] = "�������";
        status[1] = 0;// δ���
        count[1] = 0;
        date[1] = 0;

        names[2] = "��Ե����";
        status[2] = 0;// δ���
        count[2] = 10;
        date[2] = 0;

        Scanner input = new Scanner(System.in);

        // �˵��л�
        int choose = 0;
        do {
            System.out
                    .println("-----------��ӭʹ�����Ľ����Ҫߣ��������DVD������------------------------------------------------");
            System.out
                    .println("-------------------------------------------------------------------------------");
            System.out.println("1.����DVD");
            System.out.println("2.�鿴DVD");
            System.out.println("3.ɾ��DVD");
            System.out.println("4.���DVD");
            System.out.println("5.�黹DVD");
            System.out.println("6.�˳�DVD");
            System.out
                    .println("------------------------------------------------------------------------------");
            System.out.print("\n��ѡ����:");
            int no = input.nextInt();
            switch (no) {
                case 1:
                    System.out.println("------>����DVD");
                    System.out.print("����������DVD���ƣ�");
                    String name = input.next();
                    // �����־�Ա���,���ڼ�¼��һ�γ���null������λ��
                    int index = -1;// Ĭ�ϱ�ʾû��nullλ��
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] == null) {
                            index = i;// ��¼nullλ�õ�����λ��
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("�����������޷�����DVD!");
                    } else {
                        names[index] = name;
                        System.out.println("�ɹ�����DVD��" + name + "����");
                    }

                    System.out
                            .println("-------------------------------------------------------------------------");
                    System.out.print("����0����:");
                    choose = input.nextInt();
                    break;
                case 2:
                    System.out.println("------>�鿴DVD");
                    System.out.println("���\t\tDVD����\t\tDVD״̬\t\t�������\t\t�������");
                    // ѭ����������
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null) {
                            System.out.println((i + 1) + "\t\t" + names[i] + "\t\t"
                                    + ((status[i] == 0) ? "δ���" : "�ѽ��") + "\t\t"
                                    + count[i] + "\t\t" + date[i]);
                        }
                    }
                    System.out
                            .println("----------------------------------------------------------------------------");
                    System.out.print("����0����:");
                    choose = input.nextInt();
                    break;
                case 3:
                    System.out.println("------>ɾ��DVD");
                    System.out.print("������Ҫɾ����DVD:");
                    String delName = input.next();
                    int delIndex = -1;// ���û�б�ɾ����dvd
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && names[i].equals(delName)
                                && status[i] == 0) {// ɾ��dvd���ڣ�������ɾ��
                            delIndex = i;
                            // ɾ������ʵ������λ
                            for (int j = delIndex; j < names.length - 1; j++) {
                                names[j] = names[j + 1];
                                status[j] = status[j + 1];
                                count[j] = count[j + 1];
                                date[j] = date[j + 1];
                            }
                            // �����һ������λ�õ�Ԫ������Ϊnull
                            names[names.length - 1] = null;
                            status[names.length - 1] = 0;
                            count[names.length - 1] = 0;
                            date[names.length - 1] = 0;
                            System.out.println("�ɹ�ɾ����" + delName + "��DVD!");
                            break;
                        }
                        if (names[i] != null && names[i].equals(delName)
                                && status[i] == 1) {
                            delIndex = i;
                            System.out.println("��Ҫɾ���ġ�" + delName
                                    + "��DVD �����������ɾ����");
                            break;
                        }
                    }
                    if (delIndex == -1) {
                        System.out.println("��ɾ���ġ�" + delName + "��DVD�����ڣ�");
                    }

                    System.out
                            .println("---------------------------------------------------------------------------");
                    System.out.print("����0����:");
                    choose = input.nextInt();
                    break;
                case 4:
                    System.out.println("------>���DVD");
                    System.out.print("��������Ҫ���DVD���ƣ�");
                    String borrowName = input.next();
                    boolean flag = false;// Ĭ�ϱ�ʾҪ�����DVD������
                    // ѭ���ж�Ҫ�����DVD�Ƿ����
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && borrowName.equals(names[i])) {
                            if (status[i] == 0) {
                                flag = true;// ��ʾ����
                                System.out.print("�����뵱ǰ����(��):");
                                date[i] = input.nextInt();// �������ڲ��������Ӧ����λ�õ�Ԫ����
                                status[i] = 1;// ����״̬
                                count[i] = count[i] + 1;// ���´���
                                System.out.println("�ɹ������" + borrowName + "��DVD!");
                                break;
                            } else {
                                flag = true;// ��ʾ����
                                System.out.println("��Ҫ�����DVD��" + borrowName
                                        + "���ѽ�������ܽ����");
                                break;
                            }
                        }
                        // if(names[i]!=null && borrowName.equals(names[i]) &&
                        // status[i]==0){//�����dvd���ƴ��ڲ���״̬Ϊ�ɽ�״̬
                        // flag = true;//��ʾ����
                        // System.out.print("�����뵱ǰ����(��):");
                        // date[i] = input.nextInt();//�������ڲ��������Ӧ����λ�õ�Ԫ����
                        // status[i] = 1;//����״̬
                        // count[i] = count[i]+1;//���´���
                        // break;
                        // }
                        // if(names[i]!=null && borrowName.equals(names[i]) &&
                        // status[i]==1){//�����dvd���ƴ��ڲ���״̬Ϊ�ɽ�״̬
                        // flag = true;//��ʾ����
                        // System.out.println("��Ҫ�����DVD��"+borrowName+"���ѽ�������ܽ����");
                        // break;
                        // }
                    }
                    if (!flag) {
                        System.out.println("��Ҫ����ġ�" + borrowName + "��DVD �����ڣ�");
                    }

                    System.out
                            .println("--------------------------------------------------------------------------");
                    System.out.print("����0����:");
                    choose = input.nextInt();
                    break;
                case 5:
                    System.out.println("------>�黹DVD");
                    System.out.print("��������Ҫ�黹��DVD����:");
                    String reName = input.next();
                    // ѭ���������鲢���ҹ黹DVD�Ƿ����
                    boolean reflag = false;// Ĭ�ϱ�ʾҪ�黹��DVD������
                    // ѭ���ж�Ҫ�����DVD�Ƿ����
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null && reName.equals(names[i])) {
                            if (status[i] == 1) {//��ʾ��DVD�ѽ��
                                reflag = true;// ��ʾ����
                                System.out.print("�����뵱ǰ�黹����(��):");
                                int rdate = input.nextInt();
                                status[i] = 0;// ����״̬
                                System.out.println("�ɹ��黹��" + reName + "��DVD!");
                                // �������
                                if (rdate > date[i]) {
                                    System.out.println("��������" + (rdate - date[i])
                                            + "�죬��𹲼ƣ�" + (rdate - date[i]) + "Ԫ��");
                                } else {
                                    System.out.println("���ڲ��Ϸ���");
                                }
                                break;
                            }else {//δ���
                                reflag = true;// ��ʾ����
                                System.out.println("��Ҫ�黹��DVD��" + reName + "��δ������޷��黹��");
                                break;
                            }
                        }
                    }
                    if (!reflag) {
                        System.out.println("��Ҫ�黹�ġ�" + reName + "��DVD �����ڣ�");
                    }

                    System.out
                            .println("--------------------------------------------------------------------------");
                    System.out.print("����0����:");
                    choose = input.nextInt();
                    break;
                case 6:
                    System.out.println("------>�˳�DVD");
                    System.exit(1);// �˳�ϵͳ
                    break;

                default:
                    System.out.print("û�д˹��ܣ�");
                    System.out
                            .println("--------------------------------------------------------------------------");
                    System.out.print("����0����:");
                    choose = input.nextInt();
                    break;
            }

        } while (choose == 0);
        System.out.println("��л����ʹ�ã�");

    }

}
//���ߣ�������        
//DATE:2018-10-29
