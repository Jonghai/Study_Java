package work03;

import java.io.Closeable;
import java.io.IOException;

public class SafeClose {
    public final static void execute(Closeable closeable) {
        if(closeable == null) return;
        try {
            closeable.close();
        } catch (IOException e) {
            // 로거로 출력 해줘야함.
        }
    }
}
