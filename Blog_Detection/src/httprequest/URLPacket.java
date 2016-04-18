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
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author must
 */
public class URLPacket {
    public static final String URL_FILE_NAME = "urls.txt";
    private static ArrayList<String> URL_NAME;
    private ArrayList<InfoURL> urlList;
    private FileReader inputFile = null;

    public URLPacket(){
        urlList = new ArrayList<InfoURL>();
    }

    public void readUrl(){
        openFile(URL_FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        String line;
        
        try{
            while ((line = bufferedReader.readLine()) != null)   {
                urlList.add(new InfoURL(line));
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
    
    //verilen id li URLInfo yu döndür
    public InfoURL getInfoUrl(int index){
        return urlList.get(index);
    }
    
    //verilen id icin URL dondur
    public URL getURL(int index){
        return urlList.get(index).getUrl();
    }

    public ArrayList<InfoURL> getUrlList() {
        return urlList;
    }

    public void setUrlList(ArrayList<InfoURL> urlList) {
        this.urlList = urlList;
    }
    
}
