package garndesh.dkc.renderer.tileentity;

import garndesh.dkc.client.model.ModelDungeonHeart;
import garndesh.dkc.lib.RecourceLocations;
import garndesh.dkc.tileentity.TileDungeonHeart;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class RendererDungeonHeart extends TileEntitySpecialRenderer{

	private final ModelDungeonHeart modelHeart = new ModelDungeonHeart();
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		//FMLLog.info("Rendering DungeonHeart");
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glScalef(0.01F, 0.01F, 0.01F);
		GL11.glTranslatef((float) x +0.5F, (float) y, (float) z+0.5F );
		this.bindTexture(RecourceLocations.HEART_BASE_TEXTURE);
		//float size = ((TileDungeonHeart)tileEntity).getLife()/100.0F;
		//FMLLog.info("size = %f %f", size, 3.0F*size);
		//GL11.glScalef(3.0F*size, 3.0F*size, 3.0F*size);
		modelHeart.renderBase();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}

}
