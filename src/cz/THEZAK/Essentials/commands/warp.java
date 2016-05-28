package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cz.THEZAK.Essentials.Main;

public class warp extends Command
{
  private Main plugin;

  public warp(Main plugin)
  {
    super("warp", "Teleport to warp", "/warp");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.warp")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    
    if (args.length == 0) {
        Player player = (Player)sender;
    	player.sendMessage("§eTo teleport use /warp name");
  }
    Player player = (Player)sender;
    if (args.length == 1)
        if (plugin.getConfig().get("warps." + args[0]) == null) {
            player.sendMessage("§7§oWarp named " + args[0] + " §7§odoesn't exist!");
          } else
    	try {
    		int x = plugin.getConfig().getInt("warps." + args[0] + ".x");
    		int y = plugin.getConfig().getInt("warps." + args[0] + ".y");
    		int z = plugin.getConfig().getInt("warps." + args[0] + ".z");
    		int yaw = plugin.getConfig().getInt("warps." + args[0] + ".yaw");
    		int pitch = plugin.getConfig().getInt("warps." + args[0] + ".pitch");            
    		Level world = Server.getInstance().getLevelByName(plugin.getConfig().getString("warps." + args[0] + ".world"));
    		Location l = new Location(x, y, z, yaw, pitch, world);
    		player.teleport(l);

    		player.sendMessage("§7§oTeleported to warp " + args[0]);
    	}
    	catch (Exception localException) {
    }
		return true; 
  }
}