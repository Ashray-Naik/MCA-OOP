//Author : Ashray Naik
//Roll No: 09
//Title :Implementing Object Oriented Concept on Higher Education
//Start: 03-july-2024
//Modified date: 24-july-2024
//Description : A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts , where Educational Institutes is parent class and Universities ,Colleges, Standalones and Institutes of National Importance are the child Class and single Institute record becomes an Object of the respective classes 
import java.util.Scanner;

class HigherEducationalInstitute {
    
    public void displayDetails() {
        System.out.println("Higher Education Institutions as per AISHE:");
    }
}

class University extends HigherEducationalInstitute {
    private String aisheCode;
    private String name;
    private String state;
    private String district;
    private String webUrl;
    private String universityType;
    private int yearOfEstablishment;
    private String location;

    public University(String aisheCode, String name, String state, String district, String webUrl, String universityType, int yearOfEstablishment, String location) {
        super();
        setAttributes(aisheCode, name, state, district, webUrl, universityType, yearOfEstablishment, location);
    }

    public void setAttributes(String aisheCode, String name, String state, String district, String webUrl, String universityType, int yearOfEstablishment, String location) {
        this.aisheCode = aisheCode;
        this.name = name;
        this.state = state;
        this.district = district;
        this.webUrl = webUrl;
        this.universityType = universityType;
        this.yearOfEstablishment = yearOfEstablishment;
        this.location = location;
    }

    public void getAttributes() {
        System.out.println("AISHE Code: " + aisheCode);
        System.out.println("Name: " + name);
        System.out.println("State: " + state);
        System.out.println("District: " + district);
        System.out.println("Web URL: " + webUrl);
        System.out.println("University Type: " + universityType);
        System.out.println("Year of Establishment: " + yearOfEstablishment);
        System.out.println("Location: " + location);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        getAttributes();
        System.out.println("Number of Universities: 1284");
    }
}

class College extends HigherEducationalInstitute {
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Colleges: 5055");
    }
}

class Standalone extends HigherEducationalInstitute {
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Standalone Institutes: 13916");
    }
}

class INI extends HigherEducationalInstitute {
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Institutes of National Importance: 158");
    }
}

public class Java_try {
    public static void main(String[] args) {
        University U_0976 = new University("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural");
        College col = new College();
        Standalone stand = new Standalone();
        INI ini = new INI();

        Scanner scanner = new Scanner(System.in);
        int choice;
        int con = 1;

        while (con == 1) {
            System.out.print("Enter your choice:\n 1: UNIVERSITIES \n 2: STANDALONES \n 3: COLLEGES \n 4: Institute of National Importance \n 5: EXIT \n\n ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Details of University (Object of Class University):");
                    U_0976.displayDetails();
                    break;
                case 2:
                    System.out.println("Standalone Institute Details:");
                    stand.displayDetails();
                    break;
                case 3:
                    System.out.println("College Details:");
                    col.displayDetails();
                    break;
                case 4:
                    System.out.println("Institute of National Importance Details:");
                    ini.displayDetails();
                    break;
                case 5:
                    con = 0;
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
        scanner.close();
    }
}
