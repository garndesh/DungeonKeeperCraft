package garndesh.dkc;

import garndesh.dkc.Items.ModItems;
import garndesh.dkc.blocks.ModBlocks;
import garndesh.dkc.configuration.ConfigurationHandler;
import garndesh.dkc.entity.minions.ModMinions;
import garndesh.dkc.proxy.CommonProxy;
import garndesh.dkc.tileentity.TileDungeonHeart;
import garndesh.dkc.tileentity.TileEntities;
import garndesh.dkc.world.WorldProviderDungeon;
import garndesh.dkc.world.WorldTypeDungeon;
import garndesh.dkc.lib.Reference;
import garndesh.dkc.lib.Strings;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME)
public class DungeonKeeperCraft {

	//Instance of the mod you are making
    @Instance(Reference.MOD_ID)
    public static DungeonKeeperCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    public static final WorldType Dungeon = new WorldTypeDungeon("Dungeon");
    

    public static final int dimensionId = DimensionManager.getNextFreeDimId();
    
    //Add a creative tab
    public static CreativeTabs tabsBM = new CreativeTabs(Reference.MOD_ID){
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return ModItems.basicItem;
        }
    };

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
    	
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        // set version number
        event.getModMetadata().version = Reference.VERSION_NUMBER;
        
        // Initialize the configuration{
        ConfigurationHandler.init(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME.toLowerCase() + File.separator);

        //Init blocks
        ModBlocks.Init();
        
        //Init Items
        ModItems.Init();
        
        ModMinions.Init();
        
    }
    
    
    @EventHandler
    public void Init(FMLInitializationEvent event){
        TileEntities.Init();       
        
        proxy.registerRenderers();
        
        DimensionManager.registerProviderType(dimensionId, WorldProviderDungeon.class, false);
        DimensionManager.registerDimension(dimensionId, dimensionId);
    	
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event){
    	
    }
    
}
