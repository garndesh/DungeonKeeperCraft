package garndesh.dkc.world.gen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderDungeon implements IChunkProvider {

	private World worldObj;
	private int populatedChunks = 12;
	private Random rand;
	private CaveGen caves;
	
	public ChunkProviderDungeon(World world){
		this.worldObj = world;
		this.rand = this.worldObj.rand;
		this.caves = new CaveGen(this.worldObj);
	}
	
	
	@Override
	public boolean chunkExists(int x, int z) {
		return (Math.abs(x) <= populatedChunks && Math.abs(z) <= populatedChunks);
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) {
		Block[] blocks = new Block[16*16*256];
		byte[] meta = new byte[16*16*256];
		//FMLLog.info("providing Chunk");
		if (Math.abs(chunkX) <= populatedChunks && Math.abs(chunkZ) <= populatedChunks ){
			//FMLLog.info("Filling Chunk");
			for(int x =0; x < 16; x++){
				for (int y = 0; y < 256; y++){
					for(int z = 0; z < 16; z++){
						if (y == 0) {
							blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("bedrock");
						} else if (y <= 4){
							blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("stone");
							if ((x+rand.nextInt(4) >= 15 && chunkX == this.populatedChunks)){
								blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("bedrock");
							} else if ((x-rand.nextInt(4) <= 0 && chunkX == -this.populatedChunks)){
								blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("bedrock");
							} else if ((z+rand.nextInt(4) >= 15 && chunkZ == this.populatedChunks)){
								blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("bedrock");
							} else if ((z-rand.nextInt(4) <= 0 && chunkZ == -this.populatedChunks)){
								blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("bedrock");
							}
						}
					}
				}
			}
		}
		caves.generateCaves(chunkX, chunkZ, blocks);
		Chunk chunk = new Chunk(this.worldObj, blocks, meta, chunkX, chunkZ);
		chunk.generateSkylightMap();
		chunk.generateHeightMap();
		return chunk;
	}

	@Override
	public Chunk loadChunk(int x, int y) {
		return this.provideChunk(x, y);
	}

	@Override
	public void populate(IChunkProvider var1, int var2, int var3) {
		
	}

	@Override
	public boolean saveChunks(boolean var1, IProgressUpdate var2) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "SomethingSomethingDungeon";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3,
			int var4) {
		return null;
	}

	@Override
	public ChunkPosition func_147416_a(World var1, String var2, int var3,
			int var4, int var5) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int var1, int var2) {
		
	}

	@Override
	public void saveExtraData() {
		
	}

}
