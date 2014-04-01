package garndesh.dkc.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import garndesh.dkc.client.model.ModelDungeonHeart;
import garndesh.dkc.client.model.ModelOverlay;
import garndesh.dkc.lib.RecourceLocations;
import garndesh.dkc.tileentity.TileRoom;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RendererRoomTile extends TileEntitySpecialRenderer {

	private final ModelDungeonHeart modelHeart = new ModelDungeonHeart();
	private final ModelOverlay overlay = new ModelOverlay();
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float tick) {
		int colour = ((TileRoom)tile).getRoomColour();
		
		float r = (float)(colour >> 16 & 255) / 255.0F;
        float g = (float)(colour >> 8 & 255) / 255.0F;
        float b = (float)(colour & 255) / 255.0F;
		
        
		
        renderOveralyAt(x+0.5F, y+1F, z+0.5F, r, g, b);
        //renderHeartAt(x+0.5F, y+1.5F, z+0.5F, tick);

	}
	
	private void renderOveralyAt(double x, double y, double z, float r, float g, float b){
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float) x , (float) y, (float) z);
		GL11.glScalef(0.26F, 0.2F, 0.26F);
		GL11.glColor3f(r, g, b);
		overlay.render();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}
	
	private void renderHeartAt(double x, double y, double z, float tick) {
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef((float) x , (float) y, (float) z);
		GL11.glScalef(0.2F, 0.2F, 0.2F);
		GL11.glRotatef(45, 1, 1, 1);
		this.bindTexture(RecourceLocations.HEART_TEXTURE);
		modelHeart.renderHeart();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}
}