import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Test5 {

    static String word = "OOF,DOC";
    //static String word1 = "OOF";
    //static String word2 = "DOC";
    static Map<String, Boolean> keywords = new HashMap<String, Boolean>();

    public static void main(String[] args) throws IOException {
        //System.out.println(find());
        //System.out.println(KeywordCondition());
        getKeyword("OOF","DOC");
        //KeywordCondition();
    }

    //파일경로 입력 메소드
    public static File getFilepath() {
        File file = new File("C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log");
        return file;
    }

    //검색어 입력 메소드
    public static String getKeyword(String...strs) {
        String result = "";
        for(String s : strs) {
           result += s;
        }
        System.out.println(result);
        return result;
    }
    //복수개 검색어 조건 정하는 메소드
  /* public static void KeywordCondition(String...strs){

       if(word1 && word2){
           true;
       }
       else{
           false;
       }
   }*/
    //라인별 검색 진행 메소드
 /*   public static List<String> find() throws IOException {
        ArrayList keyword = getKeyword(word);
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(getFilepath()));
        String line = "";
        List<String> fileList = new ArrayList<String>();
        while ((line = br.readLine()) != null){
            for(int j=0; j<keyword.size(); j++)
                if(line.indexOf(keyword.get(j).toString()) != -1){
                    fileList.add(line.trim());
                }
        }
        br.close();
        return fileList;
    }*/


}