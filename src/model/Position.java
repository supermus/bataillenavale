package model;

public class Position implements Comparable<Position>{

	private int x, y;

	/**
	 * Constructeur principal de position
	 * @param x Coordonn�e X
	 * @param y Coordonn�e Y
	 */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructeur par d�faut de Position (0;0)
	 */
	public Position()
	{
		this.x = this.y = 0;
	}

	/**
	 * Coordonn�e X
	 * @return retourne la coordonn�e X
	 */
	public int getX() {
		return x;
	}

	/**
	 * D�finit la coordonn�e X
	 * @param x Coordonn�e X
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Coordonn�e Y
	 * @return retourne la coordonn�e Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * D�finit la coordonn�e Y
	 * @param y Coordonn�e Y
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	/**
	 * V�rifie si cette position est �gale � un autre position
	 * @param p Position � tester
	 * @return true si �gal, false sinon.
	 */
	public boolean equals(Position p)
	{
		return (this.x == p.getX() && this.y == p.getY());
	}

	@Override
	public int compareTo(Position pos) {
		if(x == pos.getX() && y == pos.getY()) {
			return 0;
		} else {
			return 1;
		}
	}
}
