package me.rixv.glassBreak.tasks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

public class RepairGlass extends BukkitRunnable {

    private Material mat;
    private Location loc;

    public RepairGlass(Location loc, Material mat) {
        this.loc = loc;
        this.mat = mat;
    }



    @Override
    public void run() {
        Block block = loc.getBlock();
        block.setType(mat);

        MultipleFacing multipleFacing = (MultipleFacing) block.getBlockData();

        //Getting faces of the glass pane that are applicable
        Set<BlockFace> faces = multipleFacing.getAllowedFaces();

        //if a face is applicable we check if a block near glass pane is not air and if it isn't we apply corresponding
        //face
        if (faces.contains(BlockFace.NORTH)) {
            Location temploc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ() - 1);
            if (!temploc.getBlock().getType().equals(Material.AIR))
                multipleFacing.setFace(BlockFace.NORTH, true);
        }

        if (faces.contains(BlockFace.EAST)) {
            Location temploc = new Location(loc.getWorld(), loc.getX() + 1, loc.getY(), loc.getZ());
            if (!temploc.getBlock().getType().equals(Material.AIR))
                multipleFacing.setFace(BlockFace.EAST, true);
        }

        if (faces.contains(BlockFace.SOUTH)) {
            Location temploc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ() + 1);
            if (!temploc.getBlock().getType().equals(Material.AIR))
                multipleFacing.setFace(BlockFace.SOUTH, true);
        }

        if (faces.contains(BlockFace.WEST)) {
            Location temploc = new Location(loc.getWorld(), loc.getX() - 1, loc.getY(), loc.getZ());
            if (!temploc.getBlock().getType().equals(Material.AIR))
                multipleFacing.setFace(BlockFace.WEST, true);
        }

        //Setting the block data that has been modified
        block.setBlockData(multipleFacing);

    }
}


