package com.example.android.popmovies_1;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Grimlock on 6/13/18.
 */

public class MovieResults {


    /**
     * page : 1
     * total_results : 20021
     * total_pages : 1002
     * results : [{"vote_count":540,"id":351286,"video":false,"vote_average":6.7,"title":"Jurassic World: Fallen Kingdom","popularity":288.186315,"poster_path":"/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg","original_language":"en","original_title":"Jurassic World: Fallen Kingdom","genre_ids":[28,12,878],"backdrop_path":"/t0Kn7twXduHeFhOpTW2Gncu9l5F.jpg","adult":false,"overview":"A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.","release_date":"2018-06-06"},{"vote_count":2200,"id":383498,"video":false,"vote_average":7.7,"title":"Deadpool 2","popularity":210.336791,"poster_path":"/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg","original_language":"en","original_title":"Deadpool 2","genre_ids":[28,35,878],"backdrop_path":"/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg","adult":false,"overview":"Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.","release_date":"2018-05-15"},{"vote_count":4798,"id":299536,"video":false,"vote_average":8.4,"title":"Avengers: Infinity War","popularity":156.43585,"poster_path":"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg","original_language":"en","original_title":"Avengers: Infinity War","genre_ids":[12,878,14,28],"backdrop_path":"/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg","adult":false,"overview":"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.","release_date":"2018-04-25"},{"vote_count":6657,"id":284053,"video":false,"vote_average":7.4,"title":"Thor: Ragnarok","popularity":153.44956,"poster_path":"/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg","original_language":"en","original_title":"Thor: Ragnarok","genre_ids":[28,12,14,878,35],"backdrop_path":"/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg","adult":false,"overview":"Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.","release_date":"2017-10-25"},{"vote_count":11073,"id":135397,"video":false,"vote_average":6.5,"title":"Jurassic World","popularity":117.764484,"poster_path":"/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg","original_language":"en","original_title":"Jurassic World","genre_ids":[28,12,878,53],"backdrop_path":"/t5KONotASgVKq4N19RyhIthWOPG.jpg","adult":false,"overview":"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.","release_date":"2015-06-06"},{"vote_count":6060,"id":284054,"video":false,"vote_average":7.3,"title":"Black Panther","popularity":110.32465,"poster_path":"/uxzzxijgPIY7slzFvMotPv8wjKA.jpg","original_language":"en","original_title":"Black Panther","genre_ids":[28,12,14,878],"backdrop_path":"/6ELJEzQJ3Y45HczvreC3dg0GV5R.jpg","adult":false,"overview":"King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war.","release_date":"2018-02-13"},{"vote_count":9056,"id":297762,"video":false,"vote_average":7.2,"title":"Wonder Woman","popularity":105.892849,"poster_path":"/imekS7f1OuHyUP2LAiTEM0zBzUz.jpg","original_language":"en","original_title":"Wonder Woman","genre_ids":[28,12,14,10752,878],"backdrop_path":"/6iUNJZymJBMXXriQyFZfLAKnjO6.jpg","adult":false,"overview":"An Amazon princess comes to the world of Man in the grips of the First World War to confront the forces of evil and bring an end to human conflict.","release_date":"2017-05-30"},{"vote_count":917,"id":348350,"video":false,"vote_average":6.8,"title":"Solo: A Star Wars Story","popularity":105.039049,"poster_path":"/4oD6VEccFkorEBTEDXtpLAaz0Rl.jpg","original_language":"en","original_title":"Solo: A Star Wars Story","genre_ids":[28,12,878],"backdrop_path":"/7LZ0K4FsALrt7OeNIGOVLNuKQRU.jpg","adult":false,"overview":"Through a series of daring escapades deep within a dark and dangerous criminal underworld, Han Solo meets his mighty future copilot Chewbacca and encounters the notorious gambler Lando Calrissian.","release_date":"2018-05-23"},{"vote_count":24,"id":525102,"video":false,"vote_average":3.7,"title":"Girl Lost","popularity":101.597695,"poster_path":"/n3PDMPyFG04bcXUHHhRIwWd9cx1.jpg","original_language":"en","original_title":"Girl Lost","genre_ids":[18],"backdrop_path":"/j3FnUedjz0NHYFfZ62u9WsBU0wy.jpg","adult":false,"overview":"Girl Lost tackles the issue of underage prostitution as told through the eyes of a wayward teen. Groomed by her own mother to work in the underbelly of Los Angeles, the young girl struggles to survive in this dark world.","release_date":"2018-05-01"},{"vote_count":1602,"id":338970,"video":false,"vote_average":6.2,"title":"Tomb Raider","popularity":99.712507,"poster_path":"/ePyN2nX9t8SOl70eRW47Q29zUFO.jpg","original_language":"en","original_title":"Tomb Raider","genre_ids":[28,12,14,18,9648,53],"backdrop_path":"/bLJTjfbZ1c5zSNiAvGYs1Uc82ir.jpg","adult":false,"overview":"Lara Croft, the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she finds herself on the island where her father disappeared.","release_date":"2018-03-08"},{"vote_count":124,"id":402900,"video":false,"vote_average":6.9,"title":"Ocean's 8","popularity":93.938358,"poster_path":"/MvYpKlpFukTivnlBhizGbkAe3v.jpg","original_language":"en","original_title":"Ocean's 8","genre_ids":[80,35,28,53],"backdrop_path":"/gX5Bi3agqtMlhsoLn7Uv44fEdmi.jpg","adult":false,"overview":"Debbie Ocean, a criminal mastermind, gathers a crew of seven other female thieves to pull off the heist of the century at New York's annual Met Gala.","release_date":"2018-06-07"},{"vote_count":2031,"id":337167,"video":false,"vote_average":6,"title":"Fifty Shades Freed","popularity":84.577383,"poster_path":"/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg","original_language":"en","original_title":"Fifty Shades Freed","genre_ids":[18,10749],"backdrop_path":"/jjuDhXlAY7yHc50t8gEZWvlkoEn.jpg","adult":false,"overview":"Believing they have left behind shadowy figures from their past, newlyweds Christian and Ana fully embrace an inextricable connection and shared life of luxury. But just as she steps into her role as Mrs. Grey and he relaxes into an unfamiliar stability, new threats could jeopardize their happy ending before it even begins.","release_date":"2018-01-17"},{"vote_count":13409,"id":118340,"video":false,"vote_average":7.9,"title":"Guardians of the Galaxy","popularity":82.648407,"poster_path":"/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg","original_language":"en","original_title":"Guardians of the Galaxy","genre_ids":[28,878,12],"backdrop_path":"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg","adult":false,"overview":"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.","release_date":"2014-07-30"},{"vote_count":641,"id":449176,"video":false,"vote_average":8.3,"title":"Love, Simon","popularity":80.332296,"poster_path":"/5YUYg5q7QfC4IoNwNUtiwdiYKPr.jpg","original_language":"en","original_title":"Love, Simon","genre_ids":[35,18,10749],"backdrop_path":"/rqMEeajyzSF4PpJtdCB816Iz8Vr.jpg","adult":false,"overview":"Everyone deserves a great love story. But for seventeen-year old Simon Spier it's a little more complicated: he's yet to tell his family or friends he's gay and he doesn't know the identity of the anonymous classmate he's fallen for online.","release_date":"2018-03-16"},{"vote_count":832,"id":268896,"video":false,"vote_average":5.9,"title":"Pacific Rim: Uprising","popularity":78.410678,"poster_path":"/v5HlmJK9bdeHxN2QhaFP1ivjX3U.jpg","original_language":"en","original_title":"Pacific Rim: Uprising","genre_ids":[28,14,878,12],"backdrop_path":"/6pT73ACl5N1VekdK3wQI8PLfz1E.jpg","adult":false,"overview":"It has been ten years since The Battle of the Breach and the oceans are still, but restless. Vindicated by the victory at the Breach, the Jaeger program has evolved into the most powerful global defense force in human history. The PPDC now calls upon the best and brightest to rise up and become the next generation of heroes when the Kaiju threat returns.","release_date":"2018-03-21"},{"vote_count":0,"id":482560,"video":false,"vote_average":0,"title":"Covet: The Island of Desire","popularity":77.981905,"poster_path":"/jPxatX1ReNULfOOZEDuc5o6T9nT.jpg","original_language":"ko","original_title":"탐하다:욕망의 섬","genre_ids":[10749,18],"backdrop_path":null,"adult":false,"overview":"People who are on fishing boats in a secluded countryside wake up to their deepest desires.  Money, sex, power ... In the uninhabited desert where there is endless desire, it turns out that somebody is found as a body and another person is on the island.  Can they escape safely from the island of desire?","release_date":"2017-01-01"},{"vote_count":7119,"id":76338,"video":false,"vote_average":6.7,"title":"Thor: The Dark World","popularity":65.89958,"poster_path":"/bnX5PqAdQZRXSw3aX3DutDcdso5.jpg","original_language":"en","original_title":"Thor: The Dark World","genre_ids":[28,12,14],"backdrop_path":"/3FweBee0xZoY77uO1bhUOlQorNH.jpg","adult":false,"overview":"Thor fights to restore order across the cosmos\u2026 but an ancient race led by the vengeful Malekith returns to plunge the universe back into darkness. Faced with an enemy that even Odin and Asgard cannot withstand, Thor must embark on his most perilous and personal journey yet, one that will reunite him with Jane Foster and force him to sacrifice everything to save us all.","release_date":"2013-10-29"},{"vote_count":9272,"id":10195,"video":false,"vote_average":6.7,"title":"Thor","popularity":64.176502,"poster_path":"/bIuOWTtyFPjsFDevqvF3QrD1aun.jpg","original_language":"en","original_title":"Thor","genre_ids":[12,14,28],"backdrop_path":"/LvmmDZxkTDqp0DX7mUo621ahdX.jpg","adult":false,"overview":"Against his father Odin's will, The Mighty Thor - a powerful but arrogant warrior god - recklessly reignites an ancient war. Thor is cast down to Earth and forced to live among humans as punishment. Once here, Thor learns what it takes to be a true hero when the most dangerous villain of his world sends the darkest forces of Asgard to invade Earth.","release_date":"2011-04-21"},{"vote_count":3815,"id":281338,"video":false,"vote_average":6.9,"title":"War for the Planet of the Apes","popularity":58.331131,"poster_path":"/3vYhLLxrTtZLysXtIWktmd57Snv.jpg","original_language":"en","original_title":"War for the Planet of the Apes","genre_ids":[18,878,10752],"backdrop_path":"/ulMscezy9YX0bhknvJbZoUgQxO5.jpg","adult":false,"overview":"Caesar and his apes are forced into a deadly conflict with an army of humans led by a ruthless Colonel. After the apes suffer unimaginable losses, Caesar wrestles with his darker instincts and begins his own mythic quest to avenge his kind. As the journey finally brings them face to face, Caesar and the Colonel are pitted against each other in an epic battle that will determine the fate of both their species and the future of the planet.","release_date":"2017-07-11"},{"vote_count":9288,"id":263115,"video":false,"vote_average":7.7,"title":"Logan","popularity":57.572958,"poster_path":"/gGBu0hKw9BGddG8RkRAMX7B6NDB.jpg","original_language":"en","original_title":"Logan","genre_ids":[28,18,878],"backdrop_path":"/5pAGnkFYSsFJ99ZxDIYnhQbQFXs.jpg","adult":false,"overview":"In the near future, a weary Logan cares for an ailing Professor X in a hideout on the Mexican border. But Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.","release_date":"2017-02-28"}]
     */

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
        private int id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;

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
