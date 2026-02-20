package me.remag501.core.api.ability;

import java.time.Duration;
import java.util.UUID;

public interface AbilityService {

    // --- MODEL 1: COOLDOWNS (Time-Based) ---
    /** Starts a standard cooldown timer. */
    void startCooldown(UUID player, String id, Duration time, AbilityDisplay display);

    // Add these to AbilityService.java
    void start(UUID player, String id, Duration activeTime, Duration cooldownTime, AbilityDisplay display);

    /** Subtracts time from an active cooldown. */
    void reduceCooldown(UUID player, String id, Duration amount);

    void stopChanneling(UUID player, String id);

    boolean isActive(UUID player, String id); // Is it currently "firing"?

    /** Gets raw milliseconds remaining. */
    long getRemainingMillis(UUID player, String id);

    // --- MODEL 2: ULTIMATES (Value-Based) ---
    /** Initializes an ultimate/resource bar. */
    void setupUltimate(UUID player, String id, double max, AbilityDisplay display);

    /** Increments the current charge. */
    void addCharge(UUID player, String id, double amount);

    /** Sets the charge to a specific value. */
    void setCharge(UUID player, String id, double value);

    double getCurrentCharge(UUID player, String id);
    double getMaxCharge(UUID player, String id);

    // --- MODEL 3: STACKS (Rechargeable) ---
    /** Initializes an ability with multiple charges that refill over time. */
    void setupStocks(UUID player, String id, int maxStacks, Duration refillTime, AbilityDisplay display);

    /** Consumes one stack. Returns true if successful. */
    boolean consumeStack(UUID player, String id);

    int getAvailableStacks(UUID player, String id);
    int getMaxStacks(UUID player, String id);

    // --- SHARED UTILITIES ---
    /** Returns true if the ability can be used (Cooldown finished, Charge full, or Stacks > 0). */
    boolean isReady(UUID player, String id);

    /** Returns 0.0 to 1.0 representing the current phase's completion. */
    double getPercentage(UUID player, String id);

    /** Completely removes the ability state for the player. */
    void reset(UUID player, String id);
}