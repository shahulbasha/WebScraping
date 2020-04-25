import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AppMain {


public static void main(String[] args){

    try {
        Document doc=Jsoup.connect("https://www.jiosaavn.com/featured/weekly-top-songs").get();
        Elements elements = doc.select("ol.track-list");
       // System.out.println(elements.select("div.song-json").first().text());
        Elements elem = elements.select("div.song-json");
        for (Element element : elem) {
            JsonElement json = JsonParser.parseString(element.text());
            System.out.println(json.getAsJsonObject().get("title"));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
