package _22010310073_BerkUyar_;

import java.util.LinkedList;
import java.util.Queue;

public class _22010310073_Kernel {
    private _22010310073_Pipe pipe;
    private Queue<_22010310073_Producer> blockedProducers;
    private Queue<_22010310073_Consumer> blockedConsumers;

    public _22010310073_Kernel() {
        pipe = new _22010310073_Pipe();
        blockedProducers = new LinkedList<>();
        blockedConsumers = new LinkedList<>();
    }

    public void write(_22010310073_Producer producer, String message) {
        if (message.length() > 20) {
            message = message.substring(0, 20);
        }

        if (pipe.isFull()) {
          
            System.out.println(producer.getName() + " prosesi bloklandı ve kuyruğa alındı.");
            blockedProducers.add(producer);
        } else {
            pipe.write(message);
            System.out.println(producer.getName() + " prosesi write çağrısı yaptı.");

            if (!blockedConsumers.isEmpty()) {
                _22010310073_Consumer consumer = blockedConsumers.poll();
                System.out.println(consumer.getName() + " prosesi uyandırıldı. Okunan mesaj: \"" + pipe.read() + "\"");
            }
        }
    }

    public void read(_22010310073_Consumer consumer) {
        if (pipe.isEmpty()) {
            System.out.println(consumer.getName() + " prosesi read çağrısı yaptı.");
            System.out.println(consumer.getName() + " prosesi bloklandı ve kuyruğa alındı.");
            blockedConsumers.add(consumer);
        } else {
            String message = pipe.read();
            System.out.println(consumer.getName() + " prosesi read çağrısı yaptı. Okunan mesaj: \"" + message + "\"");

            if (!blockedProducers.isEmpty()) {
                _22010310073_Producer producer = blockedProducers.poll();
                System.out.println(producer.getName() + " prosesi uyandırıldı.");
            }
        }
    }
}
