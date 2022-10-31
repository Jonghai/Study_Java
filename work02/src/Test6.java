import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test6 {

    static String word1 = "OOF";
    static String word2 = "에러";
    //static Map<String, Boolean> keywords = new HashMap<String, Boolean>();

    public static void main(String[] args) throws IOException {

        System.out.println(find());
    }

    //파일경로 입력 메소드
    public static File getFilepath() {
        File file = new File("C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log");
        return file;
    }

    //검색어 입력 메소드
    public static String[] getKeyword(){
        String word = "OOF,에러";
        String[] words = word.split(",");
        return words;
    }
    //복수개 검색어 조건 정하는 메소드
    public static void KeywordCondition(){
        String[] a = getKeyword();
         for(int i=0; i<a.length; i++){
             String s = a[i];
             System.out.println(s);
         }
        //return s;
    }
    //라인별 검색 진행 메소드
    public static List<String> find() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(getFilepath()));
        String line = "";
        List<String> fileList = new ArrayList<String>();
        while ((line = br.readLine()) != null){
            for(int j=0; j<getKeyword().length; j++)
                if(line.contains(word1) || line.contains(word2)){
                    fileList.add(line+"\n");
                }
        }
        br.close();
        return fileList;
    }
}