package garndesh.dkc.configuration;

import garndesh.dkc.lib.ItemIds;
import garndesh.dkc.lib.Reference;
import garndesh.dkc.lib.Strings;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ItemConfiguration {
	protected static void init(File configFile)
    {

        Configuration itemConfiguration = new Configuration(configFile);

        try
        {
            itemConfiguration.load();

            /* Block configs */
            ItemIds.BASIC_ITEM = itemConfiguration.getBlock(Strings.BASIC_ITEM_NAME, ItemIds.BASIC_ITEM_DEFAULT).getInt(ItemIds.BASIC_ITEM_DEFAULT);
            
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its block configuration");
        }
        finally
        {
            itemConfiguration.save();
        }
    }
}
