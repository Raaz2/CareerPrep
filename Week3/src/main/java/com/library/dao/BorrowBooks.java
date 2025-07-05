package com.library.dao;

public class BorrowBooks implements Runnable {

    private int userId;
    private int bookId;
    private LibDao libDao;

    public BorrowBooks(LibDao libDao, int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.libDao = libDao;
    }

    @Override
    public void run() {
        synchronized (BorrowBooks.class) {
            try {
                boolean success = libDao.borrowBook(userId, bookId);
                if (success) {
                    System.out.println("User " + userId + " successfully borrowed book " + bookId);
                } else {
                    System.out.println("User " + userId + " failed to borrow book " + bookId + " (Not Available)");
                }
            } catch (Exception e) {
                System.out.println("Error occurred for user " + userId + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
