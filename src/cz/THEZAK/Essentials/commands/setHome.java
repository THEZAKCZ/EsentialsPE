package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.particle.AngryVillagerParticle;
import cz.THEZAK.Essentials.Main;

public class setHome extends Command
{
  private Main plugin;

  public setHome(Main plugin)
  {
    super("sethome", "Set home", "/sethome");
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
    Player player = (Player)sender;
    if (args.length == 1) {
        Location l = player.getLocation();
        plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0] + ".x", Integer.valueOf(l.getFloorX()));
        plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0] + ".y", Integer.valueOf(l.getFloorY()));
        plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0] + ".z", Integer.valueOf(l.getFloorZ()));
        plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0] + ".yaw", (l.getYaw()));
        plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0] + ".pitch", (l.getPitch()));
        plugin.getConfig().set("temphome." + player.getUniqueId(), args[0]);
        plugin.getConfig().set("homes." + player.getUniqueId() + "." + args[0] + ".world", player.getLevel().getName());
        plugin.saveConfig();
        
        player.sendMessage("§2Home named " + args[0] + " §2created!");
    	player.getLevel().addParticle(new AngryVillagerParticle(player.add(0, 2, 0)));
    return true;
    }
	return true;
  }
}