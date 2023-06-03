package me.rixv.glassBreak;

import me.rixv.glassBreak.listeners.PlayerMoveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GlassBreak extends JavaPlugin {

    @Override
    public void onEnable() {
        //Registering events
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
    }

}
