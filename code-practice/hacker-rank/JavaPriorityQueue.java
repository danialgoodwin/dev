import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
    @Override
    public String toString() {
        return "[" + cgpa + ", " + fname + ", " + token + "]";
    }
}

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      PriorityQueue<Student> q = new PriorityQueue<>(10, new Comparator<Student>() {
          @Override
          public int compare(Student a, Student b) {
              if (a.getCgpa() != b.getCgpa()) { return Double.compare(b.getCgpa(), a.getCgpa()); }
              if (!a.getFname().equals(b.getFname())) { return a.getFname().compareTo(b.getFname()); }
              return a.getToken() - b.getToken();
          }
      });
      while (totalEvents > 0) {
         String event = in.next();
          switch (event)  {
              case "ENTER":
                  String name = in.next();
                  double gpa = in.nextDouble();
                  int id = in.nextInt();
                  q.add(new Student(id, name, gpa));
                  break;
              case "SERVED":
                  q.poll();
                  break;
          }
          //System.out.println(q);
         totalEvents--;
      }
        if (q.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!q.isEmpty()) {
                System.out.println(q.poll().getFname());
            }
        }
    }
}
