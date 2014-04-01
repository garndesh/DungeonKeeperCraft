package garndesh.dkc.Items;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.blocks.ModBlocks;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.tileentity.TileDungeonHeart;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class HeartStaff extends Item{

	public HeartStaff() {
		super();
		this.setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.HEART_STAFF_NAME);
		this.setCreativeTab(DungeonKeeperCraft.tabsBM);
        maxStackSize = 1;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack,World world,EntityPlayer player){
		if(!world.isRemote){ //makes sure this is only done server side.
			NBTTagCompound tag = player.getEntityData();
			NBTTagCompound HeartLocation = tag.getCompoundTag("HeartLocation");
			if (HeartLocation.getInteger("HeartX") != 0) {
				//player.addChatMessage("Player Heart @ " + HeartLocation.getInteger("HeartX") + " " + HeartLocation.getInteger("HeartZ"));
				FMLLog.info("Player already has a heart");
			} else {
				int x = player.getPlayerCoordinates().posX;
				int y = 2;
				int z = player.getPlayerCoordinates().posZ;
				HeartLocation.setInteger("HeartX", x);
				HeartLocation.setInteger("HeartY", y);
				HeartLocation.setInteger("HeartZ", z);
				
				world.setBlock(x, y, z, ModBlocks.blockDungeonHeart);
				TileDungeonHeart tile = (TileDungeonHeart) world.getTileEntity(x, y, z);
				tile.setOwner(player.getDisplayName());
			}

			tag.setTag("HeartLocation", HeartLocation);
		}
		return itemStack;
	}
}
