package garndesh.dkc.client.model;

import cpw.mods.fml.common.FMLLog;
import garndesh.dkc.lib.RecourceLocations;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelDungeonHeart {
	private IModelCustom modelHeart;
	private IModelCustom modelHeartBase;
	private IModelCustom modelSphere;

    public ModelDungeonHeart()
    {
    	FMLLog.info("Loading model");
    	modelHeart = AdvancedModelLoader.loadModel(RecourceLocations.HEART_MODEL);
    	modelHeartBase = AdvancedModelLoader.loadModel(RecourceLocations.HEART_BASE_MODEL);
    	modelSphere = AdvancedModelLoader.loadModel(RecourceLocations.MINION_MODEL);
    }

    public void renderHeart()
    {
    	modelHeart.renderAll();
    }
    
    public void renderSphere(){
    	modelSphere.renderAll();
    }
    
    public void renderBase(){
    	modelHeartBase.renderAll();
    }
}
