package work03;


import java.io.*;

public class FileInStream {
    public static void main(String[] args) throws IOException {
        String path = "C:\\testfolder";
        String targetFile = "C:\\testfolder\\resultfile.txt";

        File folder = new File(path);
        File[] fileList = folder.listFiles();
        BufferedReader input = null;
        BufferedOutputStream output = null;
        String line = null;
        byte[] data = null;
        int cnt = 0;

        try {
            output = new BufferedOutputStream(new FileOutputStream(targetFile));
            for (File file : fileList) {
                if (file.exists() && file.isFile()) {
                    if (file.toString().toUpperCase().endsWith(".DAT")) {
                        System.out.println("fileNm : ".concat(file.toString().toUpperCase()));

                        while ((line = input.readLine()) != null) {
                            data = line.getBytes();
                            System.out.println("data : ".concat(line.toString()));
                            output.write(data);
                            output.write(System.lineSeparator().getBytes());
                        }
                        cnt++;
                    }
                }
            }
            System.out.println("#########FINISH CNT : ".concat(String.valueOf(cnt)));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception ignore) {
                    System.out.println("ignore: {}" + ignore);
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (Exception ignore) {
                    System.out.println("ignore: {} " + ignore);
                }
            }
        }
    }
}