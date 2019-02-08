package sdp;

class GradeProcessor {
  private double totalGradePoints = 0;
  private int courseCount = 0;
  private double gradePointAverage;

  public void addGrades(Iterable<Grade> grades) {
    for (Grade grade : grades)
      adjustCourseCountAndPointsIfNeeded(grade);

    computeGradePointAverage();
  }

  private void adjustCourseCountAndPointsIfNeeded(Grade grade) {
    if (grade.countsForGPA())
      addToTotalCounts(grade);
  }

  private void addToTotalCounts(Grade grade) {
    totalGradePoints += grade.toPoints();
    courseCount += 1;
  }

  private void computeGradePointAverage() {
    gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

  public String prepareReport() {
    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

}
