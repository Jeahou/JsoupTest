package JsoupExam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Stock {
    String search;
    String url = "https://finance.naver.com/sise/theme.nhn";
    String time = "https://finance.naver.com/item/sise_time.nhn";
    static String day = "https://finance.naver.com/item/sise_day.nhn";
    public static void main(String[] args) throws IOException{
        String search = " ";
        String url = "https://finance.naver.com/sise/theme.nhn";
        //Scanner s = new Scanner(System.in);
        //search = s.nextLine();
        System.out.println(url);
        Document doc = Jsoup.connect(url).get();
        Elements result = doc.select("td>a");
        String s1 = result.attr("abs:href");
        //String s2 = result.attr("abs2:href");
		/*for(Element e : result) {
			System.out.println(e);
		}*/

        for(Element e : result) {
            String s = e.attr("abs:href");
            if(s.contains("no")) {
                Document d = Jsoup.connect(s).get();
                Elements re = d.select("title");
                Elements subRe = d.select("td>a");

                int idx = re.text().indexOf(":");
                System.out.println(re.text().substring(0, idx-1));
                System.out.println(s);
                System.out.println("<종목명>");
                Document d1 = Jsoup.connect(s1).get();
                Elements re1 = d1.select("title");
                Elements subRe1 = d1.select("td>a");
                for(Element a : subRe1) {
                    String subUrl = a.attr("abs:href");
                    if(subUrl.contains("main")) {
                        System.out.println(a.text());
                        System.out.println(subUrl);
                        int k = subUrl.indexOf("?");
                        System.out.println(day + subUrl.substring(k, subUrl.length())+"&thistime=20200807161011");
                    }
                }

                System.out.println(" ");
            }
        }
    }
}
