package work03;

public class Thread_Join {
    static long startTime =0;
    public static void main(String[] args) {
        Thread_Join_1 th1 = new Thread_Join_1();
        Thread_Join_2 th2 = new Thread_Join_2();

        th1.start();

        startTime = System.currentTimeMillis();
        try{
            th1.join();
            //th2.join();
        }catch (InterruptedException e){}
        th2.start();
        System.out.print("소요시간:"+(System.currentTimeMillis()-Thread_Join.startTime));
    }
}

class Thread_Join_1 extends Thread{
    public void run(){
        for(int i= 0; i<300; i++){
            System.out.print("-");
        }
    }
}

class Thread_Join_2 extends Thread{
    public void run(){
        for(int i= 0; i<300; i++){
            System.out.print("|");
        }
    }
}
