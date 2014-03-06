package garndesh.dkc.renderer.item;


import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import garndesh.dkc.client.model.ModelDungeonHeart;
import garndesh.dkc.lib.RecourceLocations;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemDungeonHeartRenderer implements IItemRenderer{

	private final ModelDungeonHeart modelDungeonHeart;

    public ItemDungeonHeartRenderer()
    {
    	modelDungeonHeart = new ModelDungeonHeart();
    }
    
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type)
        {
            case ENTITY:
            {
                renderDungeonHeart(-0.5F, -1.2F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
            	renderDungeonHeart(-0.2F, -0.85F, 0.8F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
            	renderDungeonHeart(-0.2F, -0.85F, 0.8F);
                return;
            }
            case INVENTORY:
            {
            	renderDungeonHeart(-1.0F, -1.675F, 0.0F);
                return;
            }
            default:
            {
            }
        }
		
	}

	private void renderDungeonHeart(float x, float y, float z) {
		GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(1.4F, 1.4F, 1.4F);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(-90F, 1F, 0, 0);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(RecourceLocations.HEART_MODEL);

        // Render
        modelDungeonHeart.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}

}
