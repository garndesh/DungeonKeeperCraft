package garndesh.dkc.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.RenderIds;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.tileentity.TileDungeonHeart;
import garndesh.dkc.tileentity.TileRoom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		TileRoom tile = (TileRoom) world.getTileEntity(x, y, z);
		NBTTagCompound tag = player.getEntityData().getCompoundTag("HeartLocation");
		
		if (tile.getOwner() != "" || tag.getInteger("HeartY")!=0){
			tile.setOwner(player.getDisplayName());
			TileDungeonHeart heart = (TileDungeonHeart) world.getTileEntity(tag.getInteger("HeartX"), tag.getInteger("HeartY"), tag.getInteger("HeartZ"));
			tile.setTileId(heart.addDungeonTile(x, y, z));
		}
		return false;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta){
		TileRoom tile = (TileRoom) world.getTileEntity(x, y, z);
		tile.killTile();
		super.breakBlock(world, x, y, z, block, meta);
    }
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileRoom();
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override 
	public int getRenderType(){
		return 0;//RenderIds.roomRenderId;
	}

	@Override
	 public Item getItemDropped(int a, Random rand, int b){
        return null;
    }
}
