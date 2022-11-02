package work01;

import java.util.*;

public class ListTest {

    public final static int TEST_CASE = 100000;
    public final static int TEST_CASE2 = 1000000;

    public static void main(String[] args) {
        ArrayList<Integer> arraylist = new ArrayList<>();
        LinkedList<Integer> linkedlist = new LinkedList<>();
        Vector<Integer> v = new Vector<Integer>();
        System.out.println("====== 시작부터 삽입");
        System.out.println("ArrayList : " + add1(arraylist));
        System.out.println("LinkedList : " + add1(linkedlist));
        System.out.println("Vector : " + add1(v));

        System.out.println("====== 중간부터 삽입");
        arraylist = new ArrayList<>();
        linkedlist = new LinkedList<>();
        v = new Vector<Integer>();
        System.out.println("ArrayList : " + add2(arraylist));
        System.out.println("LinkedList : " + add2(linkedlist));
        System.out.println("Vector : " + add2(v));

        System.out.println("====== 순차적으로 삭제");
        arraylist = new ArrayList<>();
        linkedlist = new LinkedList<>();
        v = new Vector<Integer>();
        System.out.println("ArrayList : " + remove1(arraylist));
        System.out.println("LinkedList : " + remove1(linkedlist));
        System.out.println("Vector : " + remove1(v));

        System.out.println("====== 중간부터 삭제");
        arraylist = new ArrayList<>();
        linkedlist = new LinkedList<>();
        v = new Vector<Integer>();
        System.out.println("ArrayList : " + remove2(arraylist));
        System.out.println("LinkedList : " + remove2(linkedlist));
        System.out.println("Vector : " + remove2(v));

        System.out.println("====== listiterator 조회");
        arraylist = new ArrayList<>();
        linkedlist = new LinkedList<>();
        v = new Vector<Integer>();
        System.out.println("ArrayList : " + get2(arraylist));
        System.out.println("LinkedList : " + get2(linkedlist));
        System.out.println("Vector : " + get2(v));

        System.out.println("====== iterator 조회");
        arraylist = new ArrayList<>();
        linkedlist = new LinkedList<>();
        v = new Vector<Integer>();
        System.out.println("ArrayList : " + get3(arraylist));
        System.out.println("LinkedList : " + get3(linkedlist));
        System.out.println("Vector : " + get3(v));

        add1(arraylist);
        add1(linkedlist);
        add1(v);
        System.out.println("====== Index 조회");
        System.out.println("ArrayList : " + get1(arraylist));
        System.out.println("LinkedList : " + get1(linkedlist));
        System.out.println("Vector : " + get1(v));
    }
    public static long add1 (List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            list.add(i);
        }
        long end =System.currentTimeMillis();
        return end - start;
    }

    public static long add2(List<Integer> list){
        for(int i= 0; i < TEST_CASE; i++){
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for(int i= 0; i < TEST_CASE; i++){
            list.add(500, i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove1(List<Integer> list){
        for(int i=0; i<TEST_CASE; i++){
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for(int i=list.size()-1; i>=0; i--){
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove2(List<Integer> list){
        for(int i=0; i<1000000; i++){
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for(int i=0; i<TEST_CASE; i++){
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end- start;
    }

    public static long get1 (List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i= 0, n = list.size(); i < n; i++){
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end -start;
    }

       public static long get2 (List<Integer> list){
           for(int i=0; i<TEST_CASE2; i++){
               list.add(i);
           }
           ListIterator<Integer> listite = list.listIterator();
           long start = System.currentTimeMillis();
               while(listite.hasNext()){
                   listite.next();
           }
        long end = System.currentTimeMillis();
        return end - start;
    }

     public static long get3 (List<Integer> list){
         for(int i=0; i<TEST_CASE2; i++){
             list.add(i);
         }
         Iterator<Integer> ite = list.iterator();
        long start = System.currentTimeMillis();
        while (ite.hasNext()){
            ite.next();
         }
        long end = System.currentTimeMillis();
        return end - start;
    }


}