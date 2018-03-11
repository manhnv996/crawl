package util;

import model.ArticleInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlUtil {


    public static List<ArticleInfo> crawl24hBongDa(){

        String domain = "http://www.24h.com.vn";

        List<String> urlList = new ArrayList<>();

        urlList.add("http://www.24h.com.vn/bong-da-c48.html");
        urlList.add("http://www.24h.com.vn/tin-tuc-trong-ngay-c46.html");
        urlList.add("http://www.24h.com.vn/tin-tuc-quoc-te-c415.html");
        urlList.add("http://www.24h.com.vn/thoi-trang-c78.html");
        urlList.add("http://www.24h.com.vn/an-ninh-hinh-su-c51.html");
        urlList.add("http://www.24h.com.vn/thoi-trang-hi-tech-c407.html");
        urlList.add("http://www.24h.com.vn/tai-chinh-bat-dong-san-c161.html");
        urlList.add("http://www.24h.com.vn/am-thuc-c460.html");
        urlList.add("http://www.24h.com.vn/lam-dep-c145.html");
        urlList.add("http://www.24h.com.vn/doi-song-showbiz-c729.html");
        urlList.add("http://www.24h.com.vn/giai-tri-c731.html");
        urlList.add("http://www.24h.com.vn/ban-tre-cuoc-song-c64.html");
        urlList.add("http://www.24h.com.vn/giao-duc-du-hoc-c216.html");
        urlList.add("http://www.24h.com.vn/the-thao-c101.html");
        urlList.add("http://www.24h.com.vn/phi-thuong-ky-quac-c159.html");
        urlList.add("http://www.24h.com.vn/cong-nghe-thong-tin-c55.html");
        urlList.add("http://www.24h.com.vn/o-to-c747.html");
        urlList.add("http://www.24h.com.vn/xe-may-xe-dap-c748.html");
        urlList.add("http://www.24h.com.vn/thi-truong-tieu-dung-c52.html");
        urlList.add("http://www.24h.com.vn/du-lich-24h-c76.html");
        urlList.add("http://www.24h.com.vn/suc-khoe-doi-song-c62.html");
//        String url = "http://www.24h.com.vn/bong-da-c48.html";
//        String url = "http://www.24h.com.vn/tin-tuc-trong-ngay-c46.html";
//        String url = "http://www.24h.com.vn/tin-tuc-quoc-te-c415.html";
//        String url = "http://www.24h.com.vn/thoi-trang-c78.html";
//        String url = "http://www.24h.com.vn/an-ninh-hinh-su-c51.html";
//        String url = "http://www.24h.com.vn/thoi-trang-hi-tech-c407.html";
//        String url = "http://www.24h.com.vn/tai-chinh-bat-dong-san-c161.html";
//        String url = "http://www.24h.com.vn/am-thuc-c460.html";
//        String url = "http://www.24h.com.vn/lam-dep-c145.html";
//        String url = "http://www.24h.com.vn/doi-song-showbiz-c729.html";
//        String url = "http://www.24h.com.vn/giai-tri-c731.html";
//        String url = "http://www.24h.com.vn/ban-tre-cuoc-song-c64.html";
//        String url = "http://www.24h.com.vn/giao-duc-du-hoc-c216.html";
//        String url = "http://www.24h.com.vn/the-thao-c101.html";
//        String url = "http://www.24h.com.vn/phi-thuong-ky-quac-c159.html";
//        String url = "http://www.24h.com.vn/cong-nghe-thong-tin-c55.html";
//        String url = "http://www.24h.com.vn/o-to-c747.html";
//        String url = "http://www.24h.com.vn/xe-may-xe-dap-c748.html";
//        String url = "http://www.24h.com.vn/thi-truong-tieu-dung-c52.html";
//        String url = "http://www.24h.com.vn/du-lich-24h-c76.html";
//        String url = "http://www.24h.com.vn/suc-khoe-doi-song-c62.html";

        List<ArticleInfo> articleInfoList = new ArrayList<>();


        for (String url : urlList) {
            try {
                Document document = Jsoup.connect(url).timeout(5000).get();
                Element elementPageLayout = document.select("div[class=pagination-cate marB10]").first();

                Elements elementPage = elementPageLayout.select("a[class=page-link]");
                int pageNum = elementPage.size() - 2;

                //
                for (int i = 1; i <= pageNum; i++) {
                    String pageUrl = url + "?vpage=" + i;
                    Document pageDocument = Jsoup.connect(pageUrl).timeout(5000).get();


                    Elements elements = pageDocument.select("div[class=boxDoi-sub-Item-trangtrong]");
                    elements.addAll(
                            pageDocument.select("div[class=boxDoi-sub-Item-trangtrong marL10]")
                    );
                    for (Element e : elements) {

                        Elements elements1 = e.getElementsByTag("a");
                        for (Element element1 : elements1) {
                            if (element1.hasAttr("title") && element1.hasAttr("href")
                                    && (element1.attr("href").indexOf("http") < 0)) {

                                Document documentContent = Jsoup.connect(domain + element1.attr("href")).timeout(5000).get();
                                Element elementContent = documentContent.selectFirst("div[class=text-conent]");

                                if (elementContent != null /*&& elementContent.hasAttr("articleBody")*/) {
                                    Elements paragraph = elementContent.getElementsByTag("p");


                                    StringBuilder sb = new StringBuilder();
                                    for (Element p : paragraph) {
                                        if (/*!p.hasAttr("style") && !p.hasAttr("align") &&*/ !p.ownText().trim().equals("")) {
                                            sb.append(p.ownText() + "\n");
                                        }
                                    }

                                    ArticleInfo articleInfo = new ArticleInfo();
                                    articleInfo.setTitle(element1.attr("title"));
                                    articleInfo.setUrl(domain + element1.attr("href"));
                                    articleInfo.setContent(sb.toString());

                                    articleInfoList.add(articleInfo);
                                }
                                break;
                            }
                        }

//                    Element hasContent = e.selectFirst("span[class=news-sapo]");
//
//                    if (hasContent != null){
//                        Elements elements1 = e.getElementsByTag("a");
//                        String content = hasContent.ownText().trim();
//
//                        for (Element element1 : elements1){
//                            if (element1.hasAttr("title") && element1.hasAttr("href") && !content.equals("")){
//
//                                System.out.println(element1.attr("title"));
//                                System.out.println(domain + element1.attr("href"));
//                                System.out.println(content);
//                                System.out.println("=================");
//                                break;
//                            }
//                        }
//                    }
                    }
                }

//            for (ArticleInfo a : articleInfoList){
//                System.out.println(a.getContent());
//                System.out.println(a.getUrl());
//            }
                System.out.println(articleInfoList.size());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return articleInfoList;
    }


}
