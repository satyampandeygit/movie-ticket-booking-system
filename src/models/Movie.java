package models;

import java.util.List;

public class Movie {
    Integer id;
    private String title;
    private String language;
    private List<String> showTimes;

    public Movie(Integer id, String title, String language, List<String> showTimes) {
        this.id = id;
        this.title = title;
        this.language =  language;
        this.showTimes = showTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<String> showTimes) {
        this.showTimes = showTimes;
    }

    @Override
    public String toString() {
        return title + ", " +
                "available in " + language + " languages";
    }
}
