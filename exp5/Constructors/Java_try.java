package Constructors;
import java.util.Scanner;

// Enum for University Types
enum UniversityType {
    CENTRAL, STATE, DEEMED, PRIVATE
}

// Higher Educational Institute base class
class HigherEducationalInstitute {

    public HigherEducationalInstitute() {
        System.out.println("Higher Educational Institute Created");
    }

    public void displayDetails() {
        System.out.println("Higher Education Institutions as per AISHE");
    }
}

// University class inheriting HigherEducationalInstitute
class University extends HigherEducationalInstitute {
    private String aisheCode;
    private String name;
    private String state;
    private String district;
    private String webUrl;
    private UniversityType universityType;
    private int yearOfEstablishment;
    private String location;

    // Constructor with all parameters
    public University(String aisheCode, String name, String state, String district, String webUrl,
                      UniversityType universityType, int yearOfEstablishment, String location) {
        super(); // Calling base class constructor
        this.aisheCode = aisheCode;
        this.name = name;
        this.state = state;
        this.district = district;
        this.webUrl = webUrl;
        this.universityType = universityType;
        this.yearOfEstablishment = yearOfEstablishment;
        this.location = location;
    }

    // Method to get attributes
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

// College class inheriting HigherEducationalInstitute
class College extends HigherEducationalInstitute {

    public College() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Colleges: 5055");
    }
}

// Standalone class inheriting HigherEducationalInstitute
class Standalone extends HigherEducationalInstitute {

    public Standalone() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Standalones: 13916");
    }
}

// Institute of National Importance (INI) class inheriting HigherEducationalInstitute
class INI extends HigherEducationalInstitute {

    public INI() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Institutes of National Importance: 158");
    }
}

// Main class for executing the program
public class Java_try {
    public static void main(String[] args) {
        University U_0976 = new University("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh",
                "Ananthapuramu", "https://cuap.ac.in", UniversityType.CENTRAL, 2018, "Rural");

        College col = new College();
        Standalone stand = new Standalone();
        INI ini = new INI();

        Scanner scanner = new Scanner(System.in);
        int choice;
        int con = 1;

        // Menu for user input
        while (con == 1) {
            System.out.print("Enter your choice: \n 1:UNIVERSITIES \n 2:STANDALONES \n 3:COLLEGES \n 4:Institute of National Importance \n 5:EXIT \n \n ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Details Of University:");
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
