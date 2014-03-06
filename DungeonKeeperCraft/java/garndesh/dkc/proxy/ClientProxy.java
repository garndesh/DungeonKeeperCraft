package garndesh.dkc.proxy;

import garndesh.dkc.client.model.MinionModel;
import garndesh.dkc.entity.minions.EntityMinion;
import garndesh.dkc.lib.RenderIds;
import garndesh.dkc.renderer.entity.RenderMinion;
import garndesh.dkc.renderer.tileentity.RendererDungeonHeart;
import garndesh.dkc.tileentity.TileDungeonHeart;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;

public class ClientProxy extends CommonProxy {
	
	@Override
    public void registerRenderers() {
		FMLLog.info("registering renderers");
        // This is for rendering entities and so forth later on
		RenderingRegistry.registerEntityRenderingHandler(EntityMinion.class, new RenderMinion(new MinionModel(), 0.6F)); 
		
		RenderIds.dungeonHeartRenderId = RenderingRegistry.getNextAvailableRenderId();
		//MinecraftForgeClient.registerItemRenderer(ModBlocks, new ItemDungeonHeartRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileDungeonHeart.class, new RendererDungeonHeart());
    }
	
}
