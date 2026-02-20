package me.remag501.core.api.task;

import java.util.UUID;

public interface KeyedTickable {
    UUID getOwnerId(); // Formerly getUniqueId - the Player/Entity
    String getTaskType(); // The specific name: "molotov", "perk_speed", etc.

    default String getFullKey() {
        return getOwnerId().toString() + ":" + getTaskType();
    }

    boolean tick();
}