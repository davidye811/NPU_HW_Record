/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import java.util.*;
import business.*;
import java.io.*;

/**
 *
 * @author asus-ad
 */
public class ScheduleData implements ScheduleReader,ScheduleWriter,ScheduleConstants {
    
     public static ArrayList<Schedule> getSchedule() {
        ArrayList<Schedule> students = new ArrayList<>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("Schedule.csv"));
            String line = in.readLine();
            while (line != null) {

                String[] columns = line.split(",");
                String date = columns[0];
                String time = columns[1];
                String description = columns[2];

                Schedule s = new Schedule(date, time, description);
                students.add(s);
                line = in.readLine();

            }

            in.close();

        } catch (IOException loe) {

        }
        return students;
    }
      public static boolean saveSchedule(ArrayList<Schedule> sc) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("Schedule.csv")));
            for (Schedule s : sc) {
                out.print(s.getDate() + ",");
                out.print(s.getTime() + ",");
               
                out.println(s.getDescription());

            }
            out.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;

        }
        return true;
    }
       public static void main(String[] args) {

        ArrayList<Schedule> sc = new ArrayList<>();
        sc.add(new Schedule("Aug-8","12:00","appointment"));
        sc.add(new Schedule("OCT-9","15:00","reading"));
        sc.add(new Schedule("Jan-1","i2:00","sports"));
        sc.add(new Schedule("Sep_2","i4:00","sleep"));
        
        
        saveSchedule(sc);

    }
}
