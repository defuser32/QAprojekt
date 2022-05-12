import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class user {

    String surName;
    String lastName;
    String typeOfUser;
    String admin;
    String pid;
    Scanner scan = new Scanner(System.in);




    public user() {


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


    public String getSurName() {
        return surName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAdmin() {
        return admin;
    }

    public String getPid() {
        return pid;
    }

    public void register () {
        System.out.print("Enter surname: ");
        surName = scan.next();
        System.out.print("Enter last name: ");
        lastName = scan.next();
        System.out.print("Are you admin? 1 for yes. 2 for no: ");
        int choice = Integer.parseInt(scan.next());
        if (choice == 1) {
            admin = "Y";
        } else if (choice == 2) {
            admin = "N";
        }
        System.out.print("Enter PID (10 digits): ");
        pid = scan.next();

        System.out.println("What kind of user are you?");
        System.out.print("1: postgrad  2: undergrad  3: master  4: teacher: ");
        typeOfUser = scan.next();

        Member member = new Member(this.getSurName(), this.getLastName(), this.getAdmin(), this.getPid(), this.getTypeOfUser());
        member.addMember(member);



    }

    public void login () {
        System.out.println();

    }

    /**
     * Method checks if a current user is member by checking last 4 of PID
     * @return
     */


}
