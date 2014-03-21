package garndesh.dkc.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DKTeleporter extends  Teleporter {

	public DKTeleporter(WorldServer world) {
		super(world);
	}
	
   @Override
   public void placeInPortal(Entity pEntity, double i, double j, double k, float p5) {
	   pEntity.setLocationAndAngles(i, j, k, pEntity.rotationYaw, 0.0F);
       pEntity.motionX = pEntity.motionY = pEntity.motionZ = 0.0D;
       return;
   }  

}
