package practice08;

public class Klass {
    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public void assignLeader(Student student){
        this.leader = student;
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
}
