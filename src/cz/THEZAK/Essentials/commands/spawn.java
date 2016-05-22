package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cz.THEZAK.Essentials.Main;

public class spawn {
	Main main = new Main();
	
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		    Player player = null;
		    if ((sender instanceof Player)) {
		      player = (Player)sender;
		    }
		    if (command.getName().equalsIgnoreCase("spawn")) {
		      if (player == null) {
		        sender.sendMessage("You have to be a Player");
		        return true;
		      }if (player != null) {
		        if (player.hasPermission("warps.spawn")) {
		          try {
		            int x = this.main.getConfig().getInt("spawn.x");
		            int y = this.main.getConfig().getInt("spawn.y");
		            int z = this.main.getConfig().getInt("spawn.z");
		            int pitch = this.main.getConfig().getInt("spawn.pitch");
		            int yaw = this.main.getConfig().getInt("spawn.yaw");
		            Level world = Server.getInstance().getLevelByName(this.main.getConfig().getString("spawn.world"));
		            Location l = new Location(x, y, z, yaw, pitch, world);
		            player.teleport(l);
		            player.sendMessage("§7§oTeleported to spawn");
		          } catch (Exception ex) {
		            player.sendMessage("eSpawn location isn't exist!");
		          }
		        } else {
		          player.sendMessage("§cYou don!t have permissions!");
		          return true;
		        }
		        return true;
		      }

		    }
			return true;
	  }
}
