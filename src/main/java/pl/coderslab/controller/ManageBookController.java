package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.pojo.Book;
import pl.coderslab.services.BookService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping("add")
    public String addBookView(Model model){
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("add")
    public String addBook(Book book){
        bookService.add(book);
        return "redirect:/admin/books/all";
    }
    @GetMapping("show/{id}")
    public String showBook(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "books/show";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("edit/{id}")
    public String editBookView(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "books/edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(Book book){
        bookService.update(book);
        return "redirect:/admin/books/all";

    }






}
