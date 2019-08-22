package scraping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUrlFromFile {

    private String url;
    List<String> urls = new ArrayList<>();

    // The name of the file to open.
    private String fileName = "urls.txt";

    public GetUrlFromFile() {

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((url = bufferedReader.readLine()) != null) {
                this.setUrls(url);

            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

    }

    public List<String> getUrls() {

        return urls;
    }

    public void setUrls(String url) {

        this.urls.add(url);
    }
}
