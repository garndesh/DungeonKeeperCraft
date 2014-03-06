package garndesh.dkc.tileentity;



import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileDungeonHeart extends TileEntity{
	private float health;
	
	public TileDungeonHeart(){
		this.health = 100;
	}
	
	public void damageHeart(float damage){
		this.health -= damage;
		this.checkLife();
	}
	
	private void checkLife() {
		if(this.health <= 0){
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
}
