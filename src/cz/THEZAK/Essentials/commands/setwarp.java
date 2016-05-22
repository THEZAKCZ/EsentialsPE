package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import cz.THEZAK.Essentials.Main;

public class setwarp {
	Main main = new Main();
	
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    Player p = null;
	    if ((sender instanceof Player)) {
	      p = (Player)sender;
	    }
	    
    if (command.getName().equalsIgnoreCase("setwarp")) {
        if (p == null) {
          sender.sendMessage("You have to be a Player");
          return true;
        }if (p != null) {
          if (p.hasPermission("warps.setwarp")) {
            if (args.length == 1) {
              Location l = p.getLocation();
              this.main.getConfig().set("warps." + args[0] + ".x", Integer.valueOf(l.getFloorX()));
              this.main.getConfig().set("warps." + args[0] + ".y", Integer.valueOf(l.getFloorY()));
              this.main.getConfig().set("warps." + args[0] + ".z", Integer.valueOf(l.getFloorZ()));
              this.main.getConfig().set("warps." + args[0] + ".yaws", (l.getYaw()));
              this.main.getConfig().set("warps." + args[0] + ".pitch", (l.getPitch()));            
              this.main.getConfig().set("warps." + args[0] + ".world", p.getLevel().getName());
              this.main.saveConfig();

              p.sendMessage("§2Warp created!");
   
            } else {
              p.sendMessage("§eSet warp using /setwarp name!");
            }return true;
          }
          p.sendMessage("§cYou don't have permissions!");
        }

      }
	return true;
   }
}
