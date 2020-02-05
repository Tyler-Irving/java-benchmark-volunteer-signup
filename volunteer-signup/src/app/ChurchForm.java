package app;

import java.io.Serializable;

public class ChurchForm implements Serializable {
    private static final long serialVersionUID = 1L;
    String firstName;
    String lastName;
    String phone;
    String email;
    String worship;
    String welcome;
    String production;
    String communityGroups;
    String childrensMinistry;
    String studentMinistry;
    String interest;

    public ChurchForm(String firstName, String lastName, String phone, String email, String worship, String welcome,
            String production, String communityGroups, String childrensMinistry, String studentMinistry,
            String interest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.worship = worship;
        this.welcome = welcome;
        this.production = production;
        this.communityGroups = communityGroups;
        this.childrensMinistry = childrensMinistry;
        this.studentMinistry = studentMinistry;
        this.interest = interest;
    }
}