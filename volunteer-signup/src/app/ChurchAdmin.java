package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ChurchAdmin {

    public static void main(String[] args) throws Exception {
        ArrayList<ChurchForm> churchFormInfo = loadInfo();
        int numberOfVolunteers = churchFormInfo.size();
        System.out.println("Hello.");
        if (numberOfVolunteers > 1) {
            System.out.println(numberOfVolunteers + " people are interested in volunteering for the church.");
        } else if (numberOfVolunteers == 1) {
            System.out.println(numberOfVolunteers + " person is interested in volunteering for the church.");
        }
        for (ChurchForm vol : churchFormInfo) {
            System.out.println("-----------------------");
            System.out.println(vol.firstName + " " + vol.lastName + "'s" + " Contact Information");
            System.out.println("PHONE: " + vol.phone);
            System.out.println("EMAIL: " + vol.email);
            System.out.println("INTERESTS: " + vol.worship + vol.welcome + vol.production + vol.communityGroups
                    + vol.childrensMinistry + vol.studentMinistry);
            System.out.println("-----------------------");
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