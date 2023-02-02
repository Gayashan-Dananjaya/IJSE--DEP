package lk.ijse.dep10.oop.exercise;

public class Exercise5 {


    static{
        System.out.println("Exercise05 template is being initialized - 01");
    }

    static Course[] courses = initializeCourses();

    static{
        System.out.println("Exercise05 template is being initialized - 02");
    }

    private static Course[] initializeCourses(){
        System.out.println("Initializing Courses");
        Course[] courses = new Course[3];
        courses[0] = new Course("DEP", "Direct Entry Program");
        courses[1] = new Course("CMJD", "Comprehensive Master Java Developer", "Kanishka");
        courses[2] = new Course("GDSE", "Graduate Diploma in Software Engineering");
        return courses;
    }

    public static void main(String[] args) {
        for (Course course : courses) {
            System.out.println(course.id + " : " +  course.coordinator);
        }
    }
}

class Course{
    String id;
    String name;
    String coordinator;
    static String[] coordinators = {"Kasun", "Nuwan"};
    static int i;

    static{
        System.out.println("Course template is being initialized");
    }

    public Course(String id, String name) {
        this(id, name, getCoordinator());
        System.out.printf("Course id: %s, name: %s created! \n", id, name);
    }

    public Course(String id, String name, String coordinator){
        this.id = id;
        this.name = name;
        this.coordinator = coordinator;
    }

    private static String getCoordinator(){
        if (i >= coordinators.length) i = 0;
        return coordinators[i++];
    }
}
