package models;

public class Ticket {
    private Integer id;
    private Integer movieId;
    private Integer showtimeId;

    public Ticket(Integer id, Integer movieId, Integer showtimeId) {
        this.id = id;
        this.movieId = movieId;
        this.showtimeId = showtimeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }


}
