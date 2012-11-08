package edu.unca.jruggier.Test2;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class Test2GoldPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		Block block;
		int x, y, z;
		for(x = 0; x<16; x++) {
			for(z = 0; z<16;z++) {
				if (random.nextInt(50) < 10) {			
					
					for (y = 10; chunk.getBlock(x, y, z).getType() == Material.AIR; --y) {
						block = chunk.getBlock(x,  y + 5,  z+10);
						block.setType(Material.GOLD_BLOCK);
					}
	}
}
}
}
}