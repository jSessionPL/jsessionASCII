package pl.noip.piekaa.jsession.ascii;

public class AreaInfo 
{	
	private boolean isEndl;
	private int[][] area;
	public AreaInfo(boolean isEndl, int[][] area) {
		super();
		this.isEndl = isEndl;
		this.area = area;
	}
	public boolean isEndl() {
		return isEndl;
	}
	public int[][] getArea() {
		return area;
	}
	
	
	

}
