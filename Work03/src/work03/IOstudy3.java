package work03;

import java.io.*;

public class IOstudy3 {
    public static void main(String[] args) throws IOException {
        try {
            String path = "C:\\testfolder\\";
            String fileNm = "mergeFile.txt";
            File mergeFile = new File(path + "mergefolder\\" + fileNm);
            File folder = new File(path);
            File[] fileList = folder.listFiles();

            for (File file : fileList) {
                if (file.exists() && file.isFile()) {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = "";
                    String result = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line + "\n";
                    }
                    //System.out.println(result);

                    FileWriter fileWriter = new FileWriter(mergeFile);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    if (!result.isEmpty()) {
                        bufferedWriter.write(result);
                    }
                    System.out.println(result);
                    fileReader.close();
                    bufferedReader.close();
                    bufferedWriter.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
