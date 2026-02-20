package me.remag501.core.api;

import me.remag501.core.api.ability.AbilityService;
import me.remag501.core.api.combat.AttributeService;
import me.remag501.core.api.combat.CombatStatsService;
import me.remag501.core.api.command.CommandService;
import me.remag501.core.api.event.EventService;
import me.remag501.core.api.namespace.NamespaceService;
import me.remag501.core.api.task.TaskService;
import org.bukkit.Bukkit;

/**
 * The primary entry point for the BGSCore API.
 * All Perk plugins should access Core features through these methods.
 */
public final class BGSApi {

    // Private constructor to prevent instantiation
    private BGSApi() {}

    /**
     * @return The service for scheduling heartbeats and delayed tasks.
     */
    public static TaskService tasks() {
        return getService(TaskService.class);
    }

    /**
     * @return The service for fluent event subscriptions.
     */
    public static EventService events() {
        return getService(EventService.class);
    }

    /**
     * @return The service for registering subcommands to the /bgs command.
     */
    public static CommandService commands() {
        return getService(CommandService.class);
    }

    /**
     * @return The service for registering cooldowns, charges, and ultimates
     */
    public static AbilityService ability() {
        return getService(AbilityService.class);
    }

    public static NamespaceService namespaces() {
        return getService(NamespaceService.class);
    }

    public static AttributeService attribute() {
        return getService(AttributeService.class);
    }

    public static CombatStatsService combat() {
        return getService(CombatStatsService.class);
    }

    /**
     * Internal helper to fetch registered services from Bukkit.
     */
    private static <T> T getService(Class<T> serviceClass) {
        var registration = Bukkit.getServicesManager().getRegistration(serviceClass);
        if (registration == null) {
            throw new IllegalStateException("BGSCore Service " + serviceClass.getSimpleName() + " is not registered!");
        }
        return registration.getProvider();
    }
}