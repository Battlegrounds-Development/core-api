package me.remag501.core.api.combat;

import java.util.UUID;

public interface CombatStatsService {
    // DAMAGE: Attacker side
    void setWeaponDamageMod(UUID player, String source, float multiplier, WeaponType... types);
    void setTargetDamageMod(UUID player, String source, float multiplier, TargetCategory... categories);

    // DEFENSE: Victim side
    void setWeaponDefenseMod(UUID player, String source, float multiplier, WeaponType... types);
    void setSourceDefenseMod(UUID player, String source, float multiplier, TargetCategory... categories);

    // CLEANUP
    void removeAllMods(UUID player, String source);

    // The logic the Core uses to tie it all together
    float calculateFinalDamage(UUID attacker, UUID victim, float baseDamage, WeaponType weapon, TargetCategory target);
}