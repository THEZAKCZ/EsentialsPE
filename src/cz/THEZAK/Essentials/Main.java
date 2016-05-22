package cz.THEZAK.Essentials;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cz.THEZAK.Essentials.commands.Commands;
import java.io.File;
import java.util.LinkedHashMap;

public class Main extends PluginBase
  implements Listener
{
@SuppressWarnings({ "deprecation", "unchecked", "serial", "rawtypes" })
public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this, this);
    getDataFolder().mkdir();
    Config config = new Config(new File(
      getDataFolder(), "config.yml"), 2, new LinkedHashMap()
    {
    });
    new Commands();
    config.save();

    getServer().getLogger().info("EssentialsPE loaded!");
  }
    
    public void onDisable()
    {
      getServer().getLogger().info("EssentialsPE disabled!");
  }
}