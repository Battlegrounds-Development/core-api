package me.remag501.core.api.oraxen;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface OraxenService {

    /**
     * Checks if an item is a valid Oraxen item and matches the given ID.
     */
    boolean isItem(ItemStack item, String oraxenId);

    /**
     * Gets the Oraxen ID from an item, or null if it's not an Oraxen item.
     */
    @Nullable
    String getId(ItemStack item);

    /**
     * Creates an ItemStack based on an Oraxen ID.
     */
    @Nullable
    ItemStack getItem(String oraxenId);

    @Nullable
    String getItemDisplayName(String oraxenId);

    /**
     * Gets a custom tag value from an Oraxen item, or null if not present.
     * This reads directly from the item's PersistentDataContainer.
     */
    @Nullable
    public String getTag(ItemStack item, String tagKey);

}