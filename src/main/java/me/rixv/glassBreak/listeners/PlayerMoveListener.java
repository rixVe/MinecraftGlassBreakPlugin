package me.rixv.glassBreak.listeners;

import me.rixv.glassBreak.tasks.RepairGlass;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class PlayerMoveListener implements Listener {

    Plugin plugin;

    public PlayerMoveListener(Plugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        //loc1 is ground level and loc2 is head level
        Location loc1 = event.getTo();
        Location loc2 = new Location(loc1.getWorld(), loc1.getX(), loc1.getY() + 1, loc1.getZ());
        //getting materials for both loc1 and loc2
        Material mat1 = loc1.getBlock().getType();
        Material mat2 = loc2.getBlock().getType();


        if(mat1 == Material.GLASS_PANE || mat1 == Material.ORANGE_STAINED_GLASS_PANE || mat1 == Material.RED_STAINED_GLASS_PANE || mat1 == Material.MAGENTA_STAINED_GLASS_PANE || mat1 == Material.LIME_STAINED_GLASS_PANE || mat1 == Material.CYAN_STAINED_GLASS_PANE || mat1 == Material.PINK_STAINED_GLASS_PANE || mat1 == Material.PURPLE_STAINED_GLASS_PANE || mat1 == Material.LIGHT_GRAY_STAINED_GLASS_PANE || mat1 == Material.LIGHT_BLUE_STAINED_GLASS_PANE || mat1 == Material.BLACK_STAINED_GLASS_PANE || mat1 == Material.BLUE_STAINED_GLASS_PANE || mat1 == Material.WHITE_STAINED_GLASS_PANE || mat1 == Material.GREEN_STAINED_GLASS_PANE || mat1 == Material.YELLOW_STAINED_GLASS_PANE || mat1 == Material.BROWN_STAINED_GLASS_PANE || mat1 == Material.GRAY_STAINED_GLASS_PANE) {
            //Removing the block
            loc1.getBlock().setType(Material.AIR);
            //Calling RepairGlass with a 200 tick(10s) delay
            new RepairGlass(loc1, mat1).runTaskLater(plugin, 200);
        }

        if(mat2 == Material.GLASS_PANE || mat2 == Material.ORANGE_STAINED_GLASS_PANE || mat2 == Material.RED_STAINED_GLASS_PANE || mat2 == Material.MAGENTA_STAINED_GLASS_PANE || mat2 == Material.LIME_STAINED_GLASS_PANE || mat2 == Material.CYAN_STAINED_GLASS_PANE || mat2 == Material.PINK_STAINED_GLASS_PANE || mat2 == Material.PURPLE_STAINED_GLASS_PANE || mat2 == Material.LIGHT_GRAY_STAINED_GLASS_PANE || mat2 == Material.LIGHT_BLUE_STAINED_GLASS_PANE || mat2 == Material.BLACK_STAINED_GLASS_PANE || mat2 == Material.BLUE_STAINED_GLASS_PANE || mat2 == Material.WHITE_STAINED_GLASS_PANE || mat2 == Material.GREEN_STAINED_GLASS_PANE || mat2 == Material.YELLOW_STAINED_GLASS_PANE || mat2 == Material.BROWN_STAINED_GLASS_PANE || mat2 == Material.GRAY_STAINED_GLASS_PANE) {
            //Removing the block
            loc2.getBlock().setType(Material.AIR);
            //Calling Repair Glass with a 200 tick(10s) delay
            new RepairGlass(loc2, mat2).runTaskLater(plugin, 200);
        }


    }

}
