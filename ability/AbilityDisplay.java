package me.remag501.core.api.ability;

/**
 * Defines where the ability progress should be communicated to the player.
 */
public enum AbilityDisplay {
    /** Uses the Experience Level and XP Bar. Recommended for Armor Sets. */
    XP_BAR,
    /** Sends a temporary title/subtitle. */
    SUBTITLE,
    /** Sends a message to the action bar area above the hotbar. */
    ACTION_BAR,
    /** No visual output; background logic only. */
    NONE
}