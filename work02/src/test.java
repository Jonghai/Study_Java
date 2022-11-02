import org.testng.reporters.XMLConstants;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    static boolean isAnd = true;

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
        String word = "HTML"; // ,를 기준으로 단어 검색
        String[] words = word.split(",");
        return words;
    }

    //라인별 검색 진행 메소드
    public static List<String> find() throws IOException {
        String[] keywords = getKeyword();
        String line = "";
        List<String> fileList = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(getFilepath()));
        while ((line = br.readLine()) != null){
            boolean isOrOk = false;
            boolean isAndOk = true;
            for(int j=0, n = keywords.length; j<n; j++){
                String keyword = keywords[j];
                if(isAnd){
                    if(!line.contains(keyword)){
                        isAndOk = false;
                        break;
                    }
                }else{
                    if(line.contains(keyword))
                        isOrOk = true;
                    break;
                }
            }
            if(isAndOk || isOrOk) {
                fileList.add(line +"\n");
            }
        }
        br.close();
        return fileList;
    }




}