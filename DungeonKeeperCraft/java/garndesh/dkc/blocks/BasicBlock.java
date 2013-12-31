package garndesh.dkc.blocks;


import garndesh.dkc.DungeonKeeperCraft;
import garndesh.dkc.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicBlock extends Block{

	public BasicBlock(int blockId) {
		super(blockId, Material.clay);
        
		//Sets the block hardness (time it takes to mine)
		setHardness(0.6F);
		
		//Sets the unlocalized name which gets replaced by the name from the selected language file
        setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.BASIC_BLOCK_NAME);
        
        //Sets the sound played when walked upon
        setStepSound(soundGravelFootstep);
        
        //Add block to creativeTab
        setCreativeTab(DungeonKeeperCraft.tabsBM);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}