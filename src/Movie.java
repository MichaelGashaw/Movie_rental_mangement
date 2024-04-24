class Movie extends Media {
    private String genre;

    public Movie(String title, String genre, int year) {
        super(title, year);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}