package csd.uoc.gr.A21;


public class A21{

	public class SolidShape {
		private double X;
		private double Y;
		private double Z;
		
		public void setX(double X)throws IllegalArgumentException   {
			if(X < 0) throw new IllegalArgumentException ();
			this.X = X;
		}
		
		public double getX() {return this.X;}
		
		
		public void setY(double Y)throws IllegalArgumentException   {
			if(Y < 0) throw new IllegalArgumentException ();
			this.Y = Y;
		}
		
		public double getY() {return this.Y;}
		
		
		public void setZ(double Z)throws IllegalArgumentException   {
			if(Z < 0) throw new IllegalArgumentException ();
			this.Z = Z;
		}
		
		public double getZ() {return this.Z;}
		
		
		SolidShape(double X, double Y, double Z){setX(X); setY(Y); setZ(Z);}
		
		
		
		public int getNumberOfFaces() {return 0;}
		
		public int getNumberOfVertices() {return 0;}
		
		public int getNumberOfEdges() {return 0;}
		
		public double getVolume() {return 0d;}
		
		
		@Override
		public String toString() {
			return "Solid shape centered at ("
			+ this.getX() + "," + this.getY() + "," + this.getZ() + ") with\n" + 
			"faces   :" + this.getNumberOfFaces() + "\n" +
			"vertices:" + this.getNumberOfVertices() + "\n" +
			"edges   :" + this.getNumberOfEdges() + "\n" +
			"volume  :" + this.getVolume();
		}
	}
		
		
		//////////////////////////////////////////
		
	
	public class Sphere extends SolidShape{
		private double radius;
		
		public void setradius(double radius)throws IllegalArgumentException   {
			if(radius < 0) throw new IllegalArgumentException ();
			this.radius = radius;
		}
		
		public double getradius() {return this.radius;}
		
		
		Sphere(double X, double Y, double Z, double radius){
			super(X, Y, Z);
			this.setradius(radius);
		}
		
		
		@Override
		public int getNumberOfFaces() {return 1;}
		
		@Override
		public double getVolume() {return ((double)4/3 * Math.PI) * (Math.pow(radius, 3));}
		
		@Override
		public String toString() {
			return 
			"Sphere centered at ("
			+ this.getX() + "," + this.getY() + "," + this.getZ() + ") with\n" + 
			"faces   :" + this.getNumberOfFaces() + "\n" +
			"vertices:" + this.getNumberOfVertices() + "\n" +
			"edges   :" + this.getNumberOfEdges() + "\n" +
			"volume  :" + this.getVolume() + "\n" +
			"radius  :" + this.getradius();
		}	
	}
	
	
	///////////////////////////////
	
	
	public class Cube extends SolidShape{
		private double SIDE;
		
		public void setSide(double SIDE)throws IllegalArgumentException   {
			if(SIDE < 0) throw new IllegalArgumentException ();
			this.SIDE = SIDE;
		}
		
		public double getSide() {return this.SIDE;}
		
		
		Cube(double X, double Y, double Z, double SIDE){
			super(X, Y, Z);
			this.setSide(SIDE);
		}
		
		
		@Override
		public int getNumberOfFaces() {return 6;}
		
		@Override
		public int getNumberOfVertices() {return 8;}
		
		@Override
		public int getNumberOfEdges() {return 12;}
		
		@Override
		public double getVolume() {return Math.pow(SIDE, 3);}
		
		@Override
		public String toString() {
			return "Cube centered at ("
					+ this.getX() + "," + this.getY() + "," + this.getZ() + ") with\n" + 
					"faces   :" + this.getNumberOfFaces() + "\n" +
					"vertices:" + this.getNumberOfVertices() + "\n" +
					"edges   :" + this.getNumberOfEdges() + "\n" +
					"volume  :" + this.getVolume() + "\n" +
					"SIDE    :" + this.getSide();
		}
	}
	
	
	///////////////////////////////
	
	
	public class Cylinder extends SolidShape{
		private double RADIUS;
		private double HEIGHT;
		
		
		public void setRADIUS(double RADIUS)throws IllegalArgumentException   {
			if(RADIUS < 0) throw new IllegalArgumentException ();
			this.RADIUS = RADIUS;
		}
		
