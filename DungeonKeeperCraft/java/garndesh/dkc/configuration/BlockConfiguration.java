package garndesh.dkc.configuration;

import garndesh.dkc.lib.Reference;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLLog;

public class BlockConfiguration {
	protected static void init(File configFile)
    {

        Configuration blockConfiguration = new Configuration(configFile);

        try
        {
            blockConfiguration.load();

            /* Block configs */
            //BlockIds.BASIC_BLOCK = blockConfiguration.getBlock(Strings.BASIC_BLOCK_NAME, BlockIds.BASIC_BLOCK_DEFAULT).getInt(BlockIds.BASIC_BLOCK_DEFAULT);
            
        }
        catch (Exception e)
        {
            FMLLog.severe(Reference.MOD_NAME + " has had a problem loading its block configuration");
        }
        finally
        {
            blockConfiguration.save();
        }
    }
}
