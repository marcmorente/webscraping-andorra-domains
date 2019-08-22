package scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WriteUrlsToFile {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
    private List<String> urls = new ArrayList<>();

    public void write(String search, int numOfPages) throws InterruptedException, IOException {
        PrintWriter writer = new PrintWriter("urls.txt", "UTF-8");

        for (int i = 0; i <= numOfPages; i+=10) {
            Document doc = Jsoup.connect("https://google.com" + "/search?q="+ search +"&start="+ i).userAgent(USER_AGENT).get();
            Element content = doc.getElementById("rso");
            Elements links = content.select("div.rc > div.r > a");

            for (Element el : links) {
                String linkHref = el.attr("href");

                if (! linkHref.contains("translate.google") && linkHref.contains(".ad")) {
                    URL url = new URL(linkHref);
                    String validURL = url.getProtocol() + "://" + url.getHost();

                    //Check if exist url and then write it
                    if (!this.getUrls().contains(validURL)) {
                        this.setUrls(validURL);
                        writer.println(validURL);
                        System.out.println(validURL);
                    }

                }
            }

            TimeUnit.MINUTES.sleep(2);

        }

        writer.close();

    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(String url) {
        this.urls.add(url);
    }
}
