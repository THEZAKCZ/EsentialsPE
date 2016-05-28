package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cn.nukkit.level.particle.AngryVillagerParticle;
import cz.THEZAK.Essentials.Main;

public class setSpawn extends Command
{
  private Main plugin;

  public setSpawn(Main plugin)
  {
    super("setspawn", "Set spawn point", "/setspawn");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.setspawn")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    Player player = (Player)sender;
    Location l = player.getLocation();
    	plugin.getConfig().set("spawn.x", Integer.valueOf(l.getFloorX()));
    	plugin.getConfig().set("spawn.y", Integer.valueOf(l.getFloorY()));
    	plugin.getConfig().set("spawn.z", Integer.valueOf(l.getFloorZ()));
    	plugin.getConfig().set("spawn.pitch", Double.valueOf(l.getPitch()));
    	plugin.getConfig().set("spawn.yaw", Double.valueOf(l.getYaw()));
    	plugin.getConfig().set("spawn.world", player.getLevel().getName());
    	plugin.saveConfig();
    player.sendMessage("§eSpawn location set");
	player.getLevel().addParticle(new AngryVillagerParticle(player.add(0, 2, 0)));
    return true;
  }
}