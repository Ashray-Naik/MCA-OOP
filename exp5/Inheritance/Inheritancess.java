import java.util.Scanner;

// Interface for Hybrid Inheritance
interface InstituteInfo {
    void instituteCategory();
}

// Parent Class: HigherEducationalInstitute
class HigherEducationalInstitute {
    public void displayDetails() {
        System.out.println("Higher Education Institutions as per AISHE ");
    }
}

// Single Inheritance: University inherits from HigherEducationalInstitute and implements InstituteInfo
class University extends HigherEducationalInstitute implements InstituteInfo {
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
        System.out.println("Number of Universities are: 1284");
    }

    @Override
    public void instituteCategory() {
        System.out.println("This is a University.");
    }
}

// Multilevel Inheritance: Department inherits from University
class Department extends University {
    private String departmentName;
    private String hodName;

    public Department(String aisheCode, String name, String state, String district, String webUrl, String universityType, int yearOfEstablishment, String location, String departmentName, String hodName) {
        super(aisheCode, name, state, district, webUrl, universityType, yearOfEstablishment, location);
        this.departmentName = departmentName;
        this.hodName = hodName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head of Department: " + hodName);
    }
}

// Hierarchical Inheritance: College, Standalone, INI also inherit from HigherEducationalInstitute
class College extends HigherEducationalInstitute {
    public College() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Colleges are : 5055");
    }
}

class Standalone extends HigherEducationalInstitute {
    public Standalone() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Standalones are : 13916");
    }
}

class INI extends HigherEducationalInstitute {
    public INI() {
        super();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Institutes of National Importance are : 158");
    }
}

// Main Class to demonstrate
public class Inheritancess {
    public static void main(String[] args) {
        // Creating objects
        University U_0976 = new University("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural");
        Department dept = new Department("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural", "Computer Science", "Dr. Sharma");
        College col = new College();
        Standalone stand = new Standalone();
        INI ini = new INI();

        Scanner scanner = new Scanner(System.in);
        int choice;
        int con = 1;

        while (con == 1) {
            System.out.print("Enter your choice: \n 1:UNIVERSITIES \n 2:DEPARTMENTS \n 3:STANDALONES \n 4:COLLEGES \n 5:Institute of National Importance \n 6:EXIT \n ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Details Of University:");
                    U_0976.displayDetails();
                    break;
                case 2:
                    System.out.println("Details Of Department:");
                    dept.displayDetails();
                    break;
                case 3:
                    System.out.println("Standalone Institute Details:");
                    stand.displayDetails();
                    break;
                case 4:
                    System.out.println("College Details:");
                    col.displayDetails();
                    break;
                case 5:
                    System.out.println("Institute of National Importance Details:");
                    ini.displayDetails();
                    break;
                case 6:
                    con = 0;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
