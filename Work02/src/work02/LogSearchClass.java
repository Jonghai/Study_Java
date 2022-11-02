package work02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogSearchClass {
    private String filepath;
    private String word;
    private boolean isAnd = false;

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setAnd(boolean enable) {
        isAnd = enable;
    }

    public void setKeyword(String word) {
        this.word = word;
    }

    public void setKeyword(String... word) {
        for(String s : word) {
            this.word += "," + s;
        }
    }

    //파일경로 입력 메소드
    public File getFilepath() {
        File file = new File(filepath);
        return file;
    }

    //검색어 입력 메소드
    public String[] getKeyword(){
        String[] words = word.split(",");
        return words;
    }

    //라인별 검색 진행 메소드
    public List<String> find() throws IOException {
        String[] keywords = getKeyword();
        String line = "";
        List<String> fileList = new ArrayList<>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(getFilepath()));
        try {
            while ((line = br.readLine()) != null) {
                for (int j = 0, n = keywords.length; j < n; j++) {
                    String keyword = keywords[j];
                    if (isAnd) {
                        if (!line.contains(keyword)) {
                            break;
                        }
                        if (j == n - 1) {
                            fileList.add(line + "\n");
                        }
                    } else {
                        if (line.contains(keyword)) {
                            fileList.add(line + "\n");
                            break;
                        }
                    }
                }
            }
        } finally {
            br.close();
        }
        return fileList;
    }



}