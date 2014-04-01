package garndesh.dkc.blocks;


import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block{

	public BasicBlock() {
		super(Material.clay);
        
		//Sets the block hardness (time it takes to mine)
		setHardness(0.6F);
		
		//Sets the unlocalized name which gets replaced by the name from the selected language file
        setBlockName(Strings.RESOURCE_PREFIX + Strings.BASIC_BLOCK_NAME);
        
        //Sets the sound played when walked upon
        setStepSound(soundTypeGravel);
        
        //Add block to creativeTab
        setCreativeTab(DungeonKeeperCraft.tabsBM);
	}
}
