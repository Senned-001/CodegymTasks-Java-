package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy{
    //static private final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";
    static private final String URL_FORMAT = "http://codegym.cc/testdata/big28data.html?text=java+%s&page=%d";
    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> jobPostingList = new ArrayList<>();
        int i=0;
        while(true){
            Document document= null;
            try {
                document = getDocument(searchString,i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<Element> elements = document.getElementsByClass("jobs-search-result-item");
            if(elements.size()==0) break;
            for(Element e:elements){

                String title=e.getElementsByClass("listed-job-posting__title").text();
                System.out.println("title="+title);
                String city = e.getElementsByClass("listed-job-posting__location").text();
                System.out.println("city="+city);
                String companyName = e.getElementsByClass("listed-job-posting__company").text();
                System.out.println("companyName="+companyName);
                Element link1=e.select("meta[itemprop=url]").first();
                String url = link1.attr("content");
                System.out.println("url="+url);
                URL www = null;
                try {
                    www = new URL(URL_FORMAT);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                String websiteName = www.getHost();
                //Element link2 = e.getElementsByTag("a").first();
                //String websiteName = link2.attr("href");
                System.out.println("websiteName="+websiteName);

                jobPostingList.add(new JobPosting(title,city,companyName,websiteName,url));
            }
            i++;
        }
        return jobPostingList;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        String myURL = String.format(URL_FORMAT, searchString, page);
        Document doc=null;
        try {
            doc = Jsoup.connect(myURL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36").referrer("").get();
        } catch (IOException e) {

        }
        return doc;
    }
}
