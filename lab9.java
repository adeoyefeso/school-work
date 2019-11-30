class Student_Record implements RecordTemplate {
        protected String first_name;
        protected String last_name;
        protected int day;
        protected int month;
        protected int year;
        private int id;

        //constructor
        public Student_Record(String first_name, String last_name, int day, int month, int year, int id) {

                if (first_name.equals("")) {
                        this.first_name = "Ade";
                } else this.first_name = first_name;

                if (last_name.equals("")) {
                        this.last_name = "Oyefeso";
                } else this.last_name = last_name;

                if (day > 31) {
                        this.day = 01;
                } else this.day = day;

                if (month > 12) {
                        this.month = 01;
                } else this.month = month;

                if(year < 1000){
                        this.year = 2019;
                }else this.year = year;
                this.id = id;

        }

        //get methods
        public String getFirst_name() {
                return this.first_name;
        }

        public String getLast_name() {
                return this.last_name;
        }

        public int getDay() {
                return day;
        }

        public int getMonth() {
                return month;
        }

        public int getYear() {
                return year;
        }

        public int getId() {
                return id;
        }

        //toString - to display the record
        public String toString() {
                return  getLast_name()+ "," + getFirst_name() + "," + getDay() + "/"+getMonth() + "/"+getYear() + "," + "ID:" +getId();
        }
}

******************************************************************************************************************************************


import java.util.Scanner;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class File_control implements RecordTemplate {

    PrintWriter outputStreamName;

    public static void main(String[] args) throws IOException {
        PrintWriter outputStreamName = new PrintWriter(String.valueOf(new FileOutputStream(file_name)), String.valueOf(true));
        //String PATH = file_name;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter how many records you will like to enter: ");
        int input = scan.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.println("Enter your first name: ");
            String first_name = scan.next();

            System.out.println("Enter your last name: ");
            String last_name = scan.next();

            System.out.println("Enter the day you were born: ");
            int day = scan.nextInt();

            System.out.println("Enter the month you were born: ");
            int month = scan.nextInt();

            System.out.println("Enter the year you were born: ");
            int year = scan.nextInt();

            int id = i;
            Student_Record Record = new Student_Record(first_name, last_name, day, month, year, id);
            outputStreamName.write(String.valueOf(Record));


        }

        outputStreamName.close();

        ArrayList<String> rows = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file_name));

        String s;
        while ((s = reader.readLine()) != null)
            rows.add(s);

        Collections.sort(rows);
        System.out.println(rows);
    }
}
//        String newFirst_Name=null;
//        String newLast_Name=null;
//        int new_day;
//        int new_month;
//        int new_year;
//        boolean checked = true;
//
//            File f = new File(file_name);          // path to your file
//            File tempFile = new File("myTempFile.txt"); // create a temp file in same path
//            BufferedWriter writer = new BufferedWriter(new PrintWriter(tempFile));
//            Scanner sc = new Scanner(f);
//
//            Scanner sc1 = new Scanner(file_name);
//
//            Scanner sc2 = new Scanner(System.in);
//            System.out.println("Enter the id of the record you will like to edit: ");
//            int key = sc2.nextInt();
//
//        while(sc1.hasNextLine())
//        {
//            String currentLine = sc1.nextLine();
//            String[] tokens = currentLine.split(delimiter);
//            if(Integer.parseInt(tokens[0]) == key && checked)
//            {
//                sc2.nextLine();
//                System.out.println("Enter the new first name: ");
//                newFirst_Name= sc2.nextLine();
//                System.out.println("Enter the new last name: ");
//                newLast_Name= sc2.nextLine();
//                System.out.println("Enter the new day: ");
//                new_day= sc2.nextInt();
//                System.out.println("Enter the new month: ");
//                new_month= sc2.nextInt();
//                System.out.println("Enter the new year: ");
//                new_year= sc2.nextInt();
//
//                currentLine = tokens[0]+" "+newFirst_Name+" "+newLast_Name+" "+new_day+" "+new_month+ " "+new_year;
//                checked = false;
//            }
//            writer.write(currentLine + System.getProperty("line.separator"));
//
//        }
//        writer.close();
//        sc.close();
//        f.delete();
//        boolean successful = tempFile.renameTo(f);
//
//
//    }
//
//}

******************************************************************************************************************************************

public interface RecordTemplate {
    public static final int NUMBER_OF_FIELDS = 3;
//    public static final String field_labels = {first_name, last_name, dob};
//    public static final String field_types = {string, string, date};
    public static final String file_name = "file.txt";
    public static final String delimiter = ",";
    public static final int primary_key_field_index = 1; //last name
}

