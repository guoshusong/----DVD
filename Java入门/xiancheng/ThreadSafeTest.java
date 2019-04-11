package xiancheng;

public class ThreadSafeTest implements Runnable {
    int num = 10;
    /*@Override
    public void run() {
        while (true){
            synchronized (""){
                if (num > 0) {
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("tickets" +  --num);
                }
            }
        }
    }*/
    public synchronized void doit(){
        if (num > 0) {
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("tickets" +  --num);
        }

    }

    @Override
    public void run() {
        while (true) {
            doit();
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest t = new ThreadSafeTest();
        Thread tA = new Thread(t);
        Thread tB = new Thread(t);
        Thread tC = new Thread(t);
        Thread tD = new Thread(t);
        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
}
