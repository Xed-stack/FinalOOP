package OOP;
import java.util.ArrayList;

class Library  {
    protected ArrayList<Book> booklist;

    Library(){
        this.booklist = new ArrayList<Book>();
    }

    String addBook(Book book){
        booklist.add(book);
        return "Book " + book.getBookTitle() + " added to the library.";
    }

    void removeBook(String booktitle){
        boolean found = false;
        if(booklist.isEmpty()){
            System.out.println("Library is empty.");
        }

        for(int i = 0; i < booklist.size(); i++){
            if(booklist.get(i).getBookTitle().equalsIgnoreCase(booktitle)){
                System.out.println( booktitle +" is Removed from: " + booklist.get(i).displayBookInfo() + "\n");
                booklist.remove(i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println();
            System.out.println("Cannot remove " + booktitle + " from the library." + "It does not exist.");
            System.out.println();
        }

    }

    void searchBook( String bookname){
        boolean found = false;
        for(int i = 0; i < booklist.size(); i++){
            if(booklist.get(i).getBookTitle().toLowerCase().contains(bookname.toLowerCase())){
                    System.out.println("Found in : " + booklist.get(i).displayBookInfo());
                    found = true;
                    break;
            }
        }

        if(!found){
            System.out.println("No book/author found with the keywords " + bookname+ ".");
        }
    }

    void displayLibrary(){
        if(booklist.isEmpty()){
            System.out.println("Library is empty.");
            return ;
        }

        System.out.println();
        System.out.println("Books in the Library: ");
        for(int i = 0; i < booklist.size(); i++){
            System.out.println(booklist.get(i).displayBookInfo()+ "\n");
        }
    }

    Book loanedBooks(String title){
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getBookTitle().toLowerCase().contains(title.toLowerCase())) {
                return booklist.remove(i); // Remove and return the book
            }
        }
        return null;
    }

    void returnedBook(Book book){
        if(book != null){
            booklist.add(book);
            System.out.println("Book " + book.getBookTitle() + " has been returned to the library.");
        }
    }

}