package practice07;

public class Teacher extends Person{
    private Klass klass;
    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce(){
        if (klass==null){
            return super.introduce() + " I am a Teacher. I teach No Class.";
        }else {
            return super.introduce() + " I am a Teacher. I teach "+klass.getDisplayName()+".";
        }
    }

    public String introduceWith(Student student){
        if (student.getKlass().equals(this.klass)){
            return super.introduce() + " I am a Teacher. I teach "+student.getName()+".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach "+student.getName()+".";
        }

    }


    public Klass getKlass() {
        return klass;
    }
}
