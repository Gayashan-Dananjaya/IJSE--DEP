package lk.ijse.dep10.oop;

import java.util.ArrayList;

public class CompositionDemo {
    public static void main(String[] args) {
        Institute ijse = new Institute();
        Program program1 = ijse.programList.get(0);
        System.out.println(program1.name);

        ijse = null;

        Program program = ijse.programList.get(0);
        System.out.println(program.name);
    }
}

class Institute{
    ArrayList<Program> programList = new ArrayList<>();

    public Institute() {
        programList.add(new Program("DEP", "5 Months"));
        programList.add(new Program("CMJD", "6 Months"));
        programList.add(new Program("GDSE", "2 years"));
    }
}

class Program {
    String name;
    String duration;

    public Program(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
