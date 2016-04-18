/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author ercan
 */
public class ReadInfo{
    private final ArrayList<URL> urlList = new ArrayList<>();
    private final ArrayList<String> keywordList = new ArrayList<>();    
    private String line;
    private FileReader inputFile = null;
    
        
    public ArrayList<URL> getURLList(){
        return urlList;
    }
    
    public ArrayList<String> getKeywordList(){
        return keywordList;
    }
    
    public void ReadURLs(){
        openFile("urls.txt");
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        
        try{
            while ((line = bufferedReader.readLine()) != null)   {
                urlList.add(new URL(line));
              }
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    public void ReadKeywords(){
        openFile("keywords.txt");
        BufferedReader bufferedReader = new BufferedReader(inputFile);

        try{
            while ((line = bufferedReader.readLine()) != null)   {
                keywordList.add(line);
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
}
