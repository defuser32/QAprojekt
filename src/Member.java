import java.util.ArrayList;

public class Member extends user{

    ArrayList<Member> memberList = new ArrayList<>();


    public Member(String surName, String lastName, boolean admin, String pid, int typeOfUser) {
        super(surName, lastName, admin, pid, typeOfUser);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void addMember(Member member) {
        memberList.add(member);
    }


}
