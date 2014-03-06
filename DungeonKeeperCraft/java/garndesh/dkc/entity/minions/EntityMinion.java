package garndesh.dkc.entity.minions;

import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityMinion extends EntityMob {

	public EntityMinion(World par1World) {
		super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.setHealth(5);
        this.setAIMoveSpeed(1.5F);
	}

}
