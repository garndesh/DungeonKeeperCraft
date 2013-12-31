package garndesh.dkc;

import garndesh.dkc.Items.ModItems;
import garndesh.dkc.blocks.ModBlocks;
import garndesh.dkc.configuration.ConfigurationHandler;
import garndesh.dkc.helper.LogHelper;
import garndesh.dkc.network.PacketHandler;
import garndesh.dkc.proxy.CommonProxy;
import garndesh.dkc.lib.Reference;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME)
@NetworkMod(channels = {Reference.CHANNEL_NAME}, clientSideRequired = true, 
							serverSideRequired = false, packetHandler = PacketHandler.class)
public class DungeonKeeperCraft {

	//Instance of the mod you are making
    @Instance(Reference.MOD_ID)
    public static DungeonKeeperCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    //Add a creative tab
    public static CreativeTabs tabsBM = new CreativeTabs(CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
    	
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // set version number
        event.getModMetadata().version = Reference.VERSION_NUMBER;

        // Initialize the log helper
        LogHelper.init();
        
        
        // Initialize the configuration{
        ConfigurationHandler.init(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME.toLowerCase() + File.separator);

        //Init blocks
        ModBlocks.Init();
        
        //Init Items
        ModItems.Init();
    }
    
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    	
    }
    
}
