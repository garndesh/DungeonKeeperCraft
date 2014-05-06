package garndesh.dkc.blocks;

import cpw.mods.fml.common.FMLLog;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.tileentity.TileDungeonHeart;
import garndesh.dkc.tileentity.TileFiller;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFiller extends Block implements ITileEntityProvider{

	public BlockFiller() {
		super(Material.rock);
		this.setBlockName(Strings.RESOURCE_PREFIX + Strings.BLOCK_FILLER_NAME);
		this.setBlockUnbreakable();
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isRemote){
			TileFiller tileFiller = (TileFiller) world.getTileEntity(x, y, z);
			TileDungeonHeart tileHeart = (TileDungeonHeart) world.getTileEntity(tileFiller.primary_x, tileFiller.primary_y, tileFiller.primary_z);
			if (tileHeart != null){
				tileHeart.damageHeart(3.0F);
			}else{
				FMLLog.warning("Something went very wrong with TileFiller @ %d %d %d", x, y, z);
				FMLLog.warning("No dungeonHeart found @ %d %d %d", tileFiller.primary_x, tileFiller.primary_y, tileFiller.primary_z);
			}
		}
	}
	
    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l){
            return false;
    }
    
    @Override
    public boolean isOpaqueCube(){
            return false;
    }
    
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileFiller();
	}

}
