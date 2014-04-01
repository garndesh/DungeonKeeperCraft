package garndesh.dkc.lib;

import net.minecraft.util.ResourceLocation;

public class RecourceLocations {
	
	private static final String mod = "dkc";
	private static final String model = "models/";
	private static final String texture = "textures/";
	public static final ResourceLocation MINION_TEXTURE = new ResourceLocation(mod,texture+"model/sphere.png");
	public static final ResourceLocation MINION_MODEL = new ResourceLocation(mod,model+"sphere.obj");
	
	public static final ResourceLocation HEART_MODEL = new ResourceLocation(mod,model+"dungeonHeart.obj");
	public static final ResourceLocation HEART_BASE_MODEL = new ResourceLocation(mod,model+"dungeonHeartBase.obj");
	public static final ResourceLocation OVERLAY_MODEL = new ResourceLocation(mod,model+"tileoverlay.obj");
	
	public static final ResourceLocation HEART_BASE_TEXTURE = new ResourceLocation(mod,texture+"model/dungeonHeartBase.png");
	public static final ResourceLocation HEART_TEXTURE = new ResourceLocation(mod,texture+"model/dungeonHeart.png");
	
	
	
}
