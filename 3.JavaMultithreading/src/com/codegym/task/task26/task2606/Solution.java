package com.codegym.task.task26.task2606;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
Those who love work need no entertainment

*/
public class Solution {
    private final URL codegymUrl;
    private final URL codegymUrl1Child;
    private final URL codegymFbGroupUrl;
    private final URL codegymFbGroupUrl1Child;
    private final URL codegymFbGroupUrl2Child;
    private final URL codegymFbGroupUrl3Child;

    private volatile ExecutorService executorService;
    private final Set<URL> urlsForProcessing = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Solution solution = new Solution();
        solution.start();
        Thread.sleep(1000);
        solution.stop();
    }

    public Solution() throws MalformedURLException {
        codegymUrl = new URL("http://codegym.cc/");
        codegymFbGroupUrl = new URL("https://www.facebook.com/codegym.cc/");
        codegymUrl1Child = new URL("https://codegym.cc/about/faq");
        codegymFbGroupUrl1Child = new URL("https://plus.google.com/u/0/112826988801758485947/about");
        codegymFbGroupUrl2Child = new URL("https://www.facebook.com/pg/codegym.cc/notes");
        codegymFbGroupUrl3Child = new URL("https://twitter.com/codegym_cc");

        urlsForProcessing.add(codegymUrl);
        urlsForProcessing.add(codegymFbGroupUrl);
    }

    public synchronized void start() {
        executorService = Executors.newCachedThreadPool();
        for (URL url : urlsForProcessing) {
            submitUrlTask(url);
        }
        urlsForProcessing.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUnprocessedUrls(executorService.shutdownNow());
            if (executorService.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                saveUnprocessedUrls(getCancelledTasksFromExecutor());
            }
        } finally {
            executorService = null;
        }
    }

    private List<Runnable> getCancelledTasksFromExecutor() {
        return Collections.EMPTY_LIST;
    }

    protected List<URL> processPage(URL url) {
        System.out.println(url + " will be processed");
        return getChildUrlByParent(url);
    }

    private List<URL> getChildUrlByParent(URL url) {
        List<URL> result = new ArrayList<>();

        if (codegymUrl.equals(url)) {
            result.add(codegymUrl1Child);
        } else if (codegymFbGroupUrl.equals(url)) {
            result.add(codegymFbGroupUrl1Child);
            result.add(codegymFbGroupUrl2Child);
            result.add(codegymFbGroupUrl3Child);
        }
        return result;
    }

    private void saveUnprocessedUrls(List<Runnable> unprocessed) {
        for (Runnable task : unprocessed) {
            urlsForProcessing.add(((UrlTask) task).getPage());
        }
    }

    private void submitUrlTask(URL url) {
        executorService.execute(new UrlTask(url));
    }

    public class UrlTask implements Runnable {
        private final URL url;

        private UrlTask(URL url) {
            this.url = url;
        }

        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) return;
                submitUrlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}