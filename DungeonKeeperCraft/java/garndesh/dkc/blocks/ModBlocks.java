package garndesh.dkc.blocks;

import garndesh.dkc.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block basicBlock;
	public static Block blockDungeonHeart;
	public static Block blockFiller;
	public static Block blockRoom;
	
	public static void Init(){
		// Create blocks
		basicBlock = new BasicBlock();
		blockDungeonHeart = new BlockDungeonHeart();
		blockFiller = new BlockFiller();
		blockRoom = new BlockRoomTile();
		
		//Register Blocks with forge
		GameRegistry.registerBlock(basicBlock, "block."+Strings.BASIC_BLOCK_NAME);
		GameRegistry.registerBlock(blockDungeonHeart, "block."+Strings.BLOCK_DUNGEONHEART_NAME);
		GameRegistry.registerBlock(blockFiller, "block."+Strings.BLOCK_FILLER_NAME);
		GameRegistry.registerBlock(blockRoom, "block."+Strings.BLOCK_ROOM_NAME);
	}
}

