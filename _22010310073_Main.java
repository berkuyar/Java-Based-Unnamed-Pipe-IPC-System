package _22010310073_BerkUyar_;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class _22010310073_Main {

    public static void main(String[] args) {
        ArrayList<String> producerNames = new ArrayList<>();
        ArrayList<String> consumerNames = new ArrayList<>();
        ArrayList<String> eventLines = new ArrayList<>();

        try {
            File file = new File("girdi.txt");
            Scanner scanner = new Scanner(file);

            boolean readingProducers = false;
            boolean readingConsumers = false;
            boolean readingEvents = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.equals("prosesler:")) {
                    readingProducers = true;
                    continue;
                }
                if (line.equals("olaylar:")) {
                    readingProducers = false;
                    readingConsumers = false;
                    readingEvents = true;
                    continue;
                }
                if (readingProducers) {
                    if (line.startsWith("producer")) {
                        String[] parts = line.split(" ");
                        for (int i = 2; i < parts.length; i++) {
                            producerNames.add(parts[i]);
                        }
                    } else if (line.startsWith("consumer")) {
                        String[] parts = line.split(" ");
                        for (int i = 2; i < parts.length; i++) {
                            consumerNames.add(parts[i]);
                        }
                    }
                } else if (readingEvents) {
                    eventLines.add(line);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("girdi.txt bulunamadı.");
            return;
        }

        System.out.println("girdi.txt dosyası okundu.");

        _22010310073_Kernel kernel = new _22010310073_Kernel();

        ArrayList<_22010310073_Producer> producers = new ArrayList<>();
        for (String name : producerNames) {
            producers.add(new _22010310073_Producer(name, kernel));
        }

        ArrayList<_22010310073_Consumer> consumers = new ArrayList<>();
        for (String name : consumerNames) {
            consumers.add(new _22010310073_Consumer(name, kernel));
        }

        _22010310073_EventManager eventManager = new _22010310073_EventManager(kernel, producers, consumers, eventLines);
        eventManager.start();
    }
}
