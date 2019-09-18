/**
 * Created on May 11, 2011
 *
 * Project: DataOutputStreamExercise
 */
package dataOutputStreamExample;

import java.io.*;

/**
 * DataExample.java
 *
 * @author kitty
 * @author Carlos J. Garcia Carmona
 * @version 2.0
 * <p>
 * Class Definition:
 */
public class DataExample {
    // Constants
    private static final int N = 10000;
    private static final String FILE_PATH_UNBUFFERED = "res/random_unbuffered.bin";
    private static final String FILE_PATH_BUFFERED = "res/random_buffered.bin";

    // Attributes
    private long unBufferedWriteTime,
            unBufferedReadTime,
            bufferedWriteTime,
            bufferedReadTime;

    public void generateRandomNumberFileUnBuffered() {
        long start, stop;
        start = System.currentTimeMillis();

        try {
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream(FILE_PATH_UNBUFFERED));

            for (int i = 0; i < N; i++) {
                int number = (int) (Math.random() * 255);
                out.writeInt(number);
                System.out.println(i + " = " + number);
            }

            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        unBufferedWriteTime = stop - start;
    }

    public void readIntegerFileInUnBuffered() {
        long start, stop;
        int index = 0;
        start = System.currentTimeMillis();
        File file = new File(FILE_PATH_UNBUFFERED);

        try {
            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream(file));

            while (dataInputStream.available() > 0) {
                int number = dataInputStream.readInt();
                System.out.println(index + " = " + number);
                index++;
            }
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        unBufferedReadTime = stop - start;
    }

    public void generateRandomNumberFileBuffered() {
        long start, stop;
        start = System.currentTimeMillis();

        try {
            DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(FILE_PATH_BUFFERED)));

            for (int i = 0; i < N; i++) {
                int number = (int) (Math.random() * 255);
                out.writeInt(number);
                System.out.println(i + " = " + number);
            }

            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        bufferedWriteTime = stop - start;
    }

    public void readIntegerFileInBuffered() {
        long start, stop;
        int index = 0;
        start = System.currentTimeMillis();
        File file = new File(FILE_PATH_BUFFERED);

        try {
            DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));

            while (dataInputStream.available() > 0) {
                int number = dataInputStream.readInt();
                System.out.println(index + " = " + number);
                index++;
            }
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        bufferedReadTime = stop - start;
    }

    public void printRunTimes() {
        System.out.println("Total time for unbuffered output = " +
                unBufferedWriteTime);
        System.out.println("Total time for buffered output = " +
                bufferedWriteTime);
        System.out.println("Total time for unbuffered input = " +
                unBufferedReadTime);
        System.out.println("Total time for buffered input = " +
                bufferedReadTime);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        DataExample d = new DataExample();

        d.generateRandomNumberFileUnBuffered();
        d.readIntegerFileInUnBuffered();
        d.generateRandomNumberFileBuffered();
        d.readIntegerFileInBuffered();
        d.printRunTimes();
    }

}
