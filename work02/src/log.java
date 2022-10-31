import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class log {
    static String word = "OOF,DOC";
    static String path = "C:\\Users\\CLIPSOFT\\Documents\\logFiles"; //검색할 파일

    public static void main(String[] args ) throws FileNotFoundException {
        log.file(path);

    }

    public static void file(String path) throws FileNotFoundException {
        File files = new File(path);

            //input stream object 생성
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(files));

    }


    public static void FindKeyword(String keword) throws IOException {
        String[] words = log.word.split(",");
        String message = "";
        BufferedReader br = null;
        String line = "";
        while ((line = br.readLine()) != null) {
            for (int j = 0; j < words.length; j++) {
                Pattern pattern = Pattern.compile("12[0-9]\\.[0-9]+," + words[j]);

                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {

                    message = message + line.trim() + "\n";
                    continue;
                }
            }
        }
    }
/*

    public static void Keyword(String resultList){

    }
*/


}
