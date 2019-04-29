package sdp;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processGrades(scanner));
  }

  private static String processGrades(Scanner scanner) {
    int total_Classes = 0;
    double total_GPA =0;
    double GPA = 0;
    String grade = "";
    while(scanner.hasNextLine()){
      total_Classes += 1;
      scanner.next();
      scanner.next();
      grade = scanner.next();
      if(grade.equals("A"))
      {
        GPA = 4.00;
      }
      if(grade.equals("A-"))
      {
        GPA = 3.67;
      }
      if(grade.equals("B+"))
      {
        GPA = 3.33;
      }
      if(grade.equals("B"))
      {
        GPA = 3.00;
      }
      if(grade.equals("B-"))
      {
        GPA = 2.67;
      }
      if(grade.equals("C+"))
      {
        GPA = 2.33;
      }
      if(grade.equals("C"))
      {
        GPA = 2.00;
      }
      if(grade.equals("C-"))
      {
        GPA = 1.67;
      }
      if(grade.equals("D+"))
      {
        GPA = 1.33;
      }
      if(grade.equals("D"))
      {
        GPA = 1.00;
      }
      if(grade.equals("F"))
      {
        GPA = 0.00;
      }
      total_GPA = (GPA + total_GPA)/total_Classes;
      scanner.nextLine();
    }
    String report = String.format("Courses: " + total_Classes + "\nGPA: %.2f\n", total_GPA);
    return report;
  }

  @Test
  public void emptyGradeListReportsZeroGpaAndNoCourses() {
    assertTotalsOfList_Are("", "Courses: 0\nGPA: 0.00\n");
  }

  @Test
  public void singleCourseGradeReportsItself() {
    assertTotalsOfList_Are("CS 234        A ", "Courses: 1\nGPA: 4.00\n");
    assertTotalsOfList_Are("MAT    234    A-", "Courses: 1\nGPA: 3.67\n");
    assertTotalsOfList_Are("ENGR 121      B+", "Courses: 1\nGPA: 3.33\n");
    assertTotalsOfList_Are("CS 234         B", "Courses: 1\nGPA: 3.00\n");
    assertTotalsOfList_Are("CS 234        B-", "Courses: 1\nGPA: 2.67\n");
    assertTotalsOfList_Are("ENGR 011     C+ ", "Courses: 1\nGPA: 2.33\n");
    assertTotalsOfList_Are("ENGR 101      C ", "Courses: 1\nGPA: 2.00\n");
    assertTotalsOfList_Are("ENGR 101    C-\n", "Courses: 1\nGPA: 1.67\n");
    assertTotalsOfList_Are("ENGR 101      D+", "Courses: 1\nGPA: 1.33\n");
    assertTotalsOfList_Are("CS 122L        D", "Courses: 1\nGPA: 1.00\n");
    assertTotalsOfList_Are("CS 122L        F", "Courses: 1\nGPA: 0.00\n");
  }

  @Test
  public void multipleCoursesAreAllComputed() {
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B",
            "Courses: 2\nGPA: 3.50\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     B-\n",
            "Courses: 3\nGPA: 3.22\n");

  }

  @Test
  public void withdrawnCoursesDontCountTowardsCoursesTaken() {
    assertTotalsOfList_Are("CS 122L      W", "Courses: 0\nGPA: 0.00\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     W\n",
            "Courses: 2\nGPA: 3.50\n");
  }

  private void assertTotalsOfList_Are(String input, String output) {
    assertEquals(output, processGrades(new Scanner(input)));
  }
}
