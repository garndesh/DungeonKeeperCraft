package garndesh.dkc.tileentity;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileFiller extends TileEntity {
	//The coordinates of our primary block will be stored in these variables.
    public int primary_x;
    public int primary_y;
    public int primary_z;
   
    public void setCoords(int x, int y, int z){
    	FMLLog.info("adding filler data for %d %d %d", x, y, z);
    	this.primary_x = x;
    	this.primary_y = y;
    	this.primary_z = z;
    }
    
    public int getX(){
    	FMLLog.info("x= %d", this.primary_x);
    	return this.primary_x;
    }
    
    public int getY(){
    	FMLLog.info("y= %d", this.primary_y);
    	return this.primary_y;
    }
    
    public int getZ(){
    	FMLLog.info("z= %d", this.primary_z);
    	return this.primary_z;
    }
    @Override
	public void writeToNBT(NBTTagCompound tag){
	    tag.setInteger("px", primary_x);
	    tag.setInteger("py", primary_y);
	    tag.setInteger("pz", primary_z);
	    super.writeToNBT(tag);
	}
    
    @Override
	public void readFromNBT(NBTTagCompound tag){
    	if(tag.hasKey("px")){
	    	this.primary_x = tag.getInteger("px");
		    this.primary_y = tag.getInteger("py");
		    this.primary_z = tag.getInteger("pz");
    	}
	    super.readFromNBT(tag);
	}
}
