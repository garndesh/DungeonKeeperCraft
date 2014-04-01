package garndesh.dkc.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.RenderIds;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.tileentity.TileRoom;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRoomTile  extends Block implements ITileEntityProvider{
	
	public BlockRoomTile() {
		super(Material.rock);
		setBlockName(Strings.RESOURCE_PREFIX + Strings.BLOCK_ROOM_NAME);
        setCreativeTab(DungeonKeeperCraft.tabsBM);
        this.lightValue = 7;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileRoom();
	}
    
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override 
	public int getRenderType(){
		return RenderIds.roomRenderId;
	}

	@Override
	 public Item getItemDropped(int a, Random rand, int b){
        return null;
    }
}
