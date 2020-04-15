package org.generator;

import org.pojo.Event;
import org.pojo.Priority;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class EventGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final long now = new Date().getTime();

    private EventGenerator() {}

    public static Event generate() {
        return new Event(UUID.randomUUID(), randomDate(), "This is a desc string", randomPriority());
    }

    public static List<Event> generateList(int amount) {
        return IntStream.range(1, amount)
            .mapToObj(index -> generate())
            .collect(Collectors.toList());
    }

    private static Date randomDate() {
        long randomDate = now + random.nextInt(600_000) + 200_000;
        return new Date(randomDate);
    }

    private static Priority randomPriority() {
        switch (random.nextInt(3)) {
            case 0: return Priority.LOW;
            case 1: return Priority.MEDIUM;
            default: return Priority.HIGH;
        }
    }

}
