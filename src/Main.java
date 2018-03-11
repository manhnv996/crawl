import util.CrawlUtil;
import util.ExportFileUtil;

public class Main {

    public static void main(String[] args) {
//        CrawlUtil.crawl24hBongDa();
        ExportFileUtil.ExportArticleInfoModelToJsonFile(CrawlUtil.crawl24hBongDa(), "C:\\Users\\DELL\\Desktop\\crawl24h.json");
    }

}
