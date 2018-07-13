package com.example.android.popmovies_1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Grimlock on 6/13/18.
 *  built using Gson Formatter
 *  from - http://api.themoviedb.org/3/movie/popular?api_key=fdde22f0d62c95d575ee71100a498507
 */

public class MovieResults {

    private int page;
    private int total_results;
    private int total_pages;
    private List<ResultsBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Entity(tableName = "favorites")
    public static class ResultsBean {

        /**
         * vote_count : 540
         * id : 351286
         * video : false
         * vote_average : 6.7
         * title : Jurassic World: Fallen Kingdom
         * popularity : 288.186315
         * poster_path : /c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg
         * original_language : en
         * original_title : Jurassic World: Fallen Kingdom
         * genre_ids : [28,12,878]
         * backdrop_path : /t0Kn7twXduHeFhOpTW2Gncu9l5F.jpg
         * adult : false
         * overview : A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.
         * release_date : 2018-06-06
         */

        private int vote_count;
        @PrimaryKey(autoGenerate = false)
        private int id;
        @Ignore
        private boolean video;

        private double vote_average;

        private String title;
        @Ignore
        private double popularity;

        private String poster_path;
        @Ignore
        private String original_language;
        @Ignore
        private String original_title;

        private String backdrop_path;
        @Ignore
        private boolean adult;

        private String overview;

        private String release_date;

        @Ignore
        private List<Integer> genre_ids;

        public ResultsBean(int id, double vote_average, String title, String poster_path, String backdrop_path, String overview, String release_date) {
            this.id = id;
            this.vote_average = vote_average;
            this.title = title;
            this.poster_path = poster_path;
            this.backdrop_path = backdrop_path;
            this.overview = overview;
            this.release_date = release_date;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
