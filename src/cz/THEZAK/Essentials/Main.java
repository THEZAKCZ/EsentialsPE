package cz.THEZAK.Essentials;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cz.THEZAK.Essentials.commands.*;
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
    config.save();
    getServer().getLogger().info("EssentialsPE loaded!");
    getServer().getCommandMap().register("setspawn", new setSpawn(this));
    getServer().getCommandMap().register("spawn", new spawn(this));
    getServer().getCommandMap().register("warp", new warp(this));
    getServer().getCommandMap().register("setwarp", new setWarp(this));
    getServer().getCommandMap().register("day", new day(this));
    getServer().getCommandMap().register("night", new night(this));
    getServer().getCommandMap().register("rain", new sun(this));
    getServer().getCommandMap().register("sun", new rain(this));
    getServer().getCommandMap().register("delwarp", new delWarp(this));
    getServer().getCommandMap().register("sethome", new setHome(this));
    getServer().getCommandMap().register("home", new home(this));
    getServer().getCommandMap().register("delhome", new home(this));
    getServer().getCommandMap().register("suicide", new suicide(this));
    getServer().getCommandMap().register("heal", new heal(this));
    getServer().getCommandMap().register("clear", new clear(this));
  }
    public void onDisable()
    {
      getServer().getLogger().info("EssentialsPE disabled!");
  }
}

// Created by THEZAK :)