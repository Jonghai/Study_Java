package work03;

import java.io.*;

public class IOstudy3 {
    public static void main(String[] args) throws IOException {
            String path = "C:\\testfolder\\";
            String fileNm = "mergeFile.txt";
            File mergeFile = new File(path + "mergefolder\\" + fileNm);
            File folder = new File(path);
            File[] fileList = folder.listFiles();
            BufferedReader input = null;
            BufferedOutputStream output = null;
            String line = "";
            byte[] data = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream(mergeFile));
            for (File file : fileList) {
                if (file.exists() && file.isFile()) {
                    input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    while ((line = input.readLine()) != null) {
                        data = line.getBytes();
                        output.write(data);
                        output.write(System.lineSeparator().getBytes());
                    }
                }
            }
        }finally {
            if(input != null){
                try {
                    input.close();
                }catch (Exception ignore){
                    System.out.println("ignore: {} "+ignore);
                }
            }
            if(output !=null){
                try {
                    output.close();;
                }catch (Exception ignore){
                    System.out.println("ignore: {} "+ignore);
                }
            }
        }
    }
}