package me.remag501.core.api.command;

import org.bukkit.command.CommandExecutor;

public interface CommandService {

    void registerSubcommand(String label, CommandExecutor executor);
}