/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httprequest;

import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author must
 */
public class URLPacket {
    public static final String URL_FILE_NAME = "url.txt";
    private static ArrayList<String> URL_NAME;
    private ArrayList<InfoURL> urlList;

    //verilen id li URLInfo yu döndür
    public InfoURL getInfoUrl(int index){
        return urlList.get(index);
    }
    
    //verilen id icin URL dondur
    public URL getURL(int index){
        return urlList.get(index).getUrl();
    }
    
    public static String getURL_FILE_NAME() {
        return URL_FILE_NAME;
    }

    public static ArrayList<String> getURL_NAME() {
        return URL_NAME;
    }


    public ArrayList<InfoURL> getUrlList() {
        return urlList;
    }

    public void setUrlList(ArrayList<InfoURL> urlList) {
        this.urlList = urlList;
    }
    
    public void readUrl(){
        
    }
}
