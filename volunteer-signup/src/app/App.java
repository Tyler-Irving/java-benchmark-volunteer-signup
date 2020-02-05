package app;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<ChurchForm> churchFormInfo = loadInfo();
        churchFormInfo.add(getInfo());
        saveInfo(churchFormInfo);
    }

    public static ChurchForm getInfo() {
        System.out.println("First Name: ");
        String firstName = in.nextLine();
        System.out.println("Last Name: ");
        String lastName = in.nextLine();
        System.out.println("Phone number: ");
        String phone = in.nextLine();
        System.out.println("Email:");
        String email = in.nextLine();
        System.out.println("Are you interested in volunteering on the Worship team? [Y | N]");
        String worship = in.nextLine();
        System.out.println("Are you interested in volunteering on the Welcome team? [Y | N]");
        String welcome = in.nextLine();
        System.out.println("Are you interested in volunteering on the Production team? [Y | N]");
        String production = in.nextLine();
        System.out.println("Are you interested in leading a Community Group? [Y | N]");
        String communityGroups = in.nextLine();
        System.out.println("Are you interested in teaching in Children's Ministry? [Y | N]");
        String childrensMinistry = in.nextLine();
        System.out.println("Are you interested in volunteering in Student Ministry? [Y | N]");
        String studentMinistry = in.nextLine();
        System.out.println("Are you interested in hearing more information about volunteer opportunities? [Y | N]");
        String interest = in.nextLine();
        return new ChurchForm(firstName, lastName, phone, email, worship, welcome, production, communityGroups,
                childrensMinistry, studentMinistry, interest);
    }

    private static void saveInfo(ArrayList<ChurchForm> churchFormInfo) {
        try {
            FileOutputStream fileStream = new FileOutputStream("church-form-info.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(churchFormInfo);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save.");
        }
    }

    public static ArrayList<ChurchForm> loadInfo() {
        try {
            FileInputStream fileStream = new FileInputStream("church-form-info.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<ChurchForm> churchFormInfo = (ArrayList<ChurchForm>) os.readObject();
            os.close();
            return churchFormInfo;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<ChurchForm>();
        }
    }
}