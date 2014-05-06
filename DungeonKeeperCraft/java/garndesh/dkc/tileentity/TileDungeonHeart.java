package garndesh.dkc.tileentity;




import garndesh.dkc.lib.NBTTagNames;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldSettings.GameType;

public class TileDungeonHeart extends TileEntity{
	private float health;
	private String owner;
	
	public TileDungeonHeart(){
		this.health = 100;
	}
	
	public void damageHeart(float damage){
		this.health -= damage;
		this.checkLife();
	}
	
	private void checkLife() {
		if(this.health <= 0){
			try {
				EntityPlayer player = this.worldObj.getPlayerEntityByName(this.owner);
				NBTTagCompound tag = player.getEntityData();
				tag.removeTag(NBTTagNames.PP_HEARTLOCATION);
				player.setHealth(0);
				player.setGameType(GameType.ADVENTURE);
			} catch(NullPointerException e) {
				FMLLog.warning("NullPointerException @ heart death");
			}
			this.worldObj.setBlockToAir(xCoord, yCoord, zCoord);
		}
		
	}

	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
	   par1.setFloat("health", health);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
	   this.health = par1.getFloat("health");
	}

	public float getLife() {
		// TODO Auto-generated method stub
		return this.health;
	}

	public void setOwner(String name) {
		this.owner = name;		
	}
}
