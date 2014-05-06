package garndesh.dkc.client.model;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLLog;

import garndesh.dkc.entity.minions.EntityMinion;
import garndesh.dkc.lib.RecourceLocations;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class MinionModel extends ModelBase{
	private IModelCustom model;
	
	private LimbStat armLeft;
	private LimbStat armRight;
	
	private LimbStat head;
	
	private LimbStat legLeftBack;
	private LimbStat legLeftMiddle;
	private LimbStat legLeftFront;

	private LimbStat legRightBack;
	private LimbStat legRightMiddle;
	private LimbStat legRightFront;
	
	public MinionModel(){
		this.model = AdvancedModelLoader.loadModel(RecourceLocations.MINION_MODEL);
		this.textureHeight = 256;
		this.textureWidth = 256;
		
		armLeft = new LimbStat("ArmLeft", 0.235F, 0.28F+0.15F, -0.04F);
		armRight = new LimbStat("ArmRight", -0.235F, 0.28F+0.15F, -0.04F);

		legLeftBack = new LimbStat("legLeftBack", .109F, .1F, .119F );
		legLeftMiddle = new LimbStat("legLeftMiddle", .109F, .1F, 0.0F );
		legLeftFront = new LimbStat("legLeftFront", .109F, .1F, -.119F );

		legRightBack = new LimbStat("legRightBack", -.109F, .1F, .119F );
		legRightMiddle = new LimbStat("legRightMiddle", -.109F, .1F, 0.0F );
		legRightFront = new LimbStat("legRightFront", -.109F, .1F, -.119F );
		
		head = new LimbStat("Head", 0F, .55F, -.22F);
	}
	
	public MinionModel(IModelCustom model){
		this.model = model;
	}
	
	public void render(EntityMinion minion, float time, float maxAngle, float par4, float par5, float par6, float par7) {

		this.setRotationAngles(time, maxAngle, par4, par5, par6, par7, minion);
		GL11.glPushMatrix();
			GL11.glTranslatef(0, 1.5F, 0);
			model.renderPart("Body");
			model.renderOnly("LegLeftMiddle", "legRightMiddle");
			renderPartWithRotation(head);
			renderPartWithRotation(armRight);
			renderPartWithRotation(armLeft);
		GL11.glPopMatrix();

	}
	
	public void setRotationAngles(float time, float maxAngle, float par3, float headY, float headX, float par6, Entity par7Entity){

		float angle = MathHelper.cos(time * 0.6662F) * 2.0F * 35 * 0.5F;
		head.rotX = headX;
		head.rotY = headY;
		//FMLLog.info("HeadRotation %f %f", headX, headY);
		armRight.rotX = angle;
		armLeft.rotX = -angle;
    }
	/**
	 * Renders the model part defined by partName around point baseX, baseY, baseZ
	 * @param partName
	 * @param baseX
	 * @param baseY
	 * @param baseZ
	 * @param rotX
	 * @param rotY
	 * @param rotZ
	 */
	private void renderPartWithRotation(String partName, float baseX, float baseY, float baseZ, float rotX, float rotY, float rotZ){
		GL11.glPushMatrix();
		GL11.glTranslatef(baseX, -baseY, baseZ);	
		GL11.glRotatef(rotX, 1.0F, 0.0F, 0.0F);	
		GL11.glRotatef(rotY, 0.0F, 1.0F, 0.0F);	
		GL11.glRotatef(rotZ, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-baseX, baseY, -baseZ);
		model.renderPart(partName);
	GL11.glPopMatrix();
	}
	
	private void renderPartWithRotation(LimbStat limb){
		this.renderPartWithRotation(limb.name, limb.jointX, limb.jointY, limb.jointZ, limb.rotX, limb.rotY, limb.rotZ);
	}
	
}
