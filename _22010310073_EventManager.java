package _22010310073_BerkUyar_;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _22010310073_EventManager {
    private _22010310073_Kernel kernel;
    private Map<String, _22010310073_Producer> producerMap;
    private Map<String, _22010310073_Consumer> consumerMap;
    private ArrayList<String> eventLines;

    public _22010310073_EventManager(_22010310073_Kernel kernel, ArrayList<_22010310073_Producer> producers, ArrayList<_22010310073_Consumer> consumers, ArrayList<String> eventLines) {
        this.kernel = kernel;
        this.eventLines = eventLines;
        producerMap = new HashMap<>();
        consumerMap = new HashMap<>();
        

        for (_22010310073_Producer producer : producers) {
            producerMap.put(producer.getName(), producer);
        }
        for (_22010310073_Consumer consumer : consumers) {
            consumerMap.put(consumer.getName(), consumer);
        }
    }

    public void start() {
        int currentSecond = 0;
        int eventIndex = 0;

        while (eventIndex < eventLines.size()) {
            System.out.println(currentSecond + ". Saniye:");

            String event = eventLines.get(eventIndex);
            String[] parts = event.split(" ", 3);

            String processName = parts[0];
            int eventSecond = Integer.parseInt(parts[1]);

            if (eventSecond == currentSecond) {
                if (producerMap.containsKey(processName)) {
             
                    String message = parts[2].replace("\"", ""); 
                    producerMap.get(processName).write(message);
                } else if (consumerMap.containsKey(processName)) {
                  
                    consumerMap.get(processName).read();
                }
                eventIndex++;
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentSecond++;
        }
    }
}
