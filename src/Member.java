import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;

public class Member extends user{

    String	url     =	"jdbc:mysql://localhost:3306/projekt";
    String	user	=	"root";
    String	pass    =	"root";
    public int uID;
    public String  temp;

     int [] memberUID;


    public Member(String surName, String lastName, boolean admin, long pid, int typeOfUser) {
        super(surName, lastName, admin, pid, typeOfUser);
        String temp = Long.toString(pid);
        temp.substring(temp.length()-4);
        uID = Integer.parseInt(temp);

    }



    public void addMember(Member member) {

        try {
            Connection connect = DriverManager.getConnection(url , user, pass);
            System.out.println("Connected");
            Statement statement = connect.createStatement();

             ResultSet members =  statement.executeQuery("Select uID from members");

            while (members.next()) {
                int x = 1;
                int temp = members.getInt(x);
                 if (temp == member.uID) {
                     System.out.println("User already exists");
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

            ResultSet members =  statement.executeQuery("Insert into members ");

            while (members.next()) {
                int x = 1;
                int temp = members.getInt(x);
                if (temp == member.uID) {
                    System.out.println("User already exists");
                } else {
                    x++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error - " + ex);
        }


    }


}
