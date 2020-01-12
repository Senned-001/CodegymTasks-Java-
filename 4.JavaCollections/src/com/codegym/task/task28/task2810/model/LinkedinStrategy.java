package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy{
    static private final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";
    //static private final String URL_FORMAT = "http://codegym.cc/testdata/big28data.html?text=java+%s&page=%d";
    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> jobPostingList = new ArrayList<>();
        int i=0;
        while (true){
            Document document= null;
            try {
                document = getDocument(searchString,i);
            } catch (IOException e) {

            }
            Elements elements = document.getElementsByClass("jobs-search-result-item");
            if(elements.size()==0) break;
            for(Element e:elements){
                if(e!=null) {
                    JobPosting newPost = new JobPosting();
                    newPost.setTitle(e.getElementsByClass("listed-job-posting__title").text());
                    newPost.setCity(e.getElementsByClass("listed-job-posting__location").text());
                    newPost.setCompanyName(e.getElementsByClass("listed-job-posting__company").text());
                    Element link1 = e.select("meta[itemprop=url]").first();
                    newPost.setUrl(link1.attr("content"));
                    newPost.setWebsiteName(URL_FORMAT);
                    if(!jobPostingList.contains(newPost))
                    jobPostingList.add(newPost);
                }
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
