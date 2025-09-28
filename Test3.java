import java.util.*;

// Book Class
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

// User Class
class User {
    private int id;
    private String name;
    private List<Book> issuedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public void showIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println(name + " has no issued books.");
        } else {
            System.out.println(name + " has issued:");
            for (Book book : issuedBooks) {
                System.out.println("  - " + book.getTitle());
            }
        }
    }
}


class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) return book;
        }
        return null;
    }

    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) return user;
        }
        return null;
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued!");
        } else {
            book.issue();
            user.issueBook(book);
            System.out.println("Book issued: " + book.getTitle() + " to " + user.getName());
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null || user == null) {
            System.out.println("Invalid Book/User!");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book was not issued.");
        } else {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book returned: " + book.getTitle() + " by " + user.getName());
        }
    }
}

// Main Class
public class Test3 {

    public static void main(String[] args) {
        Library library = new Library();

        // Add Books
        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(2, "Java Programming", "James Gosling"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        // Add Users
        library.addUser(new User(101, "Afzal"));
        library.addUser(new User(102, "Amaaz"));

        // Show All Books
        System.out.println("Available Books:");
        library.showBooks();

        System.out.println("\n--- Transactions ---");
        library.issueBook(2, 101);   // Afzal issues Java Programming
        library.issueBook(3, 102);   // Zohra issues Clean Code
        library.returnBook(2, 101);  // Afzal returns Java Programming

        System.out.println("\nUpdated Book List:");
        library.showBooks();

        System.out.println("\n--- User Records ---");
        library.findUserById(101).showIssuedBooks();
        library.findUserById(102).showIssuedBooks();
    }
}
