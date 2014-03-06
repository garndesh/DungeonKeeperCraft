package garndesh.dkc.tileentity;

import garndesh.dkc.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {

	public static void Init() {
		GameRegistry.registerTileEntity(TileDungeonHeart.class, Strings.TILE_DUNGEONHEART_NAME);
		GameRegistry.registerTileEntity(TileFiller.class, Strings.TILE_FILLER_NAME);
	}


}
