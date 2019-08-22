package scraping;


import java.io.IOException;

public class WebScrapingAndorra {


    public static void main(String[] args) throws IOException, InterruptedException {

        GetUrlFromFile urls;
        WriteUrlsToFile writeUrl;

        writeUrl = new WriteUrlsToFile();
        //Pass number of pages you want to scrape
        writeUrl.write(".ad", 10);

        /*urls = new GetUrlFromFile();

        ScrapingUrls scrap = new ScrapingUrls(urls.getUrls());
        scrap.scrapUrls();*/

    }


}
