package garndesh.dkc.tileentity;


import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileRoom extends TileEntity {
	public final String roomTyps[] = {"path", "lair", "training", "library", "treasury"};
	private String roomType = "path";
	private String owner = "";
	private int tileId;
	private int roomColour = 0xFFFFFF;
	
	public void setRoomType(String roomType){
		if (Arrays.binarySearch(this.roomTyps, roomType) <= 0){
			this.roomType = roomType;
		}
	}
	
	public String getRoomType(){
		return this.roomType;
	}

	public String getOwner() {
		return owner;
	}

	public void killTile(){
		EntityPlayer player = this.worldObj.getPlayerEntityByName(owner);
		NBTTagCompound tag = player.getEntityData().getCompoundTag("HeartLocation");
		TileDungeonHeart heart = (TileDungeonHeart) this.worldObj.getTileEntity(tag.getInteger("HeartX"), tag.getInteger("HeartY"), tag.getInteger("HeartZ"));
		heart.removeTile(tileId);
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
		if (owner == "") {
			this.roomColour = 0xFFFFFF;
		} else {
			//TODO make roomcolours owner dependent.
			this.roomColour = 0x55FF00;
		}
	}
	
	public void setTileId(int id){
		this.tileId = id;
	}
	
	public int getRoomColour(){
		return this.roomColour;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		this.owner = tag.getString("owner");
		this.roomColour = tag.getInteger("colour");
		this.roomType = tag.getString("roomType");
		this.tileId = tag.getInteger("tileId");
        super.readFromNBT(tag);
    }
	
	@Override
	public void writeToNBT(NBTTagCompound tag){
		tag.setInteger("tileId", this.tileId);
		tag.setInteger("colour", this.roomColour);
		tag.setString("owner", this.owner);
		tag.setString("roomType", this.roomType);
	}
	
}
