package garndesh.dkc.event;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import garndesh.dkc.lib.NBTTagNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class CostumEvents {
	/**
	* The key is the @ForgeSubscribe annotation and the cast of the Event you put in as argument.
	* The method name you pick does not matter. Method signature is public void, always.
	*/
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void BreakBlockEvent(BreakEvent event){
		EntityPlayer player = event.getPlayer();
		//FMLLog.info("breakBlock event triggered");
		if(player.getEntityData().hasKey(NBTTagNames.PP_HEARTLOCATION)){
			
			event.setCanceled(true);
		}
	}
}
