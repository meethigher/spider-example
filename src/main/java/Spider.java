import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Spider {

    private static final Logger log = LoggerFactory.getLogger(Spider.class);

    public static void main(String[] args) throws Exception {
        try (OutputStream fos = new FileOutputStream("C:\\Users\\meethigher\\Desktop\\video1.txt")) {
            for (int i = 1; i <= 88; i++) {
                HttpResponse send = HttpRequest.get(String.format("https://test.com/home/vodlist/7/725-%s.html", i))
                        .charset("utf-8")
                        .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 54_18_8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.52")
                        .send()
                        .charset("utf-8");
                Document parse = Jsoup.parse(send.bodyText());
                Elements elementsByClass = parse.getElementsByClass("vodname");
                fos.write("========================================\n".getBytes(StandardCharsets.UTF_8));
                fos.write(("页码" + i + "\n").getBytes(StandardCharsets.UTF_8));
                for (Element element : elementsByClass) {
                    String s = element.text() + "\n";
                    fos.write(s.getBytes(StandardCharsets.UTF_8));
                }
                log.info("第" + i + "页已完成");
            }
            Thread.sleep(2000L);
        }
    }
}
