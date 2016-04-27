package file_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    private File file;
    private FileReader fileReader;
    private String fileName;
    private BufferedReader bufferedReader;
    
    public ReadFile(String fileName){
        this.fileName = fileName;
        file = new File(fileName);
    }
    
    //url ve keyword listesi okurken kullan
    public ArrayList<String> read(){
        String line;
        ArrayList<String> wordList = new ArrayList<String>();
        
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            
            line = bufferedReader.readLine();
            
            while(line != null){
                wordList.add(line);
                line = bufferedReader.readLine();
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
        
        return wordList;
    }
}
