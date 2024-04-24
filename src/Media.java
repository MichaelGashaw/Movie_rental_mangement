class Media {
    protected String title;
    protected int year;
    protected boolean available;

    public Media(String title, int year) {
        this.title = title;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentMedia() {
        available = false;
    }

    public void returnMedia() {
        available = true;
    }
}

