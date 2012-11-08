package edu.unca.jruggier.Test2;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class Test2TreePopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z;

		for(x = 0; x<16; x++) {
			for(z = 0; z<16;z++) {
				if (random.nextInt(50) < 40) {			
					x = 20;
					z = 5;

					for (y = 50; chunk.getBlock(x, y, z).getType() == Material.AIR; --y); {

						world.generateTree(chunk.getBlock(x, y, z).getLocation(),TreeType.BIG_TREE);
		}

	}
}
}
	}
}

	

	