package garndesh.dkc.Items;

import garndesh.dkc.lib.Strings;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item basicItem;
	
	public static void Init(){
		//Create Items
		basicItem = new BasicItem();
		
		//Register Items with forge
		GameRegistry.registerItem(basicItem, "item."+Strings.BASIC_ITEM_NAME);
	}
}
