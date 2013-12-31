package garndesh.dkc.blocks;

import garndesh.dkc.lib.BlockIds;
import garndesh.dkc.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block basicBlock;
	
	public static void Init(){
		// Create blocks
		basicBlock = new BasicBlock(BlockIds.BASIC_BLOCK);
		
		//Register Blocks with forge
		GameRegistry.registerBlock(basicBlock, "block."+Strings.BASIC_BLOCK_NAME);
	}
}

