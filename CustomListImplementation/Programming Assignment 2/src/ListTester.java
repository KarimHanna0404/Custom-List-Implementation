
import java.util.*;
import java.io.*;

public class ListTester {
    public static void main(String[] args) {
        int[] testSizes = {10, 100, 1000, 10000, 100000, 1000000};
        
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("testrun.txt"))) {
            for (int N : testSizes) {
            	writer.println("Testing N = " + N);
            	writer.flush();

                System.out.println("Testing N = " + N);
                
                testInsertion(new MyArrayList<>(), "MyArrayList", N, writer);
                testInsertion(new MyLinkedList<>(), "MyLinkedList", N, writer);
                testInsertion(new ArrayList<>(), "Java ArrayList", N, writer);
                testInsertion(new LinkedList<>(), "Java LinkedList", N, writer);
                
                testRemoval(new MyArrayList<>(), "MyArrayList", N, writer);
                testRemoval(new MyLinkedList<>(), "MyLinkedList", N, writer);
                testRemoval(new ArrayList<>(), "Java ArrayList", N, writer);
                testRemoval(new LinkedList<>(), "Java LinkedList", N, writer);
                
                testRandomValueRemoval(new MyArrayList<>(), "MyArrayList", N, writer);
                testRandomValueRemoval(new MyLinkedList<>(), "MyLinkedList", N, writer);
                testRandomValueRemoval(new ArrayList<>(), "Java ArrayList", N, writer);
                testRandomValueRemoval(new LinkedList<>(), "Java LinkedList", N, writer);
                
                writer.println("--------------------------------------");
                System.out.println("--------------------------------------");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void testInsertion(List<Integer> list, String listType, int N, PrintWriter writer) {
        Random rand = new Random();
        writer.println("\nTesting " + listType + " with N = " + N);

        // Measure insertion at the beginning
        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(0, rand.nextInt(2 * N));
        }
        long duration = System.nanoTime() - startTime;
        writer.println("Insert@start(ms): " + (duration / 1e6));

        // Measure insertion at the end
        list.clear();
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(2 * N));
        }
        duration = System.nanoTime() - startTime;
        writer.println("Insert@end(ms): " + (duration / 1e6));

        // Measure insertion at a random location
        list.clear();
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int randomIndex = list.size() == 0 ? 0 : rand.nextInt(list.size());
            list.add(randomIndex, rand.nextInt(2 * N));
        }
        duration = System.nanoTime() - startTime;
        writer.println("Insert@random(ms): " + (duration / 1e6));
    }
    
    private static void testRemoval(List<Integer> list, String listType, int N, PrintWriter writer) {
        Random rand = new Random();
        
        // Fill list with N elements before removal test
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(2 * N));
        }

        writer.println("\nTesting removal on " + listType + " with N = " + N);

        // Measure removal from the beginning
        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.remove(0);
        }
        long duration = System.nanoTime() - startTime;
        writer.println("Remove@start(ms): " + (duration / 1e6));

        // Refill list for next test
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(2 * N));
        }

        // Measure removal from the end
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.remove(list.size() - 1);
        }
        duration = System.nanoTime() - startTime;
        writer.println("Remove@end(ms): " + (duration / 1e6));

        // Refill list for next test
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(2 * N));
        }

        // Measure removal from a random position
        startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int randomIndex = list.size() == 0 ? 0 : rand.nextInt(list.size());
            list.remove(randomIndex);
        }
        duration = System.nanoTime() - startTime;
        writer.println("Remove@random(ms): " + (duration / 1e6));
    }

    private static void testRandomValueRemoval(List<Integer> list, String listType, int N, PrintWriter writer) {
        Random rand = new Random();
        
        // Fill list with N elements before removal test
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(2 * N));
        }

        writer.println("\nTesting random value removal on " + listType + " with N = " + N);

        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.remove((Integer) rand.nextInt(2 * N)); // Remove by value
        }
        long duration = System.nanoTime() - startTime;
        writer.println("Remove by value(ms): " + (duration / 1e6));
    }
}
