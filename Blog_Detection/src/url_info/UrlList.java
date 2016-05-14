package url_info;

import file_IO.ReadFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrlList {
    private static ArrayList<String> ALL_BLOG_URLS = new ArrayList<>(); 
    private static ArrayList<String> ALL_NOT_BLOG_URLS = new ArrayList<>();
    private final ArrayList<Url> urlList; 
    private static final String BLOG_FILE_NAME = "blogs.txt";
    private static final String NOT_BLOG_FILE_NAME = "notblogs.txt";
    
    
    public UrlList(boolean isBlog){
        urlList = new ArrayList<>();
        ReadFile readFile;
        
        if(isBlog == true && ALL_BLOG_URLS.isEmpty()){
            readFile = new ReadFile(BLOG_FILE_NAME); 
            ALL_BLOG_URLS = readFile.read();
        }
        else if(ALL_NOT_BLOG_URLS.isEmpty()){
            readFile = new ReadFile(NOT_BLOG_FILE_NAME);
            ALL_NOT_BLOG_URLS = readFile.read();
        }
        
        if(isBlog)
            for(int i=0; i<ALL_BLOG_URLS.size(); i++){
                urlList.add(new Url(ALL_BLOG_URLS.get(i),i));
            }
        else{
            for(int i=0; i<ALL_NOT_BLOG_URLS.size(); i++){
                urlList.add(new Url(ALL_NOT_BLOG_URLS.get(i),i));
            }
        }
    }
    
    //listedeki tüm url lerin kaynak kodlarını oku
    public void readSourceCode(){
        for(int i=0; i<urlList.size(); i++){
            urlList.get(i).readContent();
        }
    }
    
    //listedeki tüm urller için keywordleri say
    public void countUrlKeyword(){
        for(int i=0; i<urlList.size(); i++){
            urlList.get(i).countKeywords();
        }
    }
    
    public void createFiles(){
        String inputLine;
        File file;
        PrintWriter writer;
        BufferedReader in;
        int count = 0;

        for(int i=0; i<urlList.size(); i++){
            MyThread thread = new MyThread(urlList.get(i));
            thread.start();
        }
    }
    
    
    public Url getUrl(int index){
        return urlList.get(index);
    }
    
    public ArrayList<Url> getUrlList() {
        return urlList;
    }

}
