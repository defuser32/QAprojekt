import java.sql.*;

public class book {

    String	url     =	"jdbc:mysql://localhost:3306/projekt";
    String	user	=	"root";
    String	pass    =	"root";

    private int numberOfBooks = 1;
    public int isbn;
    public String title;
    public String genre;
    public int releaseYear;
    public int id;





    public book(int id, int isbn, String title, int releaseYear, String genre) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;

    }


    public void addItem (book book) {


        try {
            Connection connect = DriverManager.getConnection(url , user, pass);
            System.out.println("Connected");
            Statement statement = connect.createStatement();

            ResultSet books =  statement.executeQuery("Select isbn from item");

            while (books.next()) {
                int x = 1;
                int temp = books.getInt(x);
                if (temp == book.isbn) {
                    System.out.println("Adding extra copy of book");
                    book.numberOfBooks++;
                    try {



                        String query = "update item set numberOfItems = ? where isbn =" + book.isbn;
                        PreparedStatement preparedStmt = connect.prepareStatement(query);
                        preparedStmt.setInt   (1, book.numberOfBooks );
                        preparedStmt.execute();


                    } catch (SQLException ex) {
                        System.out.println("Error - " + ex);
                    }

                } else {
                    x++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error - " + ex);
        }
        try {
            Connection connect = DriverManager.getConnection(url , user, pass);
            System.out.println("Connected");
            Statement statement = connect.createStatement();

            String sql = " insert into item (ISBN, name, genre, releaseYear)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt = connect.prepareStatement(sql);
            preparedStmt.setInt (1, book.getIsbn());
            preparedStmt.setString (2, book.getTitle());
            preparedStmt.setString (3, book.getGenre());
            preparedStmt.setInt (4, book.getReleaseYear());

            preparedStmt.execute();


        } catch (SQLException ex) {
            System.out.println("Error - " + ex);
        }

    }


    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getId() {
        return id;
    }
}
