package demo;

/**
 * Created by IntelliJ IDEA.
 * Author: Guo Shu Song
 * Date: 2019-04-28
 * Time: 18:48
 */
public class Book {
    private int id;
    private  String name;
    private double price;
    private int bookCount;
    private String author;

    public int getId() {

        return id;
    }

    public int getBookCount() {
        return bookCount;
    }

    public double getPrice() {

        return price;
    }

    public String getName() {

        return name;
    }

    public String getAuthor() {

        return author;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setBookCount(int bookCount) {

        this.bookCount = bookCount;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPrice(double price) {

        this.price = price;

    }
}

