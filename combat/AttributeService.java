package me.remag501.core.api.combat;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public interface AttributeService {
    /**
     * Adds a modifier to a player.
     *
     * @param source e.g., "perk_bloodied"
     * @param amount e.g., 0.2 for +20%
     */
    void addModifier(Player player, Attribute attribute, String source, double amount);

    void removeModifier(Player player, Attribute attribute, String source);

    /**
     * Removes all modifiers associated with a specific source from all attributes on a player.
     * @param source The source string (e.g., "perk_bloodied")
     */
    void resetSource(Player player, String source);

    /**
     * Completely wipes all modifiers from a specific source for every attribute.
     * Useful for data cleanup or full perk resets.
     */
    void globalReset(Player player);

    void applyMaxAbsorption(Player player, String source, double amount);

    // Shorthand helpers for your common logic (1.21.1+ Style)

    default void applyDamage(Player player, String source, double amount) {
        // GENERIC_ATTACK_DAMAGE -> ATTACK_DAMAGE
        addModifier(player, Attribute.ATTACK_DAMAGE, source, amount);
    }

    default void applyMaxHealth(Player player, String source, double amount) {
        addModifier(player, Attribute.MAX_HEALTH, source, amount);
    }

    default void applyAttackDamage(Player player, String source, double amount) {
        addModifier(player, Attribute.ATTACK_DAMAGE, source, amount);
    }

    default void applyAttackSpeed(Player player, String source, double amount) {
        addModifier(player, Attribute.ATTACK_SPEED, source, amount);
    }

    default void applyKnockbackResist(Player player, String source, double amount) {
        addModifier(player, Attribute.KNOCKBACK_RESISTANCE, source, amount);
    }

    default void applySpeed(Player player, String source, double amount) {
        addModifier(player, Attribute.MOVEMENT_SPEED, source, amount);
    }

    default void applyGravity(Player player, String source, double amount) {
        // amount -0.04 would make them floaty/moon jump style
        addModifier(player, Attribute.GRAVITY, source, amount);
    }

    default void applyStepHeight(Player player, String source, double amount) {
        // amount 1.0 allows walking up full blocks without jumping
        addModifier(player, Attribute.STEP_HEIGHT, source, amount);
    }

    default void applyJumpStrength(Player player, String source, double amount) {
        addModifier(player, Attribute.JUMP_STRENGTH, source, amount);
    }

    default void applyScale(Player player, String source, double amount) {
        // 0.5 makes them tiny (Ant-man), 2.0 makes them a Giant!
        addModifier(player, Attribute.SCALE, source, amount);
    }

    default void applyBlockReach(Player player, String source, double amount) {
        addModifier(player, Attribute.BLOCK_INTERACTION_RANGE, source, amount);
    }

    default void applyEntityReach(Player player, String source, double amount) {
        // Great for "Spear" or "Longsword" perks
        addModifier(player, Attribute.ENTITY_INTERACTION_RANGE, source, amount);
    }

    default void applyLuck(Player player, String source, double amount) {
        addModifier(player, Attribute.LUCK, source, amount);
    }

}