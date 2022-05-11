import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;

public class Member extends user{

    String	url     =	"jdbc:mysql://localhost:3306/sys";
    String	user	=	"root";
    String	pass    =	"root";
    public int uID;


    public Member(String surName, String lastName, boolean admin, String pid, int typeOfUser) {
        super(surName, lastName, admin, pid, typeOfUser);
        String temp = pid.toString();
        temp.substring(temp.length()-5);
        uID = Integer.parseInt(temp);

    }



    public void addMember(Member member) {

        try {
            Connection connect = DriverManager.getConnection(url , user, pass);
            System.out.println("Connected");
            Statement statement = connect.createStatement();

            Resultset members = (Resultset) statement.executeQuery("Select uID from artist");

            while (((ResultSet) members).next()) {
              //  if (members.get)

            }


            /**
             * Try catch methods catches error in case of database access or other errors.
             */
        } catch (SQLException ex) {
            System.out.println("Error - " + ex);
        }


    }


}
