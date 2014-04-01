package garndesh.dkc.renderer.tileentity;

import garndesh.dkc.client.model.ModelDungeonHeart;
import garndesh.dkc.lib.RecourceLocations;
import garndesh.dkc.tileentity.TileDungeonHeart;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class RendererDungeonHeart extends TileEntitySpecialRenderer{

	private final ModelDungeonHeart modelHeart = new ModelDungeonHeart();
	private float tickCount = 0F;
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		//FMLLog.info("Rendering DungeonHeart");
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef((float) x +0.5F, (float) y-0.15F, (float) z+0.5F );
		this.bindTexture(RecourceLocations.HEART_BASE_TEXTURE);

		GL11.glScalef(0.8F, 0.8F, 0.8F);
		modelHeart.renderBase();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef((float) x +0.5F, (float) y+2F, (float) z+0.5F );
		this.bindTexture(RecourceLocations.HEART_TEXTURE);
		float size = ((TileDungeonHeart)tileEntity).getLife()/120.0F+0.2F;
		GL11.glScalef(0.8F*size, 0.8F*size, 0.8F*size);
		GL11.glRotatef(45, 1, 1, 1);
		tickCount += 1;
		GL11.glRotated(tickCount, 0.3, 1, -0.7);
		modelHeart.renderHeart();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef((float) x +0.5F, (float) y+2F, (float) z+0.5F );
		this.bindTexture(RecourceLocations.HEART_TEXTURE);
		GL11.glScalef(0.4F*size, 0.4F*size, 0.4F*size);
		GL11.glRotatef(45, 1, 1, 1);
		tickCount += 1;
		GL11.glRotated(tickCount, -0.6, -0.2, 0.7);
		modelHeart.renderHeart();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}

}
