package model;

import java.util.Date;

public class movie {
    public final String title;
    public final String link;
    public final String image_url;
    public final Date pubdate;
    public final String director;
    public final String actor;
    public final int rating;

    public movie(String title, String link, String image_url, Date pubdate, String director, String actor, int rating) {
        this.title = title;
        this.link = link;
        this.image_url = image_url;
        this.pubdate = pubdate;
        this.director = director;
        this.actor = actor;
        this.rating = rating;
    }
}
