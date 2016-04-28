package dataset;

import file_IO.WriteFile;
import url_info.UrlList;

public class Main {
    public static void main(String args[]){

        UrlList urls = new UrlList();
        urls.createFiles();
        urls.readSourceCode();
        urls.countUrlKeyword();
        
        
        WriteFile wf = new WriteFile("raw_dataset.txt");
        wf.writeKeywords(urls);
    }

}
