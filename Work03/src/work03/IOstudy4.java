package work03;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;


/*class ObjectTest {
    String strValue = UUID.randomUUID().toString();
    int intValue = (int)Math.random();

    ArrayList<String> list = new ArrayList<>();

    ObjectTest() {
        for(int i = 0; i < 10; ++i) {
            list.add(i + "");
        }
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject().put("strValue",strValue).put("intValue", intValue);
        JSONArray jsonArray = new JSONArray();
        for(String str : list) {
            jsonArray.put(str);
        }
        jsonObject.put("list", jsonArray);
        return jsonObject;
    }

    public static ObjectTest fromJSON(JSONObject jsonObject) {
        ObjectTest test = new ObjectTest();
        test.list.clear();
        test.intValue = jsonObject.optInt("intValue");
        test.strValue = jsonObject.optString("strValue");
        JSONArray jsonArray = jsonObject.optJSONArray("list");
        for(int i = 0, n = jsonArray.length(); i < n; ++i) {
            String value = jsonArray.getString(i);
            test.list.add(value);
        }
        return test;
    }

}*/

public class IOstudy4 {
    private String fileName;
    private  long fileLength;
    //테스트 파일 리스트
    public File[] files() {
        String path = "Work03/testfolder/";
        File folder = new File(path);
        File[] fileList = folder.listFiles();
        return fileList;
    }
    //파일 정보(이름, 크기) JSONArray에 담는 메서드
    public JSONArray setFile(){
        IOstudy4 io = new IOstudy4();
        JSONArray array = new JSONArray();
        JSONObject json = null;
        for (File file : io.files()) {
            json = new JSONObject();
            fileName = file.getName();
            fileLength = file.length();
            json.put("fileName", fileName);
            json.put("fileLength", fileLength);
            array.put(json);
        }
        return array;
    }


    //어떤 디렉토리 경로를 입력 받아서 그 내부에 있는 모든 파일을 하나로 합쳐서 단 하나의 파일로 만드는 메서드.
    public void mergefile(String gtrd, File mergefolder){
        IOstudy4 io4 = new IOstudy4();
        if(!mergefolder.exists())mergefolder.mkdirs();
        FileInputStream fis = null;
        BufferedOutputStream fos = null;
        try {
            // byte[] buffer = null;
            fos = new BufferedOutputStream(new FileOutputStream(gtrd));
            JSONArray json = new JSONArray(io4.setFile());
            int i = 0;
            for(File file : files()){
                JSONObject object = json.optJSONObject(i);
                i++;
                fos.write(((object)+"\n").getBytes());
                byte[] buffer = new byte[4096];
                int readCount = 0;
                if(file.exists() && file.isFile()){
                    fis = new FileInputStream(file);
                    while ((readCount = fis.read(buffer, 0, buffer.length)) > 0){//read() = 파일끝에 도달하면 -1을 반환/그러니 0보다 작아질때까지 반복
                        fos.write(buffer, 0, readCount);
                    }
                }
            }
            //System.out.println("파일병합완료");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SafeClose.execute(fis);
            SafeClose.execute(fos);
        }
    }

    //위에 메서드와 반대로 하나로 합쳐진 파일을 다시 풀어서 각각의 원본 파일로 복구하는 메서드
    public void unmergeFile(File gtrd, File unmergefolder) throws IOException {
        IOstudy4 io4 = new IOstudy4();
        if(!unmergefolder.exists())unmergefolder.mkdirs();
        //else throw new IOException("대상경로가 디렉토리가 아닌 파일입니다.");
        FileInputStream fis = new FileInputStream(gtrd);
        FileOutputStream fos = null;
        byte[] buffer = null;
        int oneByteData = -1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JSONArray metaData = new JSONArray(io4.setFile());
        try {
            for (int i = 0; i < metaData.length(); i++) {
                while ((oneByteData = fis.read()) > 0) {
                    if ((byte) oneByteData == '\n') break;
                }
                JSONObject object = metaData.optJSONObject(i);
                String fileName = object.optString("fileName");
                long fileLength = object.optLong("fileLength");
                File testFile = new File("Work03/unmergefolder/" + fileName);
                testFile.delete();
                fos = new FileOutputStream(testFile);
                buffer = new byte[4096];
                int readCount = 0;
                int totalReadLength = (int) fileLength;
                int readBufferLen = Math.min(totalReadLength, buffer.length);

                while ((readCount = fis.read(buffer, 0, readBufferLen)) > 0) {
                    fos.write(buffer, 0, readCount);
                    totalReadLength -= readCount;
                    if (totalReadLength <= 0) break;
                    readBufferLen = Math.min(totalReadLength, buffer.length);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SafeClose.execute(fis);
            SafeClose.execute(fos);
        }
    }

    public static void main(String[] args) throws IOException {

       /* String data = new ObjectTest().toJSON().toString();
        System.out.println(data);

        ObjectTest parsedData = ObjectTest.fromJSON(new JSONObject(data));
        System.out.println(parsedData.toJSON());

        if(1 < 2) return;*/

        IOstudy4 io4 = new IOstudy4();
        //합칠파일 or 복구할 파일
        String gtrd = "Work03/mergefolder/mergeFile.gtrd";
        //합칠 파일/합칠 폴더경로
        //io4.mergefile(gtrd, new File("Work03/mergefolder/"));
        //복구할 파일/ 복구할 폴더경로
        io4.unmergeFile(new File (gtrd), new File("Work03/unmergefolder/"));

    }
}