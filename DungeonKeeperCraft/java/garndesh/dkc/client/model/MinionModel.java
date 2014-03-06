package garndesh.dkc.client.model;

import garndesh.dkc.lib.RecourceLocations;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class MinionModel extends ModelBase{
	private IModelCustom model;
	
	public MinionModel(){
		this.model = AdvancedModelLoader.loadModel(RecourceLocations.MINION_MODEL);
	}
	
	public void render(){
		model.renderAll();
	}
}
