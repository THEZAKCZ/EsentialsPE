package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cz.THEZAK.Essentials.Main;

public class home extends Command
{
  private Main plugin;

  public home(Main plugin)
  {
    super("home", "Teleport to home", "/home");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.sethome")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    
    if (args.length == 0) {
        Player player = (Player)sender;
    	player.sendMessage("§eTo teleport to home use \n§e/home Name");
  }    
    
    Player player = (Player)sender;
    if (args.length == 1)
        if (plugin.getConfig().get("homes." + player.getUniqueId() + "." + args[0]) == null) {
            player.sendMessage("§7§oHome named " + args[0] + " §7§odoesn't exist!");
          } else
    	try {
            int x = plugin.getConfig().getInt("homes." + player.getUniqueId() + "." + args[0] + ".x");
            int y = plugin.getConfig().getInt("homes." + player.getUniqueId() + "." + args[0] + ".y");
            int z = plugin.getConfig().getInt("homes." + player.getUniqueId() + "." + args[0] + ".z");
            int yaw = plugin.getConfig().getInt("homes." + player.getUniqueId() + "." + args[0] + ".yaw");
            int pitch = plugin.getConfig().getInt("homes." + player.getUniqueId() + "." + args[0] + ".pitch");
            Level world = Server.getInstance().getLevelByName(plugin.getConfig().getString("homes." + player.getUniqueId() + "." + plugin.getConfig().getString(new StringBuilder("temphome.").append(player.getUniqueId()).toString()) + ".world"));
            Location l = new Location(x, y, z, yaw, pitch, world);
            player.teleport(l);
            
            player.sendMessage("§7§oTeleported to home named " + args[0]);

  } catch (Exception localException1) {
  }

	return true;
  }
 }