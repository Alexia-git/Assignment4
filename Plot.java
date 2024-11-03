
public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;

	public Plot() 
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	//getters methods
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	// Setter methods
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean overlaps(Plot plot) {

		int x2 = plot.getX();
	    int y2 = plot.getY();
	    int width2 = plot.getWidth();
	    int depth2 = plot.getDepth();
	    boolean horizLap = (this.x < (x2 + width2) && (this.x + this.width) > x2);
	    boolean verticalLap = (this.y < (y2 + depth2) && (this.y + this.depth) > y2);

	    
	    return horizLap && verticalLap;	
	    }

	public boolean encompasses(Plot plot) {
	 
	    if (plot.getX() < this.x) {
	        return false;
	    }
	    
	    if (plot.getY() < this.y) {
	        return false; 
	    }
	    
	    if ((plot.getX() + plot.getWidth()) > (this.x + this.width)) {
	        return false; 
	    }
	    
	    if ((plot.getY() + plot.getDepth()) > (this.y + this.depth)) {
	        return false;
	    }
	    
	
	    return true;
	}
	@Override
	public String toString() {
	    return x + "," + y + "," + width + "," + depth;
	}






}
