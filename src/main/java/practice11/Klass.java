package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;


public class Klass extends Observable {
    private int number;
    private Student leader;
    private List<Student> students = new ArrayList<>(10);

    public Klass(int number) {
        this.number = number;
    }

    public void assignLeader(Student student){
        if (students.indexOf(student)>-1) {
            this.leader = student;
            setChanged();
            notifyObservers("leader"+student.getName());
        }else {
            System.out.print("It is not one of us.\n");
        }
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return "Class "+number;
    }

    public Student getLeader(){
        return leader;
    }

    public void appendMember(Student student) {
        students.add(student);
        setChanged();
        notifyObservers(student.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number &&
                Objects.equals(leader, klass.leader) &&
                Objects.equals(students, klass.students);
    }

}
