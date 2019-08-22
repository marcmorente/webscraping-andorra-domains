package scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class ScrapingUrls {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
    private List<String> urls;

    public ScrapingUrls(List<String> urls) {
        this.urls = urls;
    }

    public void scrapUrls() throws IOException {

        for (String url: this.urls) {
            Document doc = Jsoup.connect(url).userAgent(USER_AGENT).timeout(50000).get();
            System.out.println(doc.title());
        }
    }
}
