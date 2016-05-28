package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class sun extends Command
{
  private Main plugin;

  public sun(Main plugin)
  {
    super("sun", "Set weather to sun", "/sun");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.sun")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    Player player = (Player)sender;
    	player.getLevel().setRaining(false);
    	player.sendMessage("§7Weather set to sun");
    return true;
    }
  }
}