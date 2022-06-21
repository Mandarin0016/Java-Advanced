package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        for (Student currentStudent : this.students) {
            if (currentStudent.getFirstName().equals(student.getFirstName()) && currentStudent.getLastName().equals(student.getLastName())) {
                return "Student is already in the university";
            }
        }

        if (this.students.size() >= this.capacity) {
            return "No seats in the university";
        }

        this.students.add(student);
        return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
    }

    public String dismissStudent(Student student){
        for (Student currentStudent : this.students) {
            if (currentStudent.getFirstName().equals(student.getFirstName()) && currentStudent.getLastName().equals(student.getLastName())) {
                this.students.remove(currentStudent);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }

        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName){
        Student studentToBeReturned = null;
        for (Student currentStudent : this.students) {
            if (currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                studentToBeReturned = currentStudent;
            }
        }
        return studentToBeReturned;
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        for (int studentIndex = 0; studentIndex < this.students.size(); studentIndex++) {
            String studentToBeAdded = String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    this.students.get(studentIndex).getFirstName(),
                    this.students.get(studentIndex).getLastName(),
                    this.students.get(studentIndex).getBestSubject());
            result.append(studentToBeAdded);
            if (studentIndex == this.students.size() - 1){
                break;
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
