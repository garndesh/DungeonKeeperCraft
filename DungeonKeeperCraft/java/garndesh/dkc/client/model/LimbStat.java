package garndesh.dkc.client.model;

public class LimbStat {

	public String name;
	public float jointX;
	public float jointY;
	public float jointZ;
	
	public float rotX = 0;
	public float rotY = 0;
	public float rotZ = 0;
	

	public LimbStat(String name, float x, float y, float z){
		this.name = name;
		this.jointX = x;
		this.jointY = y;
		this.jointZ = z;
	}
	
	public void setRotation(float x, float y, float z){
		this.rotX = x;
		this.rotY = y;
		this.rotZ = z;
	}
}
