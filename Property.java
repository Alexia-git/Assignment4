
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;

	public Property() //initialize constructor
	{
		this.propertyName = "";
		this.city = "";
		this.rentAmount = 0.0;
		this.owner = "";
		this.plot = new Plot(); 
	}
	//constructors with param
	public Property(String propertyName, String city, double rentAmount, String owner) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(); 
	}
	// constructor with plot measurments 
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	//copy of property
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot); 
	}
	// Getter methods
	 public Plot getPlot() {
	        return plot;
	    }
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

 // Setter methods
    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
   



}
