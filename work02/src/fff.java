import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class fff {

    public static void filepath (File file) throws IOException {
        String path = "C:\\Users\\CLIPSOFT\\Documents\\logFiles";
        String fileNm = "beom-developer.api.2022-10-14_0.txt";

        // 파일 객체 생성
        File filepath = new File(path + fileNm);
        File[] Files = filepath.listFiles();
        for( File f : Files ){
            if( f.isFile() && f.canRead() ){ // 파일이 파일인지? && 읽을 수 있는지?
                FileReader fileReader = new FileReader(f);
// 입력 버퍼 생성
                BufferedReader bufferedReader = new BufferedReader(fileReader);

// 읽기 수행
                String line = "";
                String result = "";
                int cnt = 0;
                while( (line = bufferedReader.readLine()) != null ){ // 파일 내 문자열을 1줄씩 읽기 while
                    if( line.contains("D") ){ // 찾고자하는 문자열이 있을 때 작성
                        result += line + "\n"; // 한줄씩 읽어 결과에 추가
                        cnt++; // 찾을 문자열이 몇개 포함되었는지 체크
                    }
                }
                fileReader.close();
            }
        }
    }

    public static void main(String[] args){

    }
}
