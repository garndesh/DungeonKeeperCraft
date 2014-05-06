package garndesh.dkc.renderer.entity;

import garndesh.dkc.client.model.MinionModel;
import garndesh.dkc.entity.minions.EntityMinion;
import garndesh.dkc.lib.RecourceLocations;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderMinion extends RenderLiving {

	
	private static MinionModel minionModel = new MinionModel(); 
	
	public RenderMinion(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	
	@Override
	public void renderModel(EntityLivingBase entityLivingBase, float time, float maxAngle, float par4, float par5, float par6, float par7) {
		this.bindTexture(RecourceLocations.MINION_TEXTURE);
		minionModel.render((EntityMinion)entityLivingBase, time, maxAngle, par4, par5, par6, par7);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return RecourceLocations.MINION_TEXTURE;
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		this.renderMinion(par1EntityLiving, par2, par4, par6, par8, par9);
	}


	public void renderMinion(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityLiving, par2, par4, par6, par8, par9);	
	}

}
