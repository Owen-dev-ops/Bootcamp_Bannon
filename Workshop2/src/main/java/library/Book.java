package library;

public class Book {
    /* Properties */
    private int id;
    // ISBN = international standard book number. 13 digits long and identifies a specific book version.
    // Example: Harry Potter and the Sorcerer's Stone Hardcover: 059035342X, Paperback: 0439708184
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    /* Constructors */
    public Book(int id, String title, String isbn, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    /* getters/setters */
    public int getId() { return id; }

    public String getIsbn() { return isbn; }

    public String getTitle() { return title; }

    public boolean getIsCheckedOut() { return isCheckedOut; }
    public void setIsCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }

    public String getCheckedOutTo() { return checkedOutTo; }
    public void setCheckedOutTo(String checkedOutTo) { this.checkedOutTo = checkedOutTo; }

    /* Behaviors */
    public void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
    }

    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }
}
