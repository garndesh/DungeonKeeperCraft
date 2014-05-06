package garndesh.dkc.entity.minions;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMinion extends EntityMob {

	public EntityMinion(World par1World) {
		super(par1World);
        //this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        //this.tasks.addTask(8, new EntityAILookIdle(this));
        this.setHealth(5);
        this.height = 0.4F;
        
	}
	
	@Override
    protected boolean isAIEnabled(){
        return true;
    }

}
