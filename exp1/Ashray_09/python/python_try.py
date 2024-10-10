#Author : Ashray Naik
#Roll No: 09
#Title :Implementing Object Oriented Concept on Higher Education
#Start: 03-july-2024
#Modified date: 24-july-2024
#Description : A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts , where Educational Institutes is parent class and Universities ,Colleges, Standalones and Institutes of National Importance are the child Class and single Institute record becomes an Object of the respective classes 

class HigherEducationalInstitute:
    def display_details(self):
        print("Higher Education Institutions as per AISHE")

class University(HigherEducationalInstitute):
    def __init__(self, aishe_code, name, state, district, web_url, university_type, year_of_establishment, location):
        super().__init__()
        self.aishe_code = aishe_code
        self.name = name
        self.state = state
        self.district = district
        self.web_url = web_url
        self.university_type = university_type
        self.year_of_establishment = year_of_establishment
        self.location = location

    def get_attributes(self):
        print(f"AISHE Code: {self.aishe_code}")
        print(f"Name: {self.name}")
        print(f"State: {self.state}")
        print(f"District: {self.district}")
        print(f"Web URL: {self.web_url}")
        print(f"University Type: {self.university_type}")
        print(f"Year of Establishment: {self.year_of_establishment}")
        print(f"Location: {self.location}")

    def display_details(self):
        super().display_details()
        self.get_attributes()
        print("Number of Universities are: 1284")

class College(HigherEducationalInstitute):
    def display_details(self):
        super().display_details()
        print("Number of Colleges are : 5055")

class Standalone(HigherEducationalInstitute):
    def display_details(self):
        super().display_details()
        print("Number of Standalones are : 13916")

class INI(HigherEducationalInstitute):
    def display_details(self):
        super().display_details()
        print("Number of Institutes of National Importance are : 158")

def main():
    U_0976 = University("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural")
    col = College()
    stand = Standalone()
    ini = INI()

    con = 1
    while con == 1:
        print("Enter your choice:")
        print("1: UNIVERSITIES")
        print("2: STANDALONES")
        print("3: COLLEGES")
        print("4: Institute of National Importance")
        print("5: EXIT\n")

        choice = int(input())

        if choice == 1:
            print("Details Of College Under University (i.e An Object of Class University):")
            U_0976.display_details()
        elif choice == 2:
            print("Standalone Institute Details:")
            stand.display_details()
        elif choice == 3:
            print("College Details:")
            col.display_details()
        elif choice == 4:
            print("Institute of National Importance Details:")
            ini.display_details()
        elif choice == 5:
            con = 0
        else:
            print("Invalid choice")
        print()

if __name__ == "__main__":
    main()
