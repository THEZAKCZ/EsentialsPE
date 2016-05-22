package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cz.THEZAK.Essentials.Main;

public class setspawn {
	Main main = new Main();
	
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		    Player player = null;
		    if ((sender instanceof Player)) {
		      player = (Player)sender;
		    }

		    if (command.getName().equalsIgnoreCase("setspawn")) {
		      if (player == null) {
		        sender.sendMessage("You have to be a Player");
		        return true;
		      }if (player != null) {
		        if (player.hasPermission("warps.setspawn")) {
		          Location l = player.getLocation();
		          this.main.getConfig().set("spawn.x", Integer.valueOf(l.getFloorX()));
		          this.main.getConfig().set("spawn.y", Integer.valueOf(l.getFloorY()));
		          this.main.getConfig().set("spawn.z", Integer.valueOf(l.getFloorZ()));
		          this.main.getConfig().set("spawn.pitch", Double.valueOf(l.getPitch()));
		          this.main.getConfig().set("spawn.yaw", Double.valueOf(l.getYaw()));
		          this.main.getConfig().set("spawn.world", player.getLevel().getName());
		          this.main.saveConfig();
		          player.sendMessage("§eSpawn location set");
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
