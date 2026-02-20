package me.remag501.core.api.namespace;

import org.bukkit.NamespacedKey;

public interface NamespaceService {

    // --- Perks Keys ---
    NamespacedKey getPerkIdKey();
    NamespacedKey getRarityKey();
    NamespacedKey getItemIdKey();

    // --- Armor Set  ---
    NamespacedKey getArmorSetKey();
    NamespacedKey getRepairKitKey();
    NamespacedKey getRepairKitTierKey();
    NamespacedKey getDurabilityKey();
    NamespacedKey getMaxDurabilityKey();
    NamespacedKey getVampireKillMarkKey();
    NamespacedKey getBatFormOwnerKey();

    /**
     * Generates a key specifically for tracking Necromancer mob ownership.
     */
    NamespacedKey getNecromancerNamespace(String uuid);

    // --- Adventure  ---
    NamespacedKey getMapVersionKey();
    NamespacedKey getWorldIdKey();

    // --- Items ---
    NamespacedKey getCustomItemKey();

    /**
     * Generates a key specifically for adventure worlds
     */
    NamespacedKey getMapVersionNamespace(String worldName);

    // --- Dynamic/Calculated Keys ---

    /**
     * Creates a unique key based on the provided string.
     * Use this for ad-hoc keys that don't have dedicated getters.
     */
    NamespacedKey key(String key);
}