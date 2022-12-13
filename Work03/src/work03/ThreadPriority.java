package work03;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread_1 th1 = new Thread_1();
        Thread_2 th2 = new Thread_2();

        th2.setPriority(6);

        System.out.println("Priority of th1 (-) : " + th1.getPriority());
        System.out.println("Priority of th2 (-) : " + th2.getPriority());

        th1.start();
        th2.start();

    }
}

class Thread_1 extends Thread{
    public void run(){
        for(int i= 0; i<300; i++){
            System.out.print("-");
            for(int x=0; x<10000000; x++);
        }
    }
}

class Thread_2 extends Thread{
    public void run(){
        for(int i =0; i<300; i++){
            System.out.print("|");
            for(int x= 0; x<10000000; x++);
        }

    }
}
