package org.generator;

import org.pojo.Event;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class EventGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final long now = new Date().getTime();

    private EventGenerator() {}

    public static Event generate() {
        return new Event(UUID.randomUUID(), randomDate(), "This is a desc string");
    }

    public static List<Event> generateList(int amount) {
        List<Event> list = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            list.add(generate());
        }
        return list;
    }

    private static Date randomDate() {
        long randomDate = now + random.nextInt(600_000) + 200_000;
        return new Date(randomDate);
    }

}
