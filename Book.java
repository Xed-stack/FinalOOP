package OOP;

class Book {
    //book class properties
    private String bookTitle;
    private String bookAuthor;

    //Book class constructor
    Book(){
        bookTitle = "";
    }

    //Book class Overloaded constructor with parameters
    Book(String bookTitle, String bookAuthor){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    //booktitle Getter method
    public String getBookTitle(){
        return bookTitle;
    }

    //bookAuthor Getter method
    public String getBookAuthor(){
        return bookAuthor;
    }

    String displayBookInfo(){
        System.out.println("Book: " + bookTitle);
        if(!bookAuthor.isEmpty()){
            System.out.print("by: " + getBookAuthor() + "\n");
        }else{
        return "Author: unknown";
        }
        return "";
    }

}


//children class of the Book class
class FictionBook extends Book{
    FictionBook(String bookTitle, String bookAuthor){
        super(bookTitle, bookAuthor);
    }

    //overridden displayBookInfo method
    @Override
    String displayBookInfo(){
        return "Genre: Fiction " + super.displayBookInfo();
    }

}

class NonFictionBook extends Book{
    NonFictionBook(String bookTitle, String bookAuthor){
        super(bookTitle, bookAuthor);
    }

    @Override
    String displayBookInfo(){
        return "Genre: Non-Fiction " + super.displayBookInfo();
    }

}