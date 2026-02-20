package me.remag501.core.api.event;

import me.remag501.core.internal.event.EventRegistry;
import me.remag501.core.internal.event.Subscription;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SubscriptionBuilder<T extends Event> {

    private final EventRegistry eventRegistry;
    private final Class<T> eventClass;

    private final List<Predicate<T>> filters = new ArrayList<>();
    private UUID ownerId = null;
    private String namespace = "general";

    public SubscriptionBuilder(EventRegistry eventRegistry, Class<T> eventClass) {
        this.eventRegistry = eventRegistry;
        this.eventClass = eventClass;
    }

    public SubscriptionBuilder<T> owner(UUID ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public SubscriptionBuilder<T> namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public SubscriptionBuilder<T> filter(Predicate<T> filter) {
        filters.add(filter);
        return this;
    }

    public void handler(Consumer<T> handler) {
        Subscription<T> sub = new Subscription<>(filters, handler, ownerId, namespace);
        eventRegistry.register(eventClass, sub);
    }
}