/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httprequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author must
 */
public class InfoURL {
    public final static String KEYWORD_FILE_NAME = "keyword.txt"; 
    private static ArrayList<Keyword> KEYWORD_LIST;
    private String name;
    private ArrayList<Keyword> keywordList;
    URL url;
    
    public InfoURL(String name) throws MalformedURLException{
        keywordList = KEYWORD_LIST;
        url = new URL(name);
    }
    
    public void readKeyword(){
        
        //KEYWORDLIST OLUSTU !!!
        //1 kere okuancak singleton?
    }
    
    public static ArrayList<Keyword> getKEYWORD_LIST() {
        return KEYWORD_LIST;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Keyword> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(ArrayList<Keyword> keywordList) {
        this.keywordList = keywordList;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}

