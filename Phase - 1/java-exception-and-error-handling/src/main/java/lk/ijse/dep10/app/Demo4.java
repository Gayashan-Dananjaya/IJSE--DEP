package lk.ijse.dep10.app;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        try (MyResource myResource = new MyResource()){
            System.out.println(myResource);
//            myResource.close();
        }
    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Resource is about to free");
    }
}
