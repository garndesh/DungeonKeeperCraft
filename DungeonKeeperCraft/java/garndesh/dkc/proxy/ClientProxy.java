package garndesh.dkc.proxy;

import garndesh.dkc.client.model.MinionModel;
import garndesh.dkc.entity.minions.EntityMinion;
import garndesh.dkc.lib.RenderIds;
import garndesh.dkc.renderer.entity.RenderMinion;
import garndesh.dkc.renderer.tileentity.RendererDungeonHeart;
import garndesh.dkc.renderer.tileentity.RendererRoomTile;
import garndesh.dkc.tileentity.TileDungeonHeart;
import garndesh.dkc.tileentity.TileRoom;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
    public void registerRenderers() {
		//FMLLog.info("registering renderers");
        // This is for rendering entities and so forth later on
		RenderingRegistry.registerEntityRenderingHandler(EntityMinion.class, new RenderMinion(new MinionModel(), 0.6F)); 
		
		RenderIds.dungeonHeartRenderId = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileDungeonHeart.class, new RendererDungeonHeart());
		
		RenderIds.roomRenderId = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileRoom.class, new RendererRoomTile());
    }
	
}
