package Abstraction;

//Author : Ashray Naik
//Roll No: 09
//Title : Implementing Object Oriented Concept on Higher Education

//Description: A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts, where Educational Institutes is the parent class and Universities, Colleges, Standalones, and Institutes of National Importance are the child classes. Single Institute record becomes an Object of the respective classes.

import java.util.Scanner;

// Abstract class (implements abstraction)
abstract class HigherEducationalInstitute {
    
    // Abstract method (acts like a virtual method)
    public abstract void displayDetails();
    
    public void basicInfo() {
        System.out.println("Higher Education Institutions as per AISHE");
    }
}

// University class extends HigherEducationalInstitute
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

    // Implementing the abstract method
    @Override
    public void displayDetails() {
        basicInfo(); // Calling a concrete method from abstract class
        getAttributes();
        System.out.println("Number of Universities: 1284");
    }
}

// College class extends HigherEducationalInstitute
class College extends HigherEducationalInstitute {

    public College() {
        super();
    }

    // Implementing the abstract method
    @Override
    public void displayDetails() {
        basicInfo(); // Calling a concrete method from abstract class
        System.out.println("Number of Colleges: 5055");
    }
}

// Standalone class extends HigherEducationalInstitute
class Standalone extends HigherEducationalInstitute {

    public Standalone() {
        super();
    }

    // Implementing the abstract method
    @Override
    public void displayDetails() {
        basicInfo(); // Calling a concrete method from abstract class
        System.out.println("Number of Standalones: 13916");
    }
}

// INI (Institutes of National Importance) class extends HigherEducationalInstitute
class INI extends HigherEducationalInstitute {

    public INI() {
        super();
    }

    // Implementing the abstract method
    @Override
    public void displayDetails() {
        basicInfo(); // Calling a concrete method from abstract class
        System.out.println("Number of Institutes of National Importance: 158");
    }
}

// Main class
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
            System.out.print("Enter your choice: \n 1: UNIVERSITIES \n 2: STANDALONES \n 3: COLLEGES \n 4: Institute of National Importance \n 5: EXIT \n\n ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Details of College Under University (i.e., an Object of Class University):");
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
