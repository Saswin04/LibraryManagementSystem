package com.library;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author, boolean isIssued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    public String getId() {
        return id;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + isIssued;
    }

    public static Book fromString(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]));
    }
}
