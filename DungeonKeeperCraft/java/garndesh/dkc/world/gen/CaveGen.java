package garndesh.dkc.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class CaveGen {
	
	private Random rand;
	private World worldObj;
	private long seed;
	private int tendrilCount;
	private int rotation;
	
	
	public CaveGen(World world){
		this.worldObj = world;
		this.seed = this.worldObj.getSeed();
		this.rand = new Random(this.seed);
		//this.tendrilCount = 7+rand.nextInt(5);
		//this.rotation = rand.nextInt(20);
		//FMLLog.info("TendrilCount = %d", tendrilCount);
	}
	
	private float[][] generateEdges(int chunkX, int chunkZ){
		float[][] tmp = new float[4][16];
		for(int a = -2; a<2; a++){
			if (a%2 == 0){
				rand.setSeed(124156*(chunkX+(a+1)*8)+2349357*(chunkZ));
			} else {
				rand.setSeed(124156*(chunkX)+2349357*(chunkZ+a*8));
			}
			double location = 8+rand.nextGaussian()*4;
			
			if( location>3 && location<13){
				tmp[a+2][(int) Math.round(location) -2] = 0.25F;
				tmp[a+2][(int) Math.round(location) -1] = 0.5F;
				tmp[a+2][(int) Math.round(location)   ] = 1;
				tmp[a+2][(int) Math.round(location) +1] = 0.5F;
				tmp[a+2][(int) Math.round(location) +2] = 0.25F;
			}
		}
		return tmp;
	}
	
	public void generateCaves(int chunkX, int chunkZ, Block[] blocks){
		float[][] edges = this.generateEdges(chunkX, chunkZ);
		
		float[] caves = new float[16*16];
		for( int x = 0; x<16; x++){
			for(int z = 0; z<16; z++){
				float average = edges[0][z]*(16-x)/16 + edges[2][z]*(x)/16 + edges[1][x]*(16-z)/16 + edges[3][x]*(z)/16;
				caves[x*16+z] = 1-average/2;
			}
		}

		for (int x = 0; x<16; x++){
			for (int z= 0; z<16; z++){
				if (caves[x*16+z] < 0.8){
					if(blocks[((x*16)+z)*256 +2] ==  Block.getBlockFromName("stone")){
						blocks[((x*16)+z)*256 +2] = Block.getBlockFromName("air");
						blocks[((x*16)+z)*256 +3] = Block.getBlockFromName("air");
						blocks[((x*16)+z)*256 +4] = Block.getBlockFromName("air");
					}
				}
			}
		}
	}
	
	
	
	public void generateCaves_lessOld(int chunkX, int chunkZ, Block[] blocks){
		float[] caves = new float[16*16];
		int size = 8;
		for( int i = 0; i<16; i+=size){
			for(int j = 0; j<16; j+=size){
				rand.setSeed(chunkX*16+i+1342*(chunkZ*16+j));
				float lb = rand.nextFloat();
				rand.setSeed(chunkX*16+i+1342*(chunkZ*16+size+j));
				float rb = rand.nextFloat();
				rand.setSeed(chunkX*16+i+size+1342*(chunkZ*16+j));
				float lt = rand.nextFloat();
				rand.setSeed(chunkX*16+i+size+1342*(chunkZ*16+size+j));
				float rt = rand.nextFloat();
				
				for(int x = 0;x<size; x++){
					float xr = rb+ x*(rb-rt)/size;
					float xl = lb+ x*(lb-lt)/size;
					for (int z = 0; z<size;z++){
						caves[(i+x)*16+z+j] = xl+z*(xl-xr)/size;
					}
				}	
			}
		}
		for (int x = 0; x<16; x++){
			for (int z= 0; z<16; z++){
				if (caves[x*16+z] < 0.2){
					if(blocks[((x*16)+z)*256 +2] ==  Block.getBlockFromName("stone")){
						blocks[((x*16)+z)*256 +2] = Block.getBlockFromName("air");
						blocks[((x*16)+z)*256 +3] = Block.getBlockFromName("air");
						blocks[((x*16)+z)*256 +4] = Block.getBlockFromName("air");
					}
				}
			}
		}
	}
	
	
	
	public void generateCaves_old(int chunkX, int chunkZ, Block[] blocks){
		
		for (int tendrilNr = 1; tendrilNr < tendrilCount+1; tendrilNr++){
			this.rand.setSeed(this.seed+tendrilNr*230094);
			int tendrilLength = 40+rand.nextInt(40);
			double angle = 2*Math.PI*tendrilNr/tendrilCount+ 0.3; 
			//FMLLog.info("angle %f", (float)angle);
			int xMax = (int) Math.max(0, tendrilLength*Math.cos(angle));
			int xMin = (int) Math.min(0, tendrilLength*Math.cos(angle));
			if (chunkX*16>=xMin && chunkX*16+15<=xMax){
				for (int x = 0; x<16; x++){
					int globalZ =(int)( (chunkX*16+x) * Math.tan(angle));
					for (int i = -1; i < 2; i++){
						int Z = globalZ+i; 
						if ( Z >= chunkZ*16 && Z <= chunkZ*16+15){
							int z = Z%16;
							if(z< 0) z += 16;
							blocks[((x*16)+z)*256 +2] = Block.getBlockFromName("air");
							blocks[((x*16)+z)*256 +3] = Block.getBlockFromName("air");
							blocks[((x*16)+z)*256 +4] = Block.getBlockFromName("air");
							//blocks[((x*16)+z)*256 +y] = Block.getBlockFromName("air");
						}
					}
				}
			}
			
		}
	}
}
