package garndesh.dkc.tileentity;




import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;

public class TileDungeonHeart extends TileEntity{
	private float health;
	private String owner;
	private ChunkCoordinates[] dungeonTiles = new ChunkCoordinates[256];
	
	public TileDungeonHeart(){
		this.health = 100;
	}
	
	public void damageHeart(float damage){
		this.health -= damage;
		this.checkLife();
	}
	
	private void checkLife() {
		if(this.health <= 0){
			this.worldObj.getPlayerEntityByName(owner).setHealth(0);
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
	
	/**
	 * @param ChunkCoordinates of the new tile
	 * @return index the coords are stored.
	 */
	public int addDungeonTile(ChunkCoordinates coords){
		for (int i = 0; i < dungeonTiles.length; i++){
			if(dungeonTiles[i]==null){
				dungeonTiles[i] = coords;
				return i;
			}
		}
		return -1;
	}
	
	public void removeTile(int index){
		this.dungeonTiles[index] = null;
	}

	public int addDungeonTile(int x, int y, int z) {
		ChunkCoordinates coords = new ChunkCoordinates(x, y, z);
		return this.addDungeonTile(coords);
	}
}
