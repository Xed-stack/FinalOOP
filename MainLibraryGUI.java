package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainLibraryGUI {
    JFrame AdminFrame, UserFrame;
    JButton Jumpscare, AddBookBTN, DisplaLibraryBTN, LoanBookBTN, DisplayBorrowedBTN, SearchBTN, RemoveBTN, ReturnBooks;
    JLabel label1, label2 ,Imagelabel1, banner1, banner2, JumpscareLabel;
    JPanel panel1, panel2, bannerPanel, scarePanel;
    JTextField textField1, textField2;
    ImageIcon image,bannerIcon,  jumpscareIcon;
    Image Frameicon1, Frameicon2;
    Patron patron;
    Library library;


        MainLibraryGUI(String username){

        //creating a library object, then adding some books
        library = new Library();
        library.addBook(new FictionBook("Freiren", "Kanehito"));
        library.addBook(new NonFictionBook("Art of war", "Sun Tzu"));
        library.addBook(new FictionBook("That Time I got reincarnated as a Slime", "Fuse"));

        if(username.equals("admin")){

        AdminFrame = new JFrame("Library (****ADMIN VIEW****)");
        AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminFrame.setSize(800, 800);
        AdminFrame.setLayout(null);
        Frameicon1 = Toolkit.getDefaultToolkit().getImage("C:/Users/Xedrik/Downloads/PSULOGO.png");
        AdminFrame.setIconImage(Frameicon1);


        bannerIcon = new ImageIcon("C:/Users/Xedrik/Downloads/PSU-LABEL-LOGO.png");
            banner1 = new JLabel(bannerIcon);
            banner1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            banner1.setBounds(0, 0, 800, 200);

        panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setBounds(0, 0, 800, 800);

        label1 = new JLabel("Good day " + username + ", what do you want to do?");
            label1.setBounds(280,200, 600, 30);

        AddBookBTN = new JButton("Add Book");
            AddBookBTN.setBounds(150, 450, 200, 50);

        SearchBTN = new JButton("Search Book");
            SearchBTN.setBounds(150, 300, 200, 50);

        RemoveBTN = new JButton("Remove book");
            RemoveBTN.setBounds(450, 450, 200, 50);

        DisplaLibraryBTN = new JButton("Display Library");
            DisplaLibraryBTN.setBounds(450, 300, 200, 50);

        //Action Listeners
        AddBookBTN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String bookname = JOptionPane.showInputDialog(AdminFrame, "Enter book name");
                String bookauthor = JOptionPane.showInputDialog(AdminFrame, "Enter the Author");
                String genre = JOptionPane.showInputDialog(AdminFrame, "Enter book genre (Fiction or Non-Fiction)");
                if(genre.equalsIgnoreCase("fiction")){
                    library.addBook(new FictionBook(bookname, bookauthor));
                    JOptionPane.showMessageDialog(AdminFrame, "Added " + bookname + " by " + bookauthor + " to the library");
                }else if(genre.equalsIgnoreCase("non-fiction")){
                    library.addBook(new NonFictionBook(bookname, bookauthor));
                    JOptionPane.showMessageDialog(AdminFrame, "Added " + bookname + " by " + bookauthor + " to the library");
                }
            }
        });

        RemoveBTN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String bookName = JOptionPane.showInputDialog(AdminFrame,"Enter the name of the book you want to remove");
                library.removeBook(bookName);
                JOptionPane.showMessageDialog(AdminFrame, bookName + " is Removed from the Library");

            }
        });

        DisplaLibraryBTN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                library.displayLibrary();
            }
        });

            SearchBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){

                    String bookName = JOptionPane.showInputDialog(AdminFrame, "Enter the title of the book");
                    if(bookName != null && !bookName.isEmpty()){
                        library.searchBook(bookName);
                    }
                }
            });

        //add the components to the Panel, then adding the panel to the JFrame

        panel1.add(label1);
        panel1.add(RemoveBTN);
        panel1.add(DisplaLibraryBTN);
        panel1.add(AddBookBTN);
        panel1.add(SearchBTN);
        AdminFrame.add(banner1);
        AdminFrame.add(panel1);
        AdminFrame.setVisible(true);
        }

