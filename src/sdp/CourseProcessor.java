package sdp;

import java.util.ArrayList;
import java.util.List;

class CourseProcessor {
  final GradeAdder gradeAdder;
  private List<Course> courses = new ArrayList<>();

  public CourseProcessor() {
    this(new GradeAdder());
  }

  public CourseProcessor(GradeAdder adder) {
    gradeAdder = adder;
  }

  void addCourses(Iterable<Course> courses) {
    for (Course course : courses) {
      addCourse(course);
    }
  }

  public void addCourse(Course course) {
    courses.add(course);
    gradeAdder.add(course.getGrade());
  }

  public void addGrades(Iterable<Grade> grades) {
    for (Grade grade : grades)
      addGrade(grade);
  }

  public void addGrade(Grade grade) {
    gradeAdder.add(grade);
  }

  public String reportTotals() {
    return gradeAdder.prepareReport();
  }

  public List<Course> getCourses() {
    return courses;
  }
}