package work03;

import java.io.*;

/*class fileinfo{
    String fileNm;
    long fileLength;

    public void setFile(){
        IOstudy4 io = new IOstudy4();
        for(File file : io.files()){

        }

    }

}*/

public class IOstudy4 {
     String path = "C:\\testfolder\\";
     String fileNm = "mergeFile.txt";

    public File[] files() throws IOException {
        File folder = new File(path);
        File[] fileList = folder.listFiles();
        return fileList;
    }

    public void data() {

    }

    public void mergefile(){
        BufferedReader fis = null;
        BufferedOutputStream fos = null;

        try {
            File mergeFile = new File("C:\\mergefolder\\" + fileNm);
            byte[] buffer = null;
            String line = "";
            fos = new BufferedOutputStream(new FileOutputStream(mergeFile));
            for(File file : files()){
                fos.write((file.getName()+file.length()+"\n").getBytes());
                if(file.exists() && file.isFile()){
                    fis = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                }
                while ((line = fis.readLine()) != null){
                    buffer = line.getBytes();
                    fos.write(buffer);
                    fos.write(System.lineSeparator().getBytes());
                }
            }
            System.out.println("완료");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fis !=null)fis.close();
                if(fos !=null)fos.close();
            }catch (Exception e){}
        }
    }

    public static void main(String[] args) throws IOException {
        IOstudy4 io = new IOstudy4();
        //fileinfo finfo = new fileinfo();
        io.mergefile();
        //finfo.setFile();
        //io.files();
    }
}