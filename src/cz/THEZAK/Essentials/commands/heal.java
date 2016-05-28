package cz.THEZAK.Essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.particle.HeartParticle;
import cz.THEZAK.Essentials.Main;

public class heal extends Command
{
  private Main plugin;

  public heal(Main plugin)
  {
    super("heal", "Heal yourself", "/heal");
    this.plugin = plugin;
  }

  public boolean execute(CommandSender sender, String label, String[] args)
  {
    if (!this.plugin.isEnabled()) return false;
    if (!sender.hasPermission("essentials.heal")) {
      sender.sendMessage("§cYou don't have permission!");
      return false;
    }

    if (!(sender instanceof Player)) {
      sender.sendMessage("§eYou can use this command only in game!");
      return true;
    }
    {
    Player player = (Player)sender;
    	player.setHealth(20);
    	player.getLevel().addParticle(new HeartParticle(player.add(0, 2, 0)));
    return true;
        }
  	}
}