package garndesh.dkc.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import garndesh.dkc.client.model.ModelDungeonHeart;
import garndesh.dkc.lib.RecourceLocations;
import garndesh.dkc.tileentity.TileRoom;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RendererRoomTile extends TileEntitySpecialRenderer {

	private final ModelDungeonHeart modelHeart = new ModelDungeonHeart();
	
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float tick) {
		int colour = 0x00FF00;
		if (tile instanceof TileRoom){
			TileRoom roomtile = (TileRoom) tile;
			colour = roomtile.getRoomColour();
		}
		
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef((float) x +0.5F, (float) y+2F, (float) z+0.5F );
		
		GL11.glColor3b((byte)colour, (byte)(colour>>8), (byte)(colour>>16));
		GL11.glScalef(0.4F, 0.4F, 0.4F);
		GL11.glRotatef(45, 1, 1, 1);
		this.bindTexture(RecourceLocations.HEART_TEXTURE);
		modelHeart.renderHeart();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

	}

}
