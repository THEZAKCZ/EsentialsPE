package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cz.THEZAK.Essentials.Main;

public class delWarp extends Command
{
  private Main plugin;

  public delWarp(Main plugin)
  {
    super("delwarp", "Delete warp", "/delwarp");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.delwarp")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    
    if (args.length == 0) {
        Player player = (Player)sender;
    	player.sendMessage("§eTo remove warp use /delwarp Name");
  }
    Player player = (Player)sender;
    if (args.length == 1)
        if (plugin.getConfig().get("warps." + args[0]) == null) {
            player.sendMessage("§7§oWarp named " + args[0] + " §7§odoesn't exist!");
          } else
    	try {
    		plugin.getConfig().set("warps." + args[0], null);

    		player.sendMessage("§7§oWarp named " + args[0] + " §7§owas deleted!");
    	}
    	catch (Exception localException) {
    }
		return true; 
  }
}