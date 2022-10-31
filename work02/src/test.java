import java.io.*;
import java.util.ArrayList;

public class test {

    public static void main(String[] args){
        filepath();

    }

    public static File filepath(){
        String path ="C:\\Users\\CLIPSOFT\\Documents\\logFiles\\";
        String fileNm = "beom-developer.api.2022-10-14_0.txt";
        File file = new File(String.valueOf(path+fileNm));
        return file;
    }

    public static ArrayList<String> keyword(){
        ArrayList<String> wordlist = new ArrayList<String>();
        String word = "DOC,OOF";
        String[] words = word.split(",");
        for(int i =0; i < words.length; i++){
            wordlist.equals(words[i]);

        }
        return wordlist;
    }

   /* public static String keywords() throws IOException {
        BufferedReader br = null;
        String line = "";
        br = new BufferedReader(new FileReader(filepath()));

        while ((line = br.readLine()) != null){
            for(int j=0; j<keyword().length; j++)
                if(line.equals(keyword()) != -1){
                    String result = line.trim();
                    System.out.println(result);
                }
        }*/

}
