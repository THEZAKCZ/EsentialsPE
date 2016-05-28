package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cz.THEZAK.Essentials.Main;

public class spawn extends Command
{
  private Main plugin;

  public spawn(Main plugin)
  {
    super("spawn", "Teleport to spawn point", "/spawn");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.spawn")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    Player player = (Player)sender;
    	int x = plugin.getConfig().getInt("spawn.x");
    	int y = plugin.getConfig().getInt("spawn.y");
    	int z = plugin.getConfig().getInt("spawn.z");
    	int pitch = plugin.getConfig().getInt("spawn.pitch");
    	int yaw = plugin.getConfig().getInt("spawn.yaw");
    	Level world = Server.getInstance().getLevelByName(plugin.getConfig().getString("spawn.world"));
    	Location l = new Location(x, y, z, yaw, pitch, world);
    player.teleport(l);
    player.sendMessage("§7§oTeleported to spawn");
    return true;
    }
  }
}