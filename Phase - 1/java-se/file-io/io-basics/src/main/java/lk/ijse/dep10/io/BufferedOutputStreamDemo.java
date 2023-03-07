package lk.ijse.dep10.io;

import java.io.*;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            viaVanilla(i + 1);
            viaBuffers(i + 1);
        }
    }

    private static void viaVanilla(int attempt) throws IOException {
        File file = new File("buffered-file1.dep10");
        FileWriter fos = new FileWriter(file);

        long t1 = System.nanoTime();
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.write("I want to write this text with buffered stream");
        fos.close();
        long t2 = System.nanoTime();
        System.out.println(String.format("V: Attempt: %d: %d", attempt, (t2 - t1)));
    }
    private static void viaBuffers(int attempt) throws IOException {
        File file = new File("buffered-file1.dep10");
        FileWriter fos = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fos);

        long t1 = System.nanoTime();
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.write("I want to write this text with buffered stream");
        bw.close();
        long t2 = System.nanoTime();
        System.out.println(String.format("B: Attempt: %d: %d", attempt, (t2 - t1)));
    }
}
