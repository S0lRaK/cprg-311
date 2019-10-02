package ca.sait.itsd;
/**
 * Created on May 10, 2011
 *
 * Project: SerializationExercise
 */

import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *	SerializeCompetitors.java
 *
 * @author kitty
 * @author Carlos J. Garcia Carmona
 * @version 1.1
 *
 * Class Description:  
 */
public class SerializeCompetitors {
    // Constants
    private static final int N = 1000;
	private static final String FILE_PATH_SERIALIZED = "res/competitors.ser";
	private static final String FILE_PATH_QUEUED = "res/queue.ser";
	private static final File fileSerialized = new File(FILE_PATH_SERIALIZED);
	private static final File fileQueued = new File(FILE_PATH_QUEUED);

	// Attributes
    private long competitorOutputTime,
            competitorInputTime,
            queueOutputTime,
            queueInputTime;

    public void serializeCompetitorsToFile() {
        long start, stop;
        start = System.currentTimeMillis();
        Competitor competitor = null;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSerialized));

            for (int i = 0; i < N; i++) {
                Location location = new Location("Lindsey Park",
                        "1823 McLeod Trail");
                Event event = new Event("100 meter free style", location);
                competitor = new Competitor("Bob", event, 19);
                oos.writeObject(competitor);
            }
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        competitorOutputTime = stop - start;
    }

    public void deserializeCompetitorsFromFile() {
		long start, stop;
		start = System.currentTimeMillis();

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileSerialized));

			for (int index = 0; index < N; index++) {
				Competitor competitor = (Competitor) objectInputStream.readObject();
				System.out.println(competitor);
			}
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		competitorInputTime = stop - start;
	}

    public void serializeCompetitorQueueToFile() {
        long start, stop;
        start = System.currentTimeMillis();
        Competitor competitor = null;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileQueued));
            ConcurrentLinkedQueue<Competitor> queue = new ConcurrentLinkedQueue<Competitor>();

            for (int i = 0; i < N; i++) {
                Location location = new Location("Lindsey Park","1823 McLeod Trail");
                Event event = new Event("100 meter free style", location);
                competitor = new Competitor("Bob", event, 19);
                queue.add(competitor);
            }
            oos.writeObject(queue);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stop = System.currentTimeMillis();
        queueOutputTime = stop - start;
    }

    public void deserializeCompetitorQueueFromFile() {
		long start, stop;
		start = System.currentTimeMillis();

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileQueued));
			ConcurrentLinkedQueue queue = (ConcurrentLinkedQueue) objectInputStream.readObject();
			objectInputStream.close();

			for (int index = 0; index < N; index++) {
				System.out.println(queue.poll());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		queueInputTime = stop - start;
	}

    public void printTimes() {
        System.out.println("Time to write competitors individually = " +
                competitorOutputTime);
        System.out.println("Time to write competitors with a queue = " +
                queueOutputTime);
        System.out.println("Time to read competitors individually = " +
                competitorInputTime);
        System.out.println("Time to read competitors with a queue = " +
                queueInputTime);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SerializeCompetitors s = new SerializeCompetitors();
        s.serializeCompetitorsToFile();
        s.deserializeCompetitorsFromFile();
        s.serializeCompetitorQueueToFile();
        s.deserializeCompetitorQueueFromFile();
        s.printTimes();
    }
}
