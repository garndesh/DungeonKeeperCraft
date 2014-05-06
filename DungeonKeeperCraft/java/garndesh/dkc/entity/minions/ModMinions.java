package garndesh.dkc.entity.minions;

import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.Strings;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModMinions {
	public static void Init(){
		//Register minions
		EntityRegistry.registerGlobalEntityID(EntityMinion.class, Strings.DKC_MINION_NAME, EntityRegistry.findGlobalUniqueEntityId(), 0x112233, 0x665544);
		EntityRegistry.registerModEntity(EntityMinion.class, Strings.DKC_MINION_NAME, 1, DungeonKeeperCraft.instance, 20, 5, false);
	}
}
