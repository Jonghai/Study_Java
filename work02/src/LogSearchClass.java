import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogSearchClass {
    public String filepath;
    public String word;
    public boolean isAnd = false;

    public static void main(String[] args) throws IOException {
        LogSearchClass logClass = new LogSearchClass();
        logClass.filepath = "C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log"; //파일경로
        logClass.word ="HTML,DOC"; // ,를 기준으로 단어 검색
        logClass.isAnd = false; //true는 and , false는 or

        System.out.println(logClass.find());
    }

    //파일경로 입력 메소드
    public File setFilepath() {
        //LogSearchClass logClass = new LogSearchClass();
        File file = new File(filepath);
        return file;
    }

    //검색어 입력 메소드
    public String[] setKeyword(){
        String[] words = word.split(",");
        return words;
    }
    //라인별 검색 진행 메소드
    public List<String> find() throws IOException {
        String[] keywords = setKeyword();
        String line = "";
        List<String> fileList = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(setFilepath()));
        while ((line = br.readLine()) != null){
            for(int j=0, n = keywords.length; j<n; j++){
                String keyword = keywords[j];
                if(isAnd){
                    if(!line.contains(keyword)){
                        break;
                    }
                    if(j == n-1){
                        fileList.add(line + "\n");
                    }
                }else{
                    if(line.contains(keyword)) {
                        fileList.add(line + "\n");
                        break;
                    }
                }
            }
        }
        br.close();
        return fileList;
    }



}