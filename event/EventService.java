package me.remag501.core.api.event;

import org.bukkit.event.Event;
import java.util.UUID;

public interface EventService {

    <T extends Event> SubscriptionBuilder<T> subscribe(Class<T> eventClass);

    void unregisterListener(UUID ownerId, String namespace);
}
