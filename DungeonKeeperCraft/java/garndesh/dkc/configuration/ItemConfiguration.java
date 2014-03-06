package garndesh.dkc.configuration;

import garndesh.dkc.lib.Reference;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ItemConfiguration {
	protected static void init(File configFile)
    {

        Configuration itemConfiguration = new Configuration(configFile);

        try
        {
            itemConfiguration.load();
            
        }
        catch (Exception e)
        {
            FMLLog.severe(Reference.MOD_NAME + " has had a problem loading its block configuration");
        }
        finally
        {
            itemConfiguration.save();
        }
    }
}
