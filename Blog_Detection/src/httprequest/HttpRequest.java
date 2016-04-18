/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author must
 */
public class HttpRequest {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URLPacket up = new URLPacket();
        
        URLConnection uc = up.getURL(0).openConnection();
      
        /*ArrayList<URL> urlList = new ArrayList<URL>();
        urlList.add(new URL("https://www.ce.yildiz.edu.tr/"));
        urlList.add(new URL("https://www.mserdark.com/"));
        urlList.add(new URL("http://www.bloggerbuster.com//"));
        urlList.add(new URL("http://www.injavawetrust.com/"));
        urlList.add(new URL("http://www.aysebilge.com/"));
        
        URLConnection uConnection;
        BufferedReader in;
        String inputLine;
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("href");
        keywords.add("meta");
        keywords.add("link");
        
        for(int i=0; i<urlList.size(); i++){
            uConnection = urlList.get(i).openConnection();
            in = new BufferedReader(new InputStreamReader(
                                        uConnection.getInputStream()));
            
            while(inputLine = in.readLine()) != null){
                
            }
        }
        
        
        String word = "sda type";
        int count = 0;
        
       // Pattern p = Pattern.compile(word);
        Matcher m;
        
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
            boolean b = inputLine.contains(word);
            
            if(b == true)
                count++;
                
        }
        
        //in.close();
        
        System.out.println(count);*/
    }
    
}
