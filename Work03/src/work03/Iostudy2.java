package work03;
//어떤 디렉토리 경로를 입력 받아서 그 내부에 있는 모든 파일을 하나로 합쳐서 단 하나의 파일로 만드는 메서드.
//위에 메서드와 반대로 하나로 합쳐진 파일을 다시 풀어서 각각의 원본 파일로 복구하는 메서드

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Iostudy2 {
    public static void main(String[] args) throws IOException {
        //String filepath = new String("C:\\testfolder\\");
        File folder = new File("C:\\testfolder\\");
        System.out.println(mergeFiles(folder));
     //mergeFiles(folder);
    }

    public static List<String> mergeFiles(File folder) throws IOException {

        String line = "";
        List<String> fileList = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(folder));
        while ((line = br.readLine()) != null){
            fileList.add(line);
            }
        br.close();
        return fileList;
        }

}
