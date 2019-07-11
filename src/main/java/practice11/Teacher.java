package practice11;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class Teacher extends Person implements Observer {
    private LinkedList<Klass> classes = new LinkedList<>();

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass klass : this.classes) {
            klass.addObserver(this);
        }
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
                string += klass.getDisplayName() + ",";
            }
            string = string.replace("Class", "");
            string = string.substring(0, string.length() - 1);
            return super.introduce() + " I am a Teacher. I teach " + "Class" + string + ".";
        }
    }

    public String introduceWith(Student student) {

        if (isTeaching(student)) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
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
            if (student.getKlass().equals(klass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        Klass klass = (Klass) o;
        String string = (String) arg;
        if (string.indexOf("leader")>-1){
            string = string.replace("leader","");
            System.out.print("I am "+super.getName()+". I know "+string+" become Leader of Class "+klass.getNumber()+".\n");
        }else {
            System.out.print("I am "+super.getName()+". I know "+arg+" has joined Class "+klass.getNumber()+".\n");
        }
    }
}