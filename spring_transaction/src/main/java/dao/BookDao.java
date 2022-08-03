package dao;

public interface BookDao {
    int getPriceByBookId(int bookId);

    void upDateStock(int bookId);

    void upDateBalance(int userId ,int price);
}
