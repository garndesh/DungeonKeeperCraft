package garndesh.dkc.world;

import garndesh.dkc.lib.DimensionIds;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistration {
	
	public static void init(){

        DimensionManager.registerProviderType(DimensionIds.dimensionId, WorldProviderDungeon.class, false);
        DimensionManager.registerDimension(DimensionIds.dimensionId, DimensionIds.dimensionId);
	}
}
