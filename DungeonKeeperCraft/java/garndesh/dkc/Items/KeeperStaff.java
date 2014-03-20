package garndesh.dkc.Items;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.blocks.ModBlocks;
import garndesh.dkc.lib.Strings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KeeperStaff extends Item {

	public KeeperStaff() {
		super();
		this.setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KEEPER_STAFF_NAME);
		this.setCreativeTab(DungeonKeeperCraft.tabsBM);
        maxStackSize = 1;
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
			// obviously make sure you are server side, then get the world server's default teleporter:
			if (player.dimension != 2){
				((EntityPlayerMP) player).mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 2, ((WorldServer) world).getDefaultTeleporter());
			} else {
				((EntityPlayerMP) player).mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0, ((WorldServer) world).getDefaultTeleporter());
			}
			
			player.setPositionAndUpdate(player.worldObj.getSpawnPoint().posX, player.worldObj.getSpawnPoint().posY + 1, player.worldObj.getSpawnPoint().posZ);
			// get the height value so you don't get stuck in solid blocks or worse, in the void
			//double dy = player.worldObj.getHeightValue(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posZ));

			// still seem to need to set the position, +1 so you don't get in the void
			//player.setPositionAndUpdate(player.posX, dy + 1, player.posZ);
		}
		return itemStack;
	}
	
}
