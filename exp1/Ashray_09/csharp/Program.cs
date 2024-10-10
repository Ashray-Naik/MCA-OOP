//Author : Ashray Naik
//Roll No: 09
//Title :Implementing Object Oriented Concept on Higher Education
//Start: 03-july-2024
//Modified date: 24-july-2024
//Description : A Program to Show how Higher Educational Structure is organised using Object Oriented Concepts , where Educational Institutes is parent class and Universities ,Colleges, Standalones and Institutes of National Importance are the child Class and single Institute record becomes an Object of the respective classes 


using System;

namespace HigherEducationStructure
{
    class HigherEducationalInstitute
    {
        public virtual void DisplayDetails()
        {
            Console.WriteLine("Higher Education Institutions as per AISHE");
        }
    }

    class University : HigherEducationalInstitute
    {
        private string aisheCode;
        private string name;
        private string state;
        private string district;
        private string webUrl;
        private string universityType;
        private int yearOfEstablishment;
        private string location;

        public University(string aisheCode, string name, string state, string district, string webUrl, string universityType, int yearOfEstablishment, string location)
        {
            SetAttributes(aisheCode, name, state, district, webUrl, universityType, yearOfEstablishment, location);
        }

        public void SetAttributes(string aisheCode, string name, string state, string district, string webUrl, string universityType, int yearOfEstablishment, string location)
        {
            this.aisheCode = aisheCode;
            this.name = name;
            this.state = state;
            this.district = district;
            this.webUrl = webUrl;
            this.universityType = universityType;
            this.yearOfEstablishment = yearOfEstablishment;
            this.location = location;
        }

        public void GetAttributes()
        {
            Console.WriteLine("AISHE Code: " + aisheCode);
            Console.WriteLine("Name: " + name);
            Console.WriteLine("State: " + state);
            Console.WriteLine("District: " + district);
            Console.WriteLine("Web URL: " + webUrl);
            Console.WriteLine("University Type: " + universityType);
            Console.WriteLine("Year of Establishment: " + yearOfEstablishment);
            Console.WriteLine("Location: " + location);
        }

        public override void DisplayDetails()
        {
            base.DisplayDetails();
            GetAttributes();
            Console.WriteLine("Number of Universities are: 1284");
        }
    }

    class College : HigherEducationalInstitute
    {
        public College() : base()
        {
        }

        public override void DisplayDetails()
        {
            base.DisplayDetails();
            Console.WriteLine("Number of Colleges are: 5055");
        }
    }

    class Standalone : HigherEducationalInstitute
    {
        public Standalone() : base()
        {
        }

        public override void DisplayDetails()
        {
            base.DisplayDetails();
            Console.WriteLine("Number of Standalones are: 13916");
        }
    }

    class INI : HigherEducationalInstitute
    {
        public INI() : base()
        {
        }

        public override void DisplayDetails()
        {
            base.DisplayDetails();
            Console.WriteLine("Number of Institutes of National Importance are: 158");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            University U_0976 = new University("U-0976", "CENTRAL UNIVERSITY OF ANDHRA PRADESH", "Andhra Pradesh", "Ananthapuramu", "https://cuap.ac.in", "Central University", 2018, "Rural");
            College col = new College();
            Standalone stand = new Standalone();
            INI ini = new INI();

            int choice;
            int con = 1;

            while (con == 1)
            {
                Console.WriteLine("Enter your choice: \n 1:UNIVERSITIES \n 2:STANDALONES \n 3:COLLEGES \n 4:Institute of National Importance \n 5:EXIT \n");
                choice = Convert.ToInt32(Console.ReadLine());

                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Details Of College Under University (i.e An Object of Class University):");
                        U_0976.DisplayDetails();
                        break;
                    case 2:
                        Console.WriteLine("Standalone Institute Details:");
                        stand.DisplayDetails();
                        Console.WriteLine();
                        break;
                    case 3:
                        Console.WriteLine("College Details:");
                        col.DisplayDetails();
                        Console.WriteLine();
                        break;
                    case 4:
                        Console.WriteLine("Institute of National Importance Details:");
                        ini.DisplayDetails();
                        Console.WriteLine();
                        break;
                    case 5:
                        con = 0;
                        break;
                    default:
                        Console.WriteLine("Invalid choice\n");
                        break;
                }
            }
        }
    }
}
