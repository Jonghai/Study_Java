package work03;

public class ee {
    static long startTime = 0;

    public static void main(String[] args) {
       /*long startTime = System.currentTimeMillis();
       for(int i =0; i<300; i++){
           System.out.println("-");
       }
        System.out.println("소요시간1: "+(System.currentTimeMillis()-startTime));

       for(int i=0; i<300; i++){
           System.out.println("|");
       }
        System.out.println("소요시간2: "+(System.currentTimeMillis()-startTime));*/

        ee2 e2 = new ee2();
        e2.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.println("소요시간1: " + (System.currentTimeMillis() - ee.startTime));
    }
}

    class ee2 extends Thread {
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("|");
            }
            System.out.println("소요시간2: " + (System.currentTimeMillis() - ee.startTime));
        }
    }
