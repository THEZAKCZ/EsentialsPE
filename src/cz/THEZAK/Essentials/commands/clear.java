package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class clear extends Command
{
  private Main plugin;

  public clear(Main plugin)
  {
    super("clear", "Clear your inventory", "/clear");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.clear")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    if (args.length == 0) {    	
    	Player player = (Player)sender;
    	player.getInventory().clearAll();
    	player.sendMessage("§7Your inventory has been cleared!");
    		}
  		}
	return true;
  	}
}