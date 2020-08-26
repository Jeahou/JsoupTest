package JsoupExam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Lolscore {
    String search;
    String url = "https://www.op.gg/summoner/userName=";
    public static void main(String[] args) throws IOException {
        String search = " ";
        String url = "https://www.op.gg/summoner/userName=";
        Scanner s = new Scanner(System.in);
        search = s.nextLine();
        url += search;
        Document doc = Jsoup.connect(url).get();
        Elements result = doc.select("meta[name=description]");
        String s1 = result.attr("abs:content");
        Elements result1 = doc.select("meta[property=og:description]");
        String s3 = result1.attr("abs:content");
        Elements res1 = doc.select("div.Content div.KDA div.KDARatio span.KDARatio");

        System.out.println(s1);
        String[] tt = res1.text().split(" ");
        for(int i=0; i<5; i++){
            System.out.println(tt[i]);
        }
        System.out.println(s3);

    }
}
