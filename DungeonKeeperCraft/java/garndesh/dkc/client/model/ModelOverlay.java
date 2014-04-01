package garndesh.dkc.client.model;

import garndesh.dkc.lib.RecourceLocations;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelOverlay {
	private IModelCustom modelOverlay;
	
	public ModelOverlay(){
		this.modelOverlay = AdvancedModelLoader.loadModel(RecourceLocations.OVERLAY_MODEL);
	}
	
	public void render()
    {
		modelOverlay.renderAll();
    }
}
