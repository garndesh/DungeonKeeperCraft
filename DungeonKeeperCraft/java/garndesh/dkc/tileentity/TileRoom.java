package garndesh.dkc.tileentity;


import java.util.Arrays;

import net.minecraft.tileentity.TileEntity;

public class TileRoom extends TileEntity {
	public final String roomTyps[] = {"path", "lair", "training", "library", "treasury"};
	private String roomType = "path";
	private String owner = "";
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

	public void setOwner(String owner) {
		this.owner = owner;
		if (owner == "") {
			this.roomColour = 0xFFFFFF;
		} else {
			//TODO make roomcolours owner dependent.
			this.roomColour = 0x00FF00;
		}
	}
	
	public int getRoomColour(){
		return this.roomColour;
	}
}
