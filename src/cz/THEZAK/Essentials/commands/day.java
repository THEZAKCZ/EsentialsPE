package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class day extends Command
{
  private Main plugin;

  public day(Main plugin)
  {
    super("day", "Set time to day", "/day");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.day")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    Player player = (Player)sender;
    	player.getLevel().setTime(0);
    	player.sendMessage("§7Time set to day");
    return true;
    }
  }
}