//******************************** goes here if the username is NOT THE ADMIN ******************************************
        else {
            //gawa ng new patron objt
            patron = new Patron(username);

            UserFrame = new JFrame("Library");
            UserFrame.setSize(800,800);
            UserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            UserFrame.setLayout(null);
            Frameicon2 = Toolkit.getDefaultToolkit().getImage("C:/Users/Xedrik/Downloads/Book.png");
            UserFrame.setIconImage(Frameicon2);

            panel2 = new JPanel();
                panel2.setLayout(null);
                panel2.setBounds(0, 0, 800, 800);

            label2 = new JLabel("Good day " + username + ", what do you want to do?");
                label2.setBounds(280, 200, 500, 30);

            LoanBookBTN = new JButton("Loan Book");
                LoanBookBTN.setBounds(50,300,200,50);

            DisplayBorrowedBTN = new JButton("Display Borrowed Books");
                DisplayBorrowedBTN.setBounds(550, 300, 200, 50);

            SearchBTN = new JButton("Search Book");
                SearchBTN.setBounds(200, 450, 150, 50);

            DisplaLibraryBTN = new JButton("Display Library");
                DisplaLibraryBTN.setBounds(400, 450, 150, 50);

            ReturnBooks = new JButton("Return Books");
                ReturnBooks.setBounds(300, 300, 200, 50);

            Jumpscare = new JButton("JumpScare");
                Jumpscare.setBounds(300, 700, 200, 30);

            //psu logo
            bannerIcon = new ImageIcon("C:/Users/Xedrik/Downloads/PSU-LABEL-LOGO.png");
            banner2 = new JLabel(bannerIcon);
            banner2.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            banner2.setBounds(0, 0, 800, 200);


            //Action Listeners
            LoanBookBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String bookTitle = JOptionPane.showInputDialog(UserFrame, "Enter the title of the book you want to loan");
                    if(bookTitle != null && !bookTitle.isEmpty()){
                        patron.loanBook(bookTitle, library);
                        JOptionPane.showMessageDialog(UserFrame, "Kindly check the Terminal for the result");
                    }
                }
            });

            DisplayBorrowedBTN.addActionListener((new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    patron.displayBorrowedBooks();
                    JOptionPane.showMessageDialog(UserFrame, "Check the Terminal for the list of Borrowed Books");
                }
            }));

            SearchBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String bookName = JOptionPane.showInputDialog(UserFrame, "Enter the title of the book");
                    if(bookName != null && !bookName.isEmpty()){
                        library.searchBook(bookName);
                        JOptionPane.showMessageDialog(UserFrame, "Check the Terminal for the Book you searched");
                    }
                }
            });

            DisplaLibraryBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    library.displayLibrary();
                    JOptionPane.showMessageDialog(UserFrame, "Check the Terminal for the List of Books in the Library");
                }
            });

            ReturnBooks.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String booktitle = JOptionPane.showInputDialog(UserFrame, "Enter the Book title that you want to return");
                    patron.returnBook(booktitle, library);
                }
            });

            Jumpscare.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame scare = new JFrame("BOO!");
                    jumpscareIcon = new ImageIcon("C:/Users/Xedrik/Downloads/jumpscare.jpg");
                    JumpscareLabel = new JLabel(jumpscareIcon);
                    JumpscareLabel.setBounds(0,0, 800, 800);

                    scarePanel = new JPanel();
                    scarePanel.setBounds(0,0,800,800);
                    scarePanel.add(JumpscareLabel);

                    scare.setLayout(null);
                    scare.setSize(800,800);
                    scare.add(scarePanel);
                    scare.setVisible(true);
                }
            });

            //add components to panel
            panel2.add(Jumpscare);
            panel2.add(ReturnBooks);
            panel2.add(DisplaLibraryBTN);
            panel2.add(label2);
            panel2.add(SearchBTN);
            panel2.add(LoanBookBTN);
            panel2.add(DisplayBorrowedBTN);

            //add the banner and panel to the frame
            UserFrame.add(banner2);
            UserFrame.add(panel2);
            UserFrame.setVisible(true);

        }
    }
}