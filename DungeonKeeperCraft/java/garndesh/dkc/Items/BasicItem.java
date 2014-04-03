package garndesh.dkc.Items;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.blocks.ModBlocks;
import garndesh.dkc.lib.Strings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicItem extends Item {

	public BasicItem() {
		super();
		this.setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.BASIC_ITEM_NAME);
		this.setCreativeTab(DungeonKeeperCraft.tabsBM);
        maxStackSize = 12;
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
	
	//Special functions that are activated when the item is right clicked
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack,World world,EntityPlayer player){
		if(!world.isRemote){ //makes sure this is only done server side.
			player.capabilities.allowFlying = ! player.capabilities.allowFlying;
			player.capabilities.allowEdit = !player.capabilities.allowEdit;
			FMLLog.info("allowFlying = %s", player.capabilities.allowFlying);
			player.sendPlayerAbilities(); 
		}
		return itemStack;
	}
	
}
