/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httprequest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author must
 */
public class InfoURL {
    public final static String KEYWORD_FILE_NAME = "keyword.txt"; 
    private static ArrayList<Keyword> KEYWORD_LIST = new ArrayList<Keyword>();
    private String name;
    private ArrayList<Keyword> keywordList;
    private URL url;
    private FileReader inputFile = null;
    
    
    public InfoURL(String name) throws MalformedURLException{
        keywordList = KEYWORD_LIST;
        url = new URL(name);
        keywordList = new ArrayList<Keyword>();
    }
    
    public InfoURL(){
        keywordList = new ArrayList<Keyword>();
    }
    
    public void readKeyword(){
        String line;
        
        openFile("keywords.txt");
        BufferedReader bufferedReader = new BufferedReader(inputFile);

        try{
            while ((line = bufferedReader.readLine()) != null)   {
                KEYWORD_LIST.add(new Keyword(line));
              }
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
     public void openFile(String fileName){
       
        try{
            inputFile = new FileReader(fileName);
        }catch(FileNotFoundException e){
            System.err.println(e);
        }
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

