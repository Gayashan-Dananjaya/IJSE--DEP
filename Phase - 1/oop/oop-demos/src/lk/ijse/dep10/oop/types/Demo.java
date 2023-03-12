package lk.ijse.dep10.oop.types;

public class Demo {

    int x = 20; // Property, Field, State, Attribute

    public static void main(String[] args) {
        TopLevelCLass instance1 = new TopLevelCLass();
        AnotherTopLevelClass instance2 = new AnotherTopLevelClass();
        new TopLevelCLass.StaticNestedClass();

        new TopLevelCLass().new RegularInnerClass();
        instance1.new RegularInnerClass();

        int x = 10; // Local Variable
        class LocalInnerClass {

        }

        new LocalInnerClass();
    }
}

class TopLevelCLass {
    class RegularInnerClass {
        int x = 10;

        {
            int x = 10;
            class LocalInnerClass {

            }
        }
        class RegularInnerClass2 {

        }

    }

    static class StaticNestedClass {
    }

}

class AnotherTopLevelClass {

}
