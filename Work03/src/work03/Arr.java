package work03;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Arr {
    public static void main(String[] args) {

        try{
            String filePath = "C:\\testfolder\\";
            String fileName = "testfile1.txt";
            File file = new File(filePath + fileName);
            FileInputStream fi = new FileInputStream(file);
            String nFilePath = "C:\\mergefolder\\";
            String nFileName = "mergeFile.txt";
            //파일을 분할하여 저장한다
            splitFile(nFilePath, nFileName, fi);
            //분할된 파일을 합친다
            //combineFile(fileName, nFilePath);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void splitFile(String nFilePath, String nFileName, InputStream fi){
        try {
            int maxFileSize = 1024*1024*1;// 최대 사이즈
            int readCnt = 0;//읽은 수 카운트
            int totCnt = 0;//
            int fileIdx = 0;
            BufferedInputStream bfi = new BufferedInputStream(fi);
            byte[] readBuffer = new byte[2048];
            File nFile = new File(nFilePath + nFileName);
            FileOutputStream fo = new FileOutputStream(nFile);
            do {
                readCnt = bfi.read(readBuffer);
                if(readCnt == -1){
                    break;
                }
                fo.write(readBuffer,0,readCnt);
                totCnt += readCnt;
                if(totCnt%maxFileSize==0){
                    fo.flush();
                    fo.close();
                    File nfile = new File(nFilePath+ nFileName+(++fileIdx)+"._tmp");
                    fo = new FileOutputStream(nfile);
                }
            } while (true);
            fi.close();
            fo.flush();
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("##########분할완료##########");
    }

    private static void combineFile(String oriFileName, String nFilePath) throws FileNotFoundException, IOException {
        File nFiles = new File(nFilePath);
        String[] files = nFiles.list();
        FileOutputStream nFo = new FileOutputStream(nFilePath+oriFileName);
        for(int i=0;i<files.length;i++){
            FileInputStream nFi = new FileInputStream(nFilePath+files[i]);
            byte[] buf = new byte[2048];
            int readCnt = 0;
            while((readCnt =  nFi.read(buf)) >-1){
                nFo.write(buf,0,readCnt);
            }
        }
        nFo.flush();
        nFo.close();
        System.out.println("##########합치기완료##########");
    }
}
