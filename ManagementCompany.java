public class ManagementCompany 
{

	
	public static final int MAX_PROPERTY = 5; 
	public static final int MGMT_WIDTH = 10;   
	public static final int MGMT_DEPTH = 10; 

	private String name;                 
	private String taxID;                  
	private double mgmFee;                 
	private Property[] properties;          
	private Plot plot;                     
	private int numOfProperties; 

	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH); 
		this.properties = new Property[MAX_PROPERTY];
		this.numOfProperties = 0;
	}

	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numOfProperties = 0;
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
		numOfProperties = 0; 
	}
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
		this.numOfProperties = otherCompany.numOfProperties;
	}
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		if(numOfProperties == MAX_PROPERTY) {
			return -1;
		}

		Property baseproperty = new Property(propertyName, city, rent, ownerName);
		properties[numOfProperties] = baseproperty;
		numOfProperties++;
		if (baseproperty == null)
			return -2;

		return numOfProperties-1;
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{

		if (numOfProperties == MAX_PROPERTY) {
			return -1; // Array is full
		}

		//
		Property baseproperty = new Property(name, city, rent, owner, x, y, width, depth);

		if(!plot.encompasses(baseproperty.getPlot()))
		{
			return -3;
		}


		if (baseproperty == null)
			return -2;


		for(int i = 0; i < numOfProperties; i++)
		{
			if(properties[i].getPlot().overlaps(baseproperty.getPlot())) 
			{
				return -4;
			}
		}
		properties[numOfProperties] = baseproperty;
		numOfProperties++;

		return numOfProperties - 1; 
	}
	public int addProperty(Property property)
	{
		if (property == null) {
			return -2;
		}

		if (!plot.encompasses(property.getPlot())) { 
			return -3;
		}

		for(int i = 0; i <numOfProperties ; i++) {
			if(property.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}

		Property baseproperty = new Property(property);

		properties[numOfProperties] = baseproperty;
		numOfProperties++;

		return numOfProperties-1;


	}
	public void removeLastProperty() {
		if (numOfProperties > 0) {
			properties [--numOfProperties] = null; 
		}
	}
	public boolean isPropertiesFull() 
	{
		return numOfProperties >= MAX_PROPERTY;
	}

	public int getPropertiesCount() {
		return numOfProperties; 
	}
	public double getTotalRent() {
		double total = 0.0;
		for (int i = 0; i < numOfProperties; i++) {
			if (properties[i] != null) {
				total += properties[i].getRentAmount(); 
			}
		}
		return total; 
	}
	public Property getHighestRentProperty() {
		if (numOfProperties == 0)
			return null; 

		Property highest = properties[0]; 

		for (int i = 1; i < numOfProperties; i++)
		{ 
			if (properties[i].getRentAmount() > highest.getRentAmount()) 
			{
				highest = properties[i]; 
			}
		}

		return highest; 

	}

	public boolean isManagementFeeValid() {
		return mgmFee > 0 && mgmFee <= 100; 
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public double getMgmFeePer() {
		return mgmFee;
	}

	public Plot getPlot() {
		return plot;
	}


	@Override
	public String toString() {
	    String result = "List of the Properties for " + name + ", TaxID: " + taxID + "\n" +
	                    "______________________________________________________\n";

	    for (int i = 0; i < numOfProperties; i++) {
	        result += properties[i].getPropertyName() +","+
	                  properties[i].getCity() +"," +
	                   properties[i].getOwner() +","+
	                   properties[i].getRentAmount() + "\n";
	    }

	    result += "______________________________________________________\n" +"\n"+
	    	" total management Fee: " +(getTotalRent() * (getMgmFeePer() / 100)) ;

	    return result;
	}


}