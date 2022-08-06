package service;

public interface BookService {

    void buyBook(int userId, int bookId);

    void checkOut(int userId, int[] bookIds);
}
