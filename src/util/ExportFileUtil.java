package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import model.ArticleInfo;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExportFileUtil {

    public static void ExportArticleInfoModelToJsonFile(List<ArticleInfo> articleInfoList, String outputFileName){


        JsonWriter writer;

        try {
            writer = new JsonWriter(new FileWriter(outputFileName));


//            writer.name("messages"); // "messages" :
            writer.beginArray(); // [

            for (ArticleInfo info : articleInfoList){
                writer.beginObject(); // {

                writer.name("origin").value(info.getOrigin()); // "name" : "mkyong"
                writer.name("url").value(info.getUrl()); // "age" : 29
                writer.name("title").value(info.getTitle()); // "age" : 29
                writer.name("content").value(info.getContent()); // "age" : 29

                writer.endObject(); // }
            }

//            writer.value("msg 1"); // "msg 1"
//            writer.value("msg 2"); // "msg 2"
//            writer.value("msg 3"); // "msg 3"
            writer.endArray(); // ]


            writer.close();

            System.out.println("Done");


        } catch (IOException e) {
            e.printStackTrace();
        }


//        Gson gson = new Gson();
//
////        List<ArticleInfo> articleInfoList = CrawlUtil.crawl24hBongDa();
//
//
//        try {
//            // 1. Java object to JSON, and save into a file
//            gson.toJson(articleInfoList, new FileWriter(outputFileName));
//
//        } catch (IOException ex) {
//            Logger.getLogger(ExportFileUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // 2. Java object to JSON, and assign to a String
////        String jsonInString = gson.toJson(ds);
////        System.out.println(jsonInString);
    }

}
