package io.github.hsyyid.polis.cmdexecutors;

import io.github.hsyyid.polis.utils.ConfigManager;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.source.CommandBlockSource;
import org.spongepowered.api.util.command.source.ConsoleSource;
import org.spongepowered.api.util.command.spec.CommandExecutor;

public class RemoveUsableBlockExecutor implements CommandExecutor
{
	public CommandResult execute(CommandSource src, CommandContext ctx) throws CommandException
	{
		String id = ctx.<String> getOne("id").get();

		if (src instanceof Player)
		{
			Player player = (Player) src;
			ConfigManager.removeUsableSafeZoneBlock(id);
			player.sendMessage(Texts.of(TextColors.GREEN, "[Polis]: ", TextColors.GOLD, "Successfully removed interactable SafeZone block."));
		}
		else if (src instanceof ConsoleSource)
		{
			src.sendMessage(Texts.of(TextColors.DARK_RED, "Error! ", TextColors.RED, "Must be an in-game player to use /polis removeblock!"));
		}
		else if (src instanceof CommandBlockSource)
		{
			src.sendMessage(Texts.of(TextColors.DARK_RED, "Error! ", TextColors.RED, "Must be an in-game player to use /polis removeblock!"));
		}

		return CommandResult.success();
	}
}