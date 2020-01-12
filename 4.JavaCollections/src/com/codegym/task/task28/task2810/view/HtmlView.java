package com.codegym.task.task28.task2810.view;

import com.codegym.task.task28.task2810.Controller;
import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath="./4.JavaCollections/src/"+this.getClass().getPackage().getName().replace('.', '/')+"/jobPostings.html";

    public void emulateCitySelection(){
        controller.onCitySelected("San Francisco");
    }

    @Override
    public void update(List<JobPosting> jobPostings) {
         updateFile(getUpdatedFileContents(jobPostings));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private String getUpdatedFileContents(List<JobPosting> jobPostings){
        Document doc = null;
        try {
            doc = getDocument();

            Element template = doc.getElementsByClass("template").first();
            Element copytemplate = template.clone();
            copytemplate.removeAttr("style");
            copytemplate.removeClass("template");

            doc.getElementsByAttributeValueEnding("class", "vacancy").remove();
            //doc.select("tr[class=vacancy]").remove().not("tr[class=vacancy template");
            for(JobPosting jp:jobPostings){
                Element newelement = copytemplate.clone();
                Element title = newelement.getElementsByTag("a").first();
                Element city = newelement.getElementsByClass("city").first();
                Element companyName = newelement.getElementsByClass("companyName").first();

                title.attr("href",jp.getUrl());
                title.text(jp.getTitle());
                city.text(jp.getCity());
                companyName.text(jp.getCompanyName());

                template.before(newelement.outerHtml());
            }
        } catch (Exception e) {
                e.printStackTrace();
            return "Some exception occurred";
        }
        return doc.html();
    }

    private void updateFile(String name){
        try (FileOutputStream fos = new FileOutputStream(filePath)){
            fos.write(name.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
