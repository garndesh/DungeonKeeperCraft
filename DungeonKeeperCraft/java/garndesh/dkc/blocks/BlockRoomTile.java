package garndesh.dkc.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.tileentity.TileRoom;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRoomTile  extends Block implements ITileEntityProvider{
	
	public BlockRoomTile() {
		super(Material.rock);
		setBlockName(Strings.RESOURCE_PREFIX + Strings.BLOCK_ROOM_NAME);
        setCreativeTab(DungeonKeeperCraft.tabsBM);
        this.lightValue = 7;
        this.setHardness(2F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		TileRoom tile = (TileRoom) world.getTileEntity(x, y, z);
		//NBTTagCompound tag = player.getEntityData().getCompoundTag("HeartLocation");
		
		if (tile.getOwner() != ""){
			tile.setOwner(player.getDisplayName());
			//TileDungeonHeart heart = (TileDungeonHeart) world.getTileEntity(tag.getInteger("HeartX"), tag.getInteger("HeartY"), tag.getInteger("HeartZ"));
		}
		return false;
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
		return 0;
	}

	@Override
	 public Item getItemDropped(int a, Random rand, int b){
        return null;
    }
}
