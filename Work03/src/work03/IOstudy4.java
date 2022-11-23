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
     String fileNm = "mergeFile.txt";

    public File[] files() {
        File folder = new File(path);
        File[] fileList = folder.listFiles();
        return fileList;
    }

    public void mergefile(){
        BufferedReader fis = null;
        BufferedOutputStream fos = null;
        try {
            FileInfo fileinfo = new FileInfo();
            File mergeFile = new File("C:\\mergefolder\\" + fileNm);
            byte[] buffer = null;
            String line = "";
            fos = new BufferedOutputStream(new FileOutputStream(mergeFile));
            JSONArray json = new JSONArray(fileinfo.setFile());
            int i = 0;
            for(File file : files()){
                JSONObject object = json.optJSONObject(i);
                i++;
                //object.toString();
                byte[] ByteArray = object.toString().getBytes("UTF-8");
                System.out.println(ByteArray);
                String bytestring = new String(ByteArray);
                System.out.println(bytestring);

                //BigInteger n = new BigInteger(new String(ByteArray, "UTF-8"));
                //byte[] bytes = ByteBuffer.allocate(4).putInt(ByteArray).array();
               /* String fileName = object.optString("fileName");
                Long fileLength = object.optLong("fileLength");
                fos.write(((fileName+fileLength)+"\n").getBytes());*/

                if(file.exists() && file.isFile()){
                    fis = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                }
                while ((line = fis.readLine()) != null){
                    buffer = line.getBytes();
                    fos.write(buffer);
                    fos.write(System.lineSeparator().getBytes());
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
        io.mergefile();
        //io.restorefile();
    }
}
