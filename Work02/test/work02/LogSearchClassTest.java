package work02;

import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogSearchClassTest {

    @Test
    public void testAnd() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ERROR] test error.\n");
        stringBuilder.append("[ERROR] fail.\n");

        File testFile = new File("./test.txt");
        testFile.delete();
        Files.write(testFile.toPath(), stringBuilder.toString().getBytes());

        LogSearchClass logClass = new LogSearchClass();
        logClass.setFilepath(testFile.getAbsolutePath()); //파일경로
        logClass.setKeyword("ERROR,test"); // ,를 기준으로 단어 검색
        logClass.setAnd(true); //true는 and , false는 or
        List<String> list = logClass.find();

        assertEquals("[ERROR] test error.\n", list.get(0));
        assertEquals(1, list.size());

    }


}