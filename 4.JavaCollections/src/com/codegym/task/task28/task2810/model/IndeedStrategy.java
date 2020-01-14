package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndeedStrategy implements Strategy{
    static private final String URL_FORMAT = "https://www.indeed.com/jobs?q=java+%s&start=%d";
    //static private final String URL_FORMAT = "https://codegym.cc/testdata/big28data2.html?text=java+%s&page=%d";

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
            Elements elements = document.getElementsByClass("jobsearch-SerpJobCard");
            //Elements elements = document.getElementsByAttributeValue("class", "jobsearch");
            if(elements.size()==0) break;
            for(Element e:elements){
                    //if(e.attr("class").contains("result")) {    //filter for "Recommended jobs for you"
                        JobPosting newPost = new JobPosting();
                        newPost.setTitle(e.getElementsByTag("a").first().attr("title").trim());
                        newPost.setCity(e.getElementsByClass("location").text().trim());
                        newPost.setCompanyName(e.getElementsByClass("company").text().trim());
                        newPost.setUrl(e.getElementsByTag("a").first().attr("href").trim());
                        newPost.setWebsiteName(URL_FORMAT);
                        jobPostingList.add(newPost);
            }
            i=i+10;     //numeration of pages on Indeed 0 10 20 ...
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
