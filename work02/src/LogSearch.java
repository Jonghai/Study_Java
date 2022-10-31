import java.io.*;
import java.util.*;

public class LogSearch {
    static List<File> targetFiles = null;
    static String baseDir = "C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log"; //검색할 파일
    static String word = "OOF,DOC";

    public static void main(String[] args ) throws IOException {
        File Dir = new File(baseDir);
        File[] Files = Dir.listFiles();

        BufferedReader br = null;
        String[] words = word.split(",");
        for(int i = 0; i < Files.length; i++){
            if(!Files[i].isFile()){
                continue;
            }
            br = new BufferedReader(new FileReader(Files[i]));
            String line = "";

            while ((line = br.readLine()) != null){
                for(int j=0; j<words.length; j++)
                    if(line.indexOf(words[j]) != -1){
                       String result = line.trim() + ":" + Files[i].getAbsolutePath();
                       System.out.println(result);
                    }
            }

            br.close();
        }
    }
}