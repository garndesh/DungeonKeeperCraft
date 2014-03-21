package garndesh.dkc.Items;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.blocks.ModBlocks;
import garndesh.dkc.lib.DimensionIds;
import garndesh.dkc.lib.Strings;
import garndesh.dkc.world.DKTeleporter;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
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
			
			
			int  		 goDim 	= (player.dimension == 0)? DimensionIds.dimensionId : 0;
			WorldServer 	ws	= ((EntityPlayerMP) player).mcServer.worldServerForDimension(goDim);
			Teleporter teleport = new DKTeleporter(ws);
			// obviously make sure you are server side, then get the world server's default teleporter:
			if (player.dimension != 2){
				((EntityPlayerMP) player).mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 2, teleport);
			} else {
				((EntityPlayerMP) player).mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0, teleport);
			}
			//player.worldObj.get
			double x = player.worldObj.getSpawnPoint().posX+0.5;
			double z = player.worldObj.getSpawnPoint().posZ+0.5;
			int y = player.worldObj.getHeightValue((int)x,(int) z);
			y = (y <= 2)?10:y;
			player.setPositionAndUpdate(x, y + 1, z);
		}
		return itemStack;
	}
	
}
