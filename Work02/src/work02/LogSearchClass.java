package work02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogSearchClass {
    private String filepath;
    private String word;
    private boolean isAnd;

    public static void main(String[] args) throws IOException {
        LogSearchClass logClass = new LogSearchClass();
        logClass.setFilepath("C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log");//파일경로
        logClass.setKeyword("HTML,DOC");// ,를 기준으로 단어 검색
        logClass.setAnd(false); //true는 and , false는 or

        System.out.println(logClass.find());
    }

    public File getFilepath() {
        File file = new File(filepath);
        return file;
    }
    //파일경로 입력 메소드
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String[] getKeyword() {
        String[] words = word.split(",");
        return words;
    }
    //검색어 입력 메소드
    public void setKeyword(String word){
        this.word = word;
    }

    public boolean isAnd() {
        return isAnd;
    }
    public void setAnd(boolean isAnd) {
        this.isAnd = isAnd;
    }

    //라인별 검색 진행 메소드
    public List<String> find() throws IOException {
        String[] keywords = getKeyword();
        String line = "";
        List<String> fileList = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(getFilepath()));
        while ((line = br.readLine()) != null){
            for(int j=0, n = keywords.length; j<n; j++){
                String keyword = keywords[j];
                if(isAnd()){
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