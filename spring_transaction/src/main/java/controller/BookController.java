package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.BookService;

@Controller
public class BookController {

    @Autowired
    private  BookService bookService;


    public void buyBook(int userId,int bookId){
        bookService.buyBook(userId,bookId);
    }


    public void CheckOut(int userId, int[] bookIds){
        bookService.checkOut(userId,bookIds);
    }
}
