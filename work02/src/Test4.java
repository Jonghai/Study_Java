import java.io.*;

public class Test4 {
    static StringBuilder sb = new StringBuilder();
    //static String filepath = "C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log"; //검색할 파일
    //static String word = "OOF,DOC";

    public static void main(String[] args) throws FileNotFoundException {
        //getKeyword("OOF,DOC");//키워드
        System.out.println(getKeyword(sb));
        sb.append("OOF");
        sb.append("DOC");
    }

    //파일경로 입력 메소드
    public static File getFilepath() {
        File file = new File("C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.txt");
        return file;
    }

    //검색어 입력 메소드
    public static StringBuilder getKeyword(StringBuilder sb){

        return sb;
    }

    //복수개 검색어 조건 정하는 메소드
    public static void KeywordCondition(){

    }
    //라인별 검색 진행 메소드
    public static void find(){

    }
}
