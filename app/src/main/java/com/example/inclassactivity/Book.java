package com.example.inclassactivity;

public class Book {

    private String bookName;
    private String authorName;
    private int pages;
    private boolean isAvailable;

    public Book(String bookName, String authorName, int pages, boolean isAvailable) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pages = pages;
        this.isAvailable = isAvailable;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
