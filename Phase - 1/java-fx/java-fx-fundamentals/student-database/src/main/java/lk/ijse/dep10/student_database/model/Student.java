package lk.ijse.dep10.student_database.model;

import javafx.collections.ObservableIntegerArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Student {
    public String id;
    public String name;
    public ObservableList<String> contact;
    public ObservableList<String> modules;

    public Student(String id, String name, ObservableList<String> contact, ObservableList<String> modules) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.modules = modules;
    }

    @Override
    public String toString() {
        String str = String.format("%-10s%s", id, name);
        return str;
    }
}
