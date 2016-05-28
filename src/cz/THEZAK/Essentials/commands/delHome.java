package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class delHome extends Command
{
  private Main plugin;

  public delHome(Main plugin)
  {
    super("delhome", "Delete home", "/delhome");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.delhome")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    
    if (args.length == 0) {
        Player player = (Player)sender;
    	player.sendMessage("§eTo remove your home use /delhome Name");
  }
    Player player = (Player)sender;
    if (args.length == 1)
        if (plugin.getConfig().get("homes." + player.getUniqueId() + "." + args[0]) == null) {
            player.sendMessage("§7§oHome named " + args[0] + " §7§odoesn't exist!");
          } else
    	try {
    		plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0], null);

    		player.sendMessage("§7§oWarp named " + args[0] + " §7§owas deleted!");
    	}
    	catch (Exception localException) {
    }
		return true; 
  }
}