import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Member extends user{

    String	url     =	"jdbc:mysql://localhost:3306/projekt";
    String	user	=	"root";
    String	pass    =	"root";
    public String uID;
    public String suspended;
    public int borrowedBooks;


    public Member(String surName, String lastName, String admin, String pid, String typeOfUser) {
        this.surName = surName;
        this.lastName = lastName;
        this.admin = admin;
        this.pid = pid;
        this.typeOfUser = typeOfUser;
        uID  = pid.substring(pid.length() - 4); //sista fyra i PID
    }


    /**
     * The methods takes a member object and uses data to crate a user in the MEMBERS table in the database.
     * If the users unique uID which is last 4 of PID already exists this stops and inform user.
     * @param member
     */

    public void addMember(Member member) {

        try {
            Connection connect = DriverManager.getConnection(url , user, pass);
            System.out.println("Connected");
            Statement statement = connect.createStatement();

             ResultSet members =  statement.executeQuery("Select uID from members");

            while (members.next()) {
                int x = 1;
                String temp = members.getString(x);
                 if (temp.equals( member.uID)) {
                     System.out.println("User already exists");
                     break;
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

            /**
             *  *GREJ ATT GÖRA*
             *  här bör det också läggas in borrowed books och suspended, behövs metoder för att checka detta som
             *  vi sen kallar på för att få fram rätt data som ska skrivas till databasen.
             */

            String sql = " insert into members (fname, lnamn, PID, uID, isAdmin, typeOfUser)"
                    + " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = connect.prepareStatement(sql);
            preparedStmt.setString (1, member.getSurName());
            preparedStmt.setString (2, member.getLastName());
            preparedStmt.setString  (3, member.getPid());
            preparedStmt.setString(4, member.uID);
            preparedStmt.setString    (5, member.getAdmin());
            preparedStmt.setString    (6, member.getTypeOfUser());
            preparedStmt.execute();


        } catch (SQLException ex) {
            System.out.println("Error - " + ex);
        }






    }


}
