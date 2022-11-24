package work03;

//어떤 디렉토리 경로를 입력 받아서 그 내부에 있는 모든 파일을 하나로 합쳐서 단 하나의 파일로 만드는 메서드.
//위에 메서드와 반대로 하나로 합쳐진 파일을 다시 풀어서 각각의 원본 파일로 복구하는 메서드



import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;

class FileInfo{
    String fileName;
    long fileLength;

    public JSONArray setFile() throws IOException {
        IOstudy4 io = new IOstudy4();
        JSONArray array = new JSONArray();
        for(File file : io.files()){
            JSONObject json = new JSONObject();
            fileName = file.getName();
            fileLength = file.length();
            json.put("fileName",fileName);
            json.put("fileLength",fileLength);
            array.put(json);
        }
        //System.out.println(array.opt(3));
        return array;
    }
}
public class IOstudy4 {
     String path = "C:\\testfolder\\";
     String fileNm = "mergeFile.gtrd";

    public File[] files() {
        File folder = new File(path);
        File[] fileList = folder.listFiles();
        return fileList;
    }

    public void unmergeFile(File gtrd, File directory) throws IOException {
       // if(!directory.exists()) directory.mkdirs();
        FileInputStream fis = new FileInputStream(gtrd);
        int oneByteData = -1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while((oneByteData = fis.read(fis, 0, 1)) > 0) {
            if ((byte) oneByteData == '\n') break;
            baos.write((byte) oneByteData);
        }
        System.out.println(baos);
        String metaDataJson = baos.toString();
        JSONObject metaData = new JSONObject(metaDataJson);
        String FileName = metaData.optString("fileName");
        long FileLength = metaData.optLong("fileLength");
        //System.out.println(FileName);
        BufferedWriter testfiles = new BufferedWriter(new FileWriter("C:\\mergefolder\\"+FileName));
        //testfiles.write(fis,0,);
        //testfiles.close();
    }

    public void mergefile(){
        FileInputStream fis = null;
        BufferedOutputStream fos = null;
        try {
            FileInfo fileinfo = new FileInfo();
            File mergeFile = new File("C:\\mergefolder\\" + fileNm);
            byte[] buffer = null;
            fos = new BufferedOutputStream(new FileOutputStream(mergeFile));
            JSONArray json = new JSONArray(fileinfo.setFile());
            int i = 0;
            for(File file : files()){
                JSONObject object = json.optJSONObject(i);
                i++;
                fos.write(((object)+"\n").getBytes());

                buffer = new byte[4096];
                int readCount = 0;
                if(file.exists() && file.isFile()){
                    fis = new FileInputStream(file);
                    while ((readCount = fis.read(buffer, 0, buffer.length)) > 0){//read() = 파일끝에 도달하면 -1을 반환/그러니 0보다 작아질때까지 반복
                       fos.write(buffer, 0, readCount);
                    }
                }
            }
            System.out.println("파일병합완료");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fis !=null)fis.close();
                if(fos !=null)fos.close();
            }catch (Exception e){}
        }
    }

    /*public void restorefile() throws IOException {
        FileInfo fileInfo = new FileInfo();
        File mergefile = new File("C:\\mergefolder\\" + fileNm);
        BufferedReader fis = null;
        String line = null;
        if(mergefile.exists() && mergefile.isFile()){
            fis = new BufferedReader(new InputStreamReader(new FileInputStream(mergefile)));

        }
        while ((line = fis.readLine()) != null){
            if(fileInfo.fileName+fileInfo.fileLength == Line)
        }
    }*/

    public static void main(String[] args) throws IOException {
        IOstudy4 io = new IOstudy4();
        //FileInfo fileInfo = new FileInfo();
        //fileInfo.setFile();
        //io.mergefile();
        io.unmergeFile(new File("C:\\mergefolder\\mergeFile.gtrd"), null);
    }
}
