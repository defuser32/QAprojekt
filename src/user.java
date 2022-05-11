import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class user {

    String surName;
    String lastName;
    int typeOfUser;
    boolean admin;
    int pid;
    Scanner scan = new Scanner(System.in);
    private ArrayList <Member> memberList;

    public user(String surName, String lastName, boolean admin, String pid, int typeOfUser) {


    }

    public void start () {

        System.out.println("1: log in    2: register");
        int choice = scan.nextInt();

        if (choice == 1) {
            login();
        } else if ( choice == 2) {
            register();

        }
    }



    public void register () {
        System.out.println("Enter surname:");
        surName = scan.nextLine();
        System.out.println("Enter last name");
        lastName = scan.nextLine();
        System.out.println("Are you admin? 1 for yes. 2 for no.");
        int choice = scan.nextInt();
        if (choice == 1) {
            admin = true;
        } else if (choice == 2) {
            admin = false;
        }
        System.out.println("Enter PID (10 digits)");
        String pid = scan.nextLine();

        System.out.println("What kind of user are you?");
        System.out.println("1: postgrad 2: undergrad 3: master 4: teacher");
        int typeOfUser = scan.nextInt();

         Member member = new Member(surName, lastName, admin, pid, typeOfUser);



    }

    public void login () {
        System.out.println();

    }

    /**
     * Method checks if a current user is member by checking last 4 of PID
     * @return
     */


}
