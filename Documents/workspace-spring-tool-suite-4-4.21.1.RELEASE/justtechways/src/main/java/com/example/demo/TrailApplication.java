package com.example.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TrailApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrailApplication.class, args);

        // Run the thread pool example
        runThreadPoolExample();

        // Run the asynchronous I/O example
        runAsynchronousIOExample();
    }

    private static void runThreadPoolExample() {
        // Create a fixed-size thread pool with an appropriate number of threads
        int numberOfThreads = Runtime.getRuntime().availableProcessors(); // Adjust based on system's available processors
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i));
        }

        // Shutdown the thread pool when all tasks are completed
        executor.shutdown();
    }

    private static void runAsynchronousIOExample() {
        try {
            Path file = Paths.get("./example.txt"); // Update the file path here
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long position = 0;

            // Asynchronously read data from the file
            Future<Integer> result = channel.read(buffer, position);

            // Wait for the read operation to complete
            try {
                int bytesRead = result.get();
                System.out.println("Bytes read: " + bytesRead);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Close the file channel
                if (channel.isOpen()) {
                    channel.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            try {
                // Simulate some work being done by the task
                Thread.sleep(1000); // Placeholder for actual task execution
                System.out.println("Task " + taskId + " completed by thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interrupt status
                System.err.println("Task " + taskId + " interrupted: " + e.getMessage());
            }
        }
    }
}