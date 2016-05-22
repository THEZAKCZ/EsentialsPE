package cz.THEZAK.Essentials.commands;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;

public class Commands 
implements Listener
{

@EventHandler 
public void Command() {
    new setspawn();
    new spawn();
    new setwarp();
	}
}
