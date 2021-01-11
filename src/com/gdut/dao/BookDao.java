package com.gdut.dao;

import com.gdut.book.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {
    public static String TABLE = "book";
    public static String ALL_FIELD = "isbn, bookname, price, author, publish";
    //用于存Book
    static ArrayList<Book> list = new ArrayList<>();

    /**
     * Using to query book information
     *
     * @return {@code ArrayList} of book
     */
    public static ArrayList<Book> queryBook() {
        String sql = "select " + TABLE
                + " from " + ALL_FIELD;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    try (ResultSet result = ps.executeQuery()) {
                        while (result.next()) {
                            //从数据库获取书籍信息
                            int isbn = result.getInt("isbn");
                            int price = result.getInt("price");
                            String publish = result.getString("publish");
                            String author = result.getString("author");
                            String bookname = result.getString("bookname");
                            //存入到Book类里面
                            Book book = new Book();
                            book.setIsbn(isbn);
                            book.setPrice(price);
                            book.setAuthor(author);
                            book.setBookname(bookname);
                            book.setPublish(publish);
                            list.add(book);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //将list返回，方便jsp界面调用
        return list;
    }

    /**
     * Using to delete book information
     *
     * @param bookName The book's name
     */
    public static void deleteBook(String bookName) {
        String sql = "delete "
                + " from " + TABLE
                + " where bookname=? ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, bookName);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Using to update book information
     */
    public static void updateBook(int isbn, int price, String author, String publish, String bookname) {
        String sql = "insert into "
                + TABLE
                + " values(?,?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD)) {
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    //设置数据库的五个参数
                    ps.setInt(1, isbn);
                    ps.setString(2, bookname);
                    ps.setInt(3, price);
                    ps.setString(4, author);
                    ps.setString(5, publish);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
