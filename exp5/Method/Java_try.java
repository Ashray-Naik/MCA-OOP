package Method;

// Author: Ashray Naik
// Roll No: 09
// Title: Implementing Object-Oriented Concept on Higher Education

// Description: A Program to Show how Higher Educational Structure is organised using Object-Oriented Concepts. Higher Educational Institutes is the parent class, and Universities, Colleges, Standalones, and Institutes of National Importance are child classes.

import java.util.Scanner;

class HigherEducationalInstitute {

    // Method Overloading for compile-time polymorphism
    public void displayDetails() {
        System.out.println("Higher Education Institutions as per AISHE ");
    }

    public void displayDetails(String message) { // Overloaded method
        System.out.println("Higher Education Institutions: " + message);
    }
    
    public void displayDetails(int count) { // Another overloaded method
        System.out.println("Total Number of Higher Educational Institutes: " + count);
    }
}

// Child class: University
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

    // Overriding for runtime polymorphism
    @Override
    public void displayDetails() {
        super.displayDetails("University Details");
        getAttributes();
        System.out.println("Number of Universities are: 1284");
    }
}

// Child class: College
class College extends HigherEducationalInstitute {

    public College() {
        super();
    }

    // Overriding for runtime polymorphism
    @Override
    public void displayDetails() {
        super.displayDetails("College Details");
        System.out.println("Number of Colleges are: 5055");
    }
}

// Child class: Standalone
class Standalone extends HigherEducationalInstitute {

    public Standalone() {
        super();
    }

    // Overriding for runtime polymorphism
    @Override
    public void displayDetails() {
        super.displayDetails("Standalone Institute Details");
        System.out.println("Number of Standalones are: 13916");
    }
}

// Child class: INI (Institute of National Importance)
class INI extends HigherEducationalInstitute {

    public INI() {
        super();
    }

    // Overriding for runtime polymorphism
    @Override
    public void displayDetails() {
        super.displayDetails("Institutes of National Importance");
        System.out.println("Number of Institutes of National Importance are: 158");
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
            System.out.print("Enter your choice: \n 1:UNIVERSITIES \n 2:STANDALONES \n 3:COLLEGES \n 4:Institute of National Importance \n 5:EXIT \n \n ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Details Of College Under University (i.e., an object of class University):");
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
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();

        // Demonstrate compile-time polymorphism with method overloading
        HigherEducationalInstitute institute = new HigherEducationalInstitute();
        institute.displayDetails(); // Base method
        institute.displayDetails("Various Institutes Under AISHE"); // Overloaded method
        institute.displayDetails(20000); // Overloaded method
    }
}
