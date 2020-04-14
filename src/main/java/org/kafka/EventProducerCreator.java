package org.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.config.KafkaProps;
import org.pojo.Event;

public final class EventProducerCreator {

    private EventProducerCreator() {}

    public static Producer<String, Event> createProducer() {
        return new KafkaProducer<String, Event>(KafkaProps.getProps());
    }

}
