package garndesh.dkc.world;

import garndesh.dkc.world.gen.ChunkProviderDungeon;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldTypeDungeon extends WorldType{

	public WorldTypeDungeon(String name) {
		super(name);
	}
	
	//Sets up the biome and WorldChunkManager.
    @Override
    public WorldChunkManager getChunkManager(World world)
    {
        return new WorldChunkManagerHell(BiomeGenBase.plains, 0); //WorldChunkManager can be used but will
    }

    //Sets up the ChunkProvider. Use ChunkProviderHell for single biome worlds else use ChunkProviderGenerate or a custom provider.
    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
        return new ChunkProviderDungeon(world); //
    }

    //Gets the spawn fuzz for players who join the world.
    @Override
    public int getSpawnFuzz()
    {
        return 100;
    }
    
    public int getMinimumSpawnHeight(World world)
    {
        return  4 ;
    }

    public double getHorizon(World world)
    {
        return 0.0D;
    }

    public boolean hasVoidParticles(boolean flag)
    {
        return false;
    }
}
