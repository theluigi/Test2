package edu.unca.jruggier.Test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;


public class Test2Generator extends ChunkGenerator{

	@SuppressWarnings("unused")
	private Test2 plugin;

	public Test2Generator(Test2 instance){
		this.plugin = instance;
	}

	public List<BlockPopulator> getDefaultPopulators(World world) {
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();

		populators.add(new Test2TreePopulator());
		populators.add(new Test2WaterPopulator());
		populators.add(new Test2GoldPopulator()); 
		
		return populators;
	}

	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0, 80, 0);
	}

	private int coordsToByte(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}

	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
		byte[] chunk = new byte[32768];
		int x,y,z;

		
		Random rand = new Random(world.getSeed());

		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 8);

		octave.setScale(1.0 / 64.0);

		for(x = 0; x<16; x++) {
			for(z = 0; z<16; z++) { {

				chunk[this.coordsToByte(x, 0, z)] = (byte)Material.DIAMOND_BLOCK.getId();
				chunk[this.coordsToByte(x, 50, z)] = (byte)Material.WATER.getId();
				chunk[this.coordsToByte(x, 49, z)] = (byte)Material.GLASS.getId();
							
				chunk[this.coordsToByte(x, 5, z)] = (byte)Material.GOLD_BLOCK.getId(); 
				
				}

			}
		}

		return chunk ;
	}
	
}


