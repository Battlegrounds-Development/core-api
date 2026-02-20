package me.remag501.core.api.util;

/**
 * Standardized message prefixes for the BGS suite.
 */
public final class BGSColor {

    private BGSColor() {} // Prevent instantiation

    // --- Plugin Brand Prefixes ---
    public static final String PREFIX_CORE  = "§3§lCORE §8» §7";
    public static final String PREFIX_PERKS = "§6§lPERKS §8» §7";
    public static final String PREFIX_ARMOR = "§b§lARMOR §8» §7";
    public static final String PREFIX_ADVENTURE = "§d§lADVENTURE §8» §7";

    // --- Alert Tones ---
    public static final String NEGATIVE = "§c§l(!) §c";
    public static final String POSITIVE = "§a§l(!) §a";

    // --- Helper Colors (For the rest of the message) ---
    public static final String TEXT = "§7";
    public static final String HIGHLIGHT = "§f";
}