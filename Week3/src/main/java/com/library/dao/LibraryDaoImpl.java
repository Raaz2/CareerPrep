package com.library.dao;

import com.library.model.Book;
import com.library.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibDao{
    @Override
    public void addBook(Book book) throws SQLException {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDb(); // connection to database

            //prepare the query
            String query = "INSERT INTO books (title, author, available_copies) VALUES (?, ?, ?)";

            // getting the prepare statement object
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getAvailableCopies());

            //executing query
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to add book.");
        } finally {
            try {
                DBUtils.closeConnection(conn);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addUser(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDb(); // connection to database

            //prepare the query
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";

            // getting the prepare statement object
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            //executing query
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to add user.");
        } finally {
            try {
                DBUtils.closeConnection(conn);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean borrowBook(int userId, int bookId) throws SQLException {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDb(); // connection to database

            String sql = "INSERT INTO borrowed_books (user_id, book_id, borrow_date) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ps.setDate(3, Date.valueOf(LocalDate.now()));

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to borrow book.");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void returnBook(int userId, int bookId) throws SQLException {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDb();

            String sql = "UPDATE borrowed_books SET return_date = ? WHERE user_id = ? AND book_id = ? AND return_date IS NULL";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, userId);
            ps.setInt(3, bookId);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Unable to return book with the id: " + bookId + " for the user: " + userId);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<String> getAllBooksByUser(int userId) throws SQLException {
        List<String> books = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDb();

            String sql = "SELECT b.title FROM books b " +
                    "JOIN borrowed_books bb ON b.book_id = bb.book_id " +
                    "WHERE bb.user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                books.add(rs.getString("title"));
            }

            return books;

        }  catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Error while accessing books.");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
