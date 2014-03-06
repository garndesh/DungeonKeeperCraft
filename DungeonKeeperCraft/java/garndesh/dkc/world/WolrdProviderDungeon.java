package garndesh.dkc.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import garndesh.dkc.world.gen.ChunkProviderDungeon;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WolrdProviderDungeon extends WorldProvider{

	@Override
	public String getDimensionName() {
		return "GoodTobeEvil";
	}
	
	@Override
	public void registerWorldChunkManager(){
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0);
        this.isHellWorld = true;
        this.hasNoSky = true;
    }
	
	 /**
     * Returns a new chunk provider which generates chunks for this world
     */
	@Override
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderDungeon(this.worldObj);
    }

	/**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
	@Override
    public boolean isSurfaceWorld()
    {
        return false;
    }
	
	/**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public boolean doesXZShowFog(int par1, int par2)
    {
        return false;
    }
    
    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.5F;
    }
}
