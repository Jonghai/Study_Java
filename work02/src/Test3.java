import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test3 {

    static String filepath = "C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log"; //검색할 파일
    static String word = "OOF,DOC";

    public static void main(String[] args) throws FileNotFoundException {
        getKeyword();//키워드
        getFilepath();
    }

    //파일경로 입력 메소드
    public static void getFilepath() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
    }

    //검색어 입력 메소드
    public static void getKeyword(String ...word){
        //String[] words = word.split(",");
    }

    //복수개 검색어 조건 정하는 메소드
    public static void KeywordCondition(){

    }
}
