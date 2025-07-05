package com.library.dao;

import com.library.model.Book;
import com.library.model.User;

import java.sql.SQLException;
import java.util.List;

public interface LibDao {
    void addBook(Book book) throws SQLException;

    void addUser(User user) throws SQLException;

    boolean borrowBook(int userId, int bookId) throws SQLException;

    void returnBook(int userId, int bookId) throws SQLException;

    List<String> getAllBooksByUser(int userId) throws SQLException;
}
