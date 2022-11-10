package work02;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LogSearchClassTest {

    @Test
    public void testAnd() throws IOException {

        //StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("[ERROR] test error.\n");
        //stringBuilder.append("[ERROR] fail.\n");

        File testFile = new File("C:\\Users\\CLIPSOFT\\Documents\\logFiles\\beom-developer.api.2022-10-14_0.log");
        //testFile.delete();
        //Files.write(testFile.toPath(), stringBuilder.toString().getBytes());

        LogSearchClass logClass = new LogSearchClass();
        logClass.setFilepath(String.valueOf(testFile)); //파일경로
        logClass.setKeyword("DOC"); // ,를 기준으로 단어 검색
        logClass.setAnd(false);//true는 and , false는 or
        List<String> list = logClass.find();



        //assertEquals(list.contains("DOC"),false);
        assertEquals(2, list.size());

    }


}