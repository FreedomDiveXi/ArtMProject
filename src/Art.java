import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Art {
	private String program;
	private int year;
	private String title;
	private String firstName;
	private String lastName;
	private String partner;
	private String siteLocation;
	private String borough;
	private ArtSiteTypes siteType;
	private ArtProjectTypes projectType;
	private LocalDate installation;
	private LocalDate removal;
	private double latitude;
	private double longitude;
	
	/**
	 * constructor for art that took information from the file
	 * @param program
	 * @param year
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param partner
	 * @param siteLocation
	 * @param borough
	 * @param siteType
	 * @param projectType
	 * @param installation
	 * @param removal
	 * @param latitude
	 * @param longitude
	 */
	public Art(String program, int year, String title, String firstName, String lastName, String partner, String siteLocation, String borough, ArtSiteTypes siteType, ArtProjectTypes projectType, LocalDate installation, LocalDate removal, double latitude, double longitude) {
		this.program = program;
		this.year = year;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.partner = partner;
		this.siteLocation = siteLocation;
		this.borough = borough;
		this.siteType = siteType;
		this.projectType = projectType;
		this.installation = installation;
		this.removal = removal;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * getter method for program
	 * @return
	 */
	public String getProgram() {
		return program;
	}
	
	/**
	 * setter method for program
	 * @param program
	 */
	public void setProgram(String program) {
		this.program = program;
	}
	
	/**
	 * getter method for year
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * setter method for year
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 *  getter method for title
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * setter method for title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * getter method for firstName
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * setter method for firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * getter method for lastName
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setter method for lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getter method for partner
	 * @return
	 */
	public String getPartner() {
		return partner;
	}
	
	/**
	 * setter method for partner
	 * @param partner
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}
	
	/**
	 * getter method for siteLocation
	 * @return
	 */
	public String getSiteLocation() {
		return siteLocation;
	}
	
	/**
	 * setter method for siteLocation
	 * @param siteLocation
	 */
	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}
	
	/**
	 * getter method for borough
	 * @return
	 */
	public String getBorough() {
		return borough;
	}
	
	/**
	 * setter method for borough
	 * @param borough
	 */
	public void setBorough(String borough) {
		this.borough = borough;
	}
	
	/**
	 * getter method for siteType
	 * @return
	 */
	public ArtSiteTypes getSiteType() {
		return siteType;
	}
	
	/**
	 * setter method for siteType
	 * @param siteType
	 */
	public void setSiteType(ArtSiteTypes siteType) {
		this.siteType = siteType;
	}
	
	/**
	 * getter method for projectType
	 * @return
	 */
	public ArtProjectTypes getProjectType() {
		return projectType;
	}
	
	/**
	 * setter method for projectType
	 * @param projectType
	 */
	public void setProjectType(ArtProjectTypes projectType) {
		this.projectType = projectType;
	}
	
	/**
	 * getter method for installation
	 * @return
	 */
	public LocalDate getInstallation() {
		return installation;
	}
	
	/**
	 * setter method for installation
	 * @param installation
	 */
	public void setInstallation(LocalDate installation) {
		this.installation = installation;
	}
	
	/**
	 * getter method for removal
	 * @return
	 */
	public LocalDate getRemoval() {
		return removal;
	}
	
	/**
	 * setter method for removal
	 * @param removal
	 */
	public void setRemoval(LocalDate removal) {
		this.removal = removal;
	}
	
	/**
	 * getter method for latitude
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * setter method for latitude
	 * @param latitude
	 */
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * getter method for longitude
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * setter method for longitude
	 * @param longitude
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * toString method to express program, year, title, firstName, lastName, partner, siteLocation, borough, siteType, projectType, installation, removal, latitude, and longitude
	 */
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		return "\nProgram: " + program + ", Year: " + year + ", Title: " + title + ", First Name: " + firstName + ", Last Name: " + lastName + ", Partner: " + partner + ", Site Location: " + siteLocation + ", Borough: " + borough + ", Site Type: " + siteType + ", Project Type: " + projectType +  ", Installation: " + installation.format(formatter) + ", Removal: " + removal.format(formatter) + ", Latitude: " + latitude + ", Longitude: " + longitude;
	}
}
