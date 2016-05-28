package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class suicide extends Command
{
  private Main plugin;

  public suicide(Main plugin)
  {
    super("suicide", "Kill yourself", "/suicide");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.suicide")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    Player player = (Player)sender;
    	player.setHealth(0);
    	player.sendMessage("Ouch. That look like it hurt.");
    return true;
        }
  	}
}