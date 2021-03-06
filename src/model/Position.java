package model;

public class Position {
	
	private int x, y;
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
		// classe Position
	}
	public Position()
	{
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	public Position toPosition(String po){
		int x=Integer.parseInt(po.substring(12, po.indexOf(", y=")));
		int y=Integer.parseInt(po.substring(po.indexOf("y=")+2,po.indexOf("]")));
		Position position=new Position(x, y);
		return position;
	}
}