		public double getRADIUS() {return this.RADIUS;}
		
		public void setHEIGHT(double HEIGHT)throws IllegalArgumentException   {
			if(HEIGHT < 0) throw new IllegalArgumentException ();
			this.HEIGHT = HEIGHT;
		}
		
		public double getHEIGHT() {return this.HEIGHT;}
		
		
		Cylinder(double X, double Y, double Z, double RADIUS, double HEIGHT){
			super(X, Y, Z);
			this.setRADIUS(RADIUS);
			this.setHEIGHT(HEIGHT);
		}
		
		
		@Override
		public int getNumberOfFaces() {return 3;}
		
		@Override
		public int getNumberOfVertices() {return 0;}
		
		@Override
		public int getNumberOfEdges() {return 2;}
		
		@Override
		public double getVolume() {return Math.PI * Math.pow(this.getRADIUS(), 2) * this.getHEIGHT();}
		
		@Override
		public String toString() {
			return "Cylinder centered at ("
					+ this.getX() + "," + this.getY() + "," + this.getZ() + ") with\n" + 
					"faces   :" + this.getNumberOfFaces() + "\n" +
					"vertices:" + this.getNumberOfVertices() + "\n" +
					"edges   :" + this.getNumberOfEdges() + "\n" +
					"volume  :" + this.getVolume() + "\n" +
					"radius  :" + this.getRADIUS() + "\n" +
					"height  :" + this.getHEIGHT();
		}
	}
	
	
	///////////////////////////
	
	
	public class Drawing{
		SolidShape[] Shapes = new SolidShape[100];
		int activeCapacity = 0;
		
		
		void add(SolidShape s) throws ArrayIndexOutOfBoundsException{
			if(activeCapacity == 100)throw new ArrayIndexOutOfBoundsException();
				
			this.Shapes[activeCapacity] = s;
			activeCapacity++;
		}
		
		
		public String toString() {
			int facesSam = 0;
			int verticesSam = 0;
			int edgesSam = 0;
			double volumeSam = 0d;
			
			for(int i = 0; i < this.activeCapacity; i++) {
				facesSam += this.Shapes[i].getNumberOfFaces();
				verticesSam += this.Shapes[i].getNumberOfVertices();
				edgesSam += this.Shapes[i].getNumberOfEdges();
				volumeSam += this.Shapes[i].getVolume();
			}
			
			return 	"Number of shapes:" + activeCapacity + "\n" +
					"Total faces     :" + facesSam + "\n" +
					"Total vertices  :" + verticesSam + "\n" +
					"Total edges     :" + edgesSam + "\n" +
					"Total volume    :" + volumeSam;
		}
	}
	
	
		public static void main(String[] args) {
			A21 out = new A21();
			A21.Drawing draw1= out.new Drawing();
			A21.Drawing draw2= out.new Drawing();
			
			
			for(int j = 0; j< 50; j++) {
				A21.Sphere tempSh = out.new Sphere(1, 6, 7, j + 1);
				draw1.add(tempSh);
				if(j % 2 == 0) {
					A21.Sphere tempSp = out.new Sphere(1, 6, 7, j + 1);
					draw2.add(tempSp);
				}else {
					A21.Cube tempCu = out.new Cube(1, 6, 7, j + 1);
					draw2.add(tempCu);
				}
			}
			String s = "";
			s += "(c-i):\n" + draw1.toString() + "\n\n" + "(c-ii):\n" + draw2.toString();
			System.out.println(s);
			
			
//			System.out.println("(c-i):");
//			System.out.println(draw1);
//			System.out.println();
//			System.out.println("(c-ii):");
//			System.out.println(draw2);		
		}	
}

