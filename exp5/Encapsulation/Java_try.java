package Encapsulation;
import java.util.Scanner;

// Author : Ashray Naik
// Roll No: 09
// Title :Implementing Object Oriented Concept on Higher Education
// Description : A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts , where Educational Institutes is parent class and Universities ,Colleges, Standalones and Institutes of National Importance are the child Class and single Institute record becomes an Object of the respective classes 

class HigherEducationalInstitute {
    public void displayDetails() {
        System.out.println("Higher Education Institutions as per AISHE ");
    }
}

class University extends HigherEducationalInstitute {
    // Encapsulation - private fields
    private String aisheCode;
    private String name;
    private String state;
    private String district;
    private String webUrl;
    private String universityType;
    private int yearOfEstablishment;
    private String location;

    // Constructor
    public University(String aisheCode, String name, String state, String district, String webUrl, String universityType, int yearOfEstablishment, String location) {
        this.aisheCode = aisheCode;
        this.name = name;
        this.state = state;
        this.district = district;
        this.webUrl = webUrl;
        this.universityType = universityType;
        this.yearOfEstablishment = yearOfEstablishment;
        this.location = location;
    }

    // Public getter and setter methods for encapsulation
    public String getAisheCode() {
        return aisheCode;
    }

    public void setAisheCode(String aisheCode) {
        this.aisheCode = aisheCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    public int getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(int yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Display details method to showcase encapsulation in action
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("AISHE Code: " + getAisheCode());
        System.out.println("Name: " + getName());
        System.out.println("State: " + getState());
        System.out.println("District: " + getDistrict());
        System.out.println("Web URL: " + getWebUrl());
        System.out.println("University Type: " + getUniversityType());
        System.out.println("Year of Establishment: " + getYearOfEstablishment());
        System.out.println("Location: " + getLocation());
        System.out.println("Number of Universities are: 1284");
    }
}

class College extends HigherEducationalInstitute {
    public College() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Colleges are: 5055");
    }
}

class Standalone extends HigherEducationalInstitute {
    public Standalone() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Standalones are: 13916");
    }
}

class INI extends HigherEducationalInstitute {
    public INI() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Institutes of National Importance are: 158");
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
            System.out.print("Enter your choice: \n 1:UNIVERSITIES \n 2:STANDALONES \n 3:COLLEGES \n 4:Institute of National Importance \n 5:EXIT \n \n ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Details Of College Under University (i.e An Object of Class University):");
                    U_0976.displayDetails();
                    break;
                case 2:
                    System.out.println("Standalone Institute Details:");
                    stand.displayDetails();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("College Details:");
                    col.displayDetails();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Institute of National Importance Details:");
                    ini.displayDetails();
                    System.out.println();
                    break;
                case 5:
                    con = 0;
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
}
