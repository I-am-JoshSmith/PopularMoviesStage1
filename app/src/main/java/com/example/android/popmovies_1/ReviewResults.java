package com.example.android.popmovies_1;

import java.util.List;

/**
 * Created by Grimlock on 7/3/18.
 */

public class ReviewResults {


    /**
     * id : 351286
     * page : 1
     * results : [{"author":"Law","content":"I felt embarrassed to be watching this. It's an embarrassing fever dream. I abandoned it halfway through its runtime.","id":"5b2d4c080e0a264aea001943","url":"https://www.themoviedb.org/review/5b2d4c080e0a264aea001943"}]
     * total_pages : 1
     * total_results : 1
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * author : Law
         * content : I felt embarrassed to be watching this. It's an embarrassing fever dream. I abandoned it halfway through its runtime.
         * id : 5b2d4c080e0a264aea001943
         * url : https://www.themoviedb.org/review/5b2d4c080e0a264aea001943
         */

        private String author;
        private String content;
        private String id;
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
