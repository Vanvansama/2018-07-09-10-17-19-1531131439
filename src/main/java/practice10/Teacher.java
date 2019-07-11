package practice10;

import java.util.LinkedList;
import java.util.Objects;

public class Teacher extends Person {
    private LinkedList<Klass> classes = new LinkedList<>();

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        if (classes.size() == 0) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            String string = "";
            for (Klass klass : classes) {
                string += klass.getDisplayName()+",";
            }

            string = string.replace("Class","");
            string = string.substring(0,string.length()-1);
            return super.introduce() + " I am a Teacher. I teach " + "Class"+string + ".";
        }
    }

    public String introduceWith(Student student){

        if (isTeaching(student)){
            return super.introduce() + " I am a Teacher. I teach "+student.getName()+".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach "+student.getName()+".";
        }

    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(classes, teacher.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classes);
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (student.getKlass().equals(klass)){
                return true;
            }
        }
        return false;
    }
}