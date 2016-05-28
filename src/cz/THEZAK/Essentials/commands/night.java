package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class night extends Command
{
  private Main plugin;

  public night(Main plugin)
  {
    super("night", "Set time to night", "/night");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.night")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    Player player = (Player)sender;
    	player.getLevel().setTime(13000);
    	player.sendMessage("§7Time set to night");
    return true;
    }
  }
}