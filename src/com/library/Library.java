package com.library;

import java.io.*;
import java.util.*;

public class Library {
    private List<Book> books;
    private final String filePath = "books.txt";

    public Library() {
        books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void issueBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && !book.isIssued()) {
                book.setIssued(true);
                saveBooks();
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && book.isIssued()) {
                book.setIssued(false);
                saveBooks();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("File not found. Starting fresh.");
        }
    }

    private void saveBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }
}

