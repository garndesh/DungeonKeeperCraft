package garndesh.dkc.blocks;


import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.RenderIds;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.tileentity.TileDungeonHeart;
import garndesh.dkc.tileentity.TileFiller;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;

public class BlockDungeonHeart extends Block implements ITileEntityProvider{

	public BlockDungeonHeart() {
		super(Material.rock);
        
		//Sets the block hardness (time it takes to mine)
		setHardness(5.0F);
		
		//Sets the unlocalized name which gets replaced by the name from the selected language file
        setBlockName(Strings.RESOURCE_PREFIX + Strings.BLOCK_DUNGEONHEART_NAME);
         
        //Add block to creativeTab
        //setCreativeTab(DungeonKeeperCraft.tabsBM);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		//FMLLog.info("BlockPlaced addingFillers");
		if(!world.isRemote){
			for(int dx = -1; dx <2; dx++){
				for(int dy = 0; dy <3; dy++){
					for(int dz = -1; dz<2; dz++){
						//FMLLog.info("placing filler@ %d %d %d", dx, dy, dz);
						if(dx!=0 || dy!=0 || dz!=0){
							world.setBlock(x+dx, y+dy, z+dz, ModBlocks.blockFiller, 0, 2);
							TileFiller tile = (TileFiller) world.getTileEntity(x+dx, y+dy, z+dz);
							if(tile != null){
								tile.setCoords(x, y, z);
							} else {
								FMLLog.warning("Something went wrong while trying to add data to fillerblock @ %d %d %d", x+dx, y+dy, z+dz);
							}
							
						}
					}
				}
			}
		}
		super.onBlockAdded(world, x, y, z);
	}
	
	@Override
	public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
		for(int dx = -1; dx <2; dx++){
			for(int dy = 0; dy <3; dy++){
				for(int dz = -1; dz<2; dz++){
					if(dx!=0 || dy!=0 || dz!=0){
						world.setBlockToAir(x+dx, y+dy, z+dz);
					}
				}
			}
		}
	}
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override 
	public int getRenderType(){
		return RenderIds.dungeonHeartRenderId;
	}

	//And this tell it that you can see through this block, and neighbor blocks should be rendered.
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		//FMLLog.info("Creating TileEntity"+var2);
		return new TileDungeonHeart();
	}
}
