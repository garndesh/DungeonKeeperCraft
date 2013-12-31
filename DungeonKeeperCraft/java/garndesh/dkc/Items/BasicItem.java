package garndesh.dkc.Items;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.BlockIds;
import garndesh.dkc.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicItem extends Item {

	public BasicItem(int itemId) {
		super(itemId);
		this.setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.BASIC_ITEM_NAME);
		this.setCreativeTab(DungeonKeeperCraft.tabsBM);
        maxStackSize = 12;
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
	
	//Special functions that are activated when the item is right clicked
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack,World world,EntityPlayer player){
		if(!world.isRemote){ //makes sure this is only done server side.
			int playerX = (int) player.posX;
			int playerY = (int) player.posY;
			int playerZ = (int) player.posZ;
			//LogHelper.info("Player at: "+playerX+" "+playerY+" "+playerZ);
			for(int i = 3; i<20; i++){
				world.setBlock(playerX+i, playerY, playerZ, BlockIds.BASIC_BLOCK);
				world.setBlock(playerX, playerY+i, playerZ, BlockIds.BASIC_BLOCK);
				world.setBlock(playerX, playerY, playerZ+i, BlockIds.BASIC_BLOCK);
				world.setBlock(playerX-i, playerY, playerZ, BlockIds.BASIC_BLOCK);
				world.setBlock(playerX, playerY-i, playerZ, BlockIds.BASIC_BLOCK);
				world.setBlock(playerX, playerY, playerZ-i, BlockIds.BASIC_BLOCK);
			}
		}
		return itemStack;
	}
	
}
