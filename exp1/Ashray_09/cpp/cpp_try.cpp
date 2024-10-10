//Author : Ashray Naik
//Roll No: 09
//Title :Implementing Object Oriented Concept on Higher Education
//Start: 03-july-2024
//Modified date: 24-july-2024
//Description : A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts , where Educational Institutes is parent class and Universities ,Colleges, Standalones and Institutes of National Importance are the child Class and single Institute record becomes an Object of the respective classes 

#include <iostream>
#include <string>

using namespace std;


class HigherEducationalInstitute {
public:
    virtual void displayDetails() {
        cout << "Higher Education Institutions as per AISHE" << endl;
    }
};


class University : public HigherEducationalInstitute {
private:
    string aisheCode;
    string name;
    string state;
    string district;
    string webUrl;
    string universityType;
    int yearOfEstablishment;
    string location;

public:
    University(string aisheCode, string name, string state, string district, 
               string webUrl, string universityType, int yearOfEstablishment, 
               string location) {
        setAttributes(aisheCode, name, state, district, webUrl, universityType, 
                       yearOfEstablishment, location);
    }

    void setAttributes(string aisheCode, string name, string state, 
                       string district, string webUrl, string universityType, 
                       int yearOfEstablishment, string location) {
        this->aisheCode = aisheCode;
        this->name = name;
        this->state = state;
        this->district = district;
        this->webUrl = webUrl;
        this->universityType = universityType;
        this->yearOfEstablishment = yearOfEstablishment;
        this->location = location;
    }

    void getAttributes() {
        cout << "AISHE Code: " << aisheCode << endl;
        cout << "Name: " << name << endl;
        cout << "State: " << state << endl;
        cout << "District: " << district << endl;
        cout << "Web URL: " << webUrl << endl;
        cout << "University Type: " << universityType << endl;
        cout << "Year of Establishment: " << yearOfEstablishment << endl;
        cout << "Location: " << location << endl;
    }

    void displayDetails() override {
        HigherEducationalInstitute::displayDetails();
        getAttributes();
        cout << "Number of Universities are: 1284" << endl;
    }
};

class College : public HigherEducationalInstitute {
public:
    College() {
       
    }

    void displayDetails() override {
        HigherEducationalInstitute::displayDetails();
        cout << "Number of Colleges are: 5055" << endl;
    }
};


class Standalone : public HigherEducationalInstitute {
public:
    Standalone() {
        
    }

    void displayDetails() override {
        HigherEducationalInstitute::displayDetails();
        cout << "Number of Standalones are: 13916" << endl;
    }
};

class INI : public HigherEducationalInstitute {
public:
    INI() {
       
    }

    void displayDetails() override {
        HigherEducationalInstitute::displayDetails();
        cout << "Number of Institutes of National Importance are: 158" << endl;
    }
};

int main() {
    University U_0976("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural");
    College col;
    Standalone stand;
    INI ini;

    int choice;
    int con = 1;

    while (con == 1) {
        cout << "Enter your choice:" << endl;
        cout << "1: UNIVERSITIES" << endl;
        cout << "2: STANDALONES" << endl;
        cout << "3: COLLEGES" << endl;
        cout << "4: Institute of National Importance" << endl;
        cout << "5: EXIT" << endl << endl;

        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Details Of College Under University (i.e An Object of Class University):" << endl;
                U_0976.displayDetails();
                cout << endl;
                break;
            case 2:
                cout << "Standalone Institute Details:" << endl;
                stand.displayDetails();
                cout << endl;
                break;
            case 3:
                cout << "College Details:" << endl;
                col.displayDetails();
                cout << endl;
                break;
            case 4:
                cout << "Institute of National Importance Details:" << endl;
                ini.displayDetails();
                cout << endl;
                break;
            case 5:
                con = 0;
                break;
            default:
                cout << "Invalid choice" << endl;
                break;
        }
    }

    return 0;
}
