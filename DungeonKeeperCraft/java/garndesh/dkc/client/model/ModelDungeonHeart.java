package garndesh.dkc.client.model;

import cpw.mods.fml.common.FMLLog;
import garndesh.dkc.lib.RecourceLocations;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelDungeonHeart {
	private IModelCustom modelHeart;

    public ModelDungeonHeart()
    {
    	FMLLog.info("Loading model");
    	modelHeart = AdvancedModelLoader.loadModel(RecourceLocations.HEART_MODEL);
    }

    public void render()
    {
    	modelHeart.renderAll();
    }
}
