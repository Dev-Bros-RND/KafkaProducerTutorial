package org;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.generator.EventGenerator;
import org.kafka.EventProducerCreator;
import org.pojo.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String ...args) {

        List<Event> events = EventGenerator.generateList(1000);
        Producer<String, Event> producer = EventProducerCreator.createProducer();

        events.forEach(event -> {
            ProducerRecord record = new ProducerRecord<String, Event>("c123topic",event.getId().toString(), event);
            producer.send(record);
            logger.debug("record sent: " + event);
        });

    }
}
