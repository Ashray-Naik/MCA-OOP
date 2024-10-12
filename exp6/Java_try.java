//Author : Ashray Naik
//Roll No: 09
//Title :Implementing Object Oriented Concept on Higher Education
//Start: 03-july-2024
//Modified date: 24-july-2024
//Description : A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts , where Educational Institutes is parent class and Universities ,Colleges, Standalones and Institutes of National Importance are the child Class and single Institute record becomes an Object of the respective classes 
import java.util.Scanner;

/**
 * Represents a general higher educational institute.
 * This is the base class for all types of higher educational institutions.
 */
class HigherEducationalInstitute {
    
    /**
     * Displays a general message about higher education institutions.
     */
    public void displayDetails() {
        System.out.println("Higher Education Institutions as per AISHE:");
    }
}

/**
 * Represents a university, a specific type of higher educational institution.
 */
class University extends HigherEducationalInstitute {
    private String aisheCode;
    private String name;
    private String state;
    private String district;
    private String webUrl;
    private String universityType;
    private int yearOfEstablishment;
    private String location;

    /**
     * Constructor to initialize a University object with the given attributes.
     *
     * @param aisheCode            The AISHE code of the university.
     * @param name                 The name of the university.
     * @param state                The state where the university is located.
     * @param district             The district where the university is located.
     * @param webUrl              The website URL of the university.
     * @param universityType       The type of university (e.g., Central, State).
     * @param yearOfEstablishment  The year the university was established.
     * @param location             The specific location of the university.
     */
    public University(String aisheCode, String name, String state, String district, String webUrl, String universityType, int yearOfEstablishment, String location) {
        super();
        setAttributes(aisheCode, name, state, district, webUrl, universityType, yearOfEstablishment, location);
    }

    /**
     * Sets the attributes for the University.
     *
     * @param aisheCode            The AISHE code of the university.
     * @param name                 The name of the university.
     * @param state                The state where the university is located.
     * @param district             The district where the university is located.
     * @param webUrl              The website URL of the university.
     * @param universityType       The type of university (e.g., Central, State).
     * @param yearOfEstablishment  The year the university was established.
     * @param location             The specific location of the university.
     */
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

    /**
     * Retrieves and displays the attributes of the university.
     */
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

    /**
     * Displays the details of the university, including its attributes.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        getAttributes();
        System.out.println("Number of Universities: 1284");
    }
}

/**
 * Represents a college, a specific type of higher educational institution.
 */
class College extends HigherEducationalInstitute {
    /**
     * Displays the details of colleges.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Colleges: 5055");
    }
}

/**
 * Represents a standalone institute, a specific type of higher educational institution.
 */
class Standalone extends HigherEducationalInstitute {
    /**
     * Displays the details of standalone institutes.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Standalone Institutes: 13916");
    }
}

/**
 * Represents an Institute of National Importance, a specific type of higher educational institution.
 */
class INI extends HigherEducationalInstitute {
    /**
     * Displays the details of institutes of national importance.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Institutes of National Importance: 158");
    }
}

/**
 * The main class to run the program, allowing users to view details about different types of higher educational institutes.
 */
public class Java_try {
    public static void main(String[] args) {
        University U_0976 = new University("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural");
        College col = new College();
        Standalone stand = new Standalone();
        INI ini = new INI();

        Scanner scanner = new Scanner(System.in);
        int choice;
        int con = 1;

        // Main loop to display options and get user input
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
                    con = 0; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

