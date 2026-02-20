package me.remag501.core.api.task;

import java.util.UUID;
import java.util.function.Predicate;

public interface TaskService {

    void subscribe(UUID ownerId, String category, int delay, int interval, boolean allowDuplicates, Predicate<Integer> logic);

    void subscribe(UUID ownerId, String category, int delay, int interval, Predicate<Integer> logic);

    void subscribe(UUID id, int delay, int interval, Predicate<Integer> logic);

    void subscribe(UUID id, int interval, Predicate<Integer> logic);

    void subscribe(UUID id, Predicate<Integer> logic);

    void delay(int delayTicks, Runnable logic);

    void stopTask(UUID ownerId, String namespace);

    void subscribe(KeyedTickable tickable);
}