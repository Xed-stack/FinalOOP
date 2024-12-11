package OOP;
public interface Loanable {
    void loanBook(String booktitle, Library library);
    void returnBook(String booktitle, Library library);
}