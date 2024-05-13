import java.util.Scanner;

public class ArtUI {
	private ArtList artList;
	private String artSite;
	private ArtSiteTypes artSiteEnum;
	private String artProject;
	private ArtProjectTypes artProjectEnum;
	
	private Scanner in = new Scanner(System.in);
	
	public ArtUI(ArtList artList) {
		this.artList = artList;
	}
	
	public void run() {
		String commandStr = readCommand();
		char command = commandStr.charAt(0);
		
		while (command != 'Q') {
			switch (command) {
				case '1':
					get200ArtPieces();
					break;
				case '2':
					getListWithSiteAndProject();
					break;
				case '3':
					getNumberOfBorough();
					break;
				case '4':
					getNumberOfInstallationYear();
					break;
				case '5':
					getNumberOfProjectType();
					break;
				default:
					System.out.println("Invalid command");
			}
			
			commandStr = readCommand();
			command = commandStr.charAt(0);
		}
		System.out.println("Bye!");
		in.close();
	}
	
	private void get200ArtPieces() {
		System.out.println("The first 200 Art Pieces that is sorted by year are " + artList.sortedByYear().toString());
	}
	
	private void getListWithSiteAndProject() {
		readSiteTypes();
		readProjectTypes();
		artSiteEnum = enumeratingSite(artSite);
		artProjectEnum = enumeratingProject(artProject);
		System.out.println("The list sorted by last name is " + artList.findSiteAndProjectType(artSiteEnum, artProjectEnum).toString());
	}
	
	private void getNumberOfBorough() {
		System.out.println("The number of art in each borough within the data set are " + artList.listOfBorough());
	}
	
	private void getNumberOfInstallationYear() {
		System.out.println("Enter a year between 2008 and 2021:");
		String year = in.nextLine();
		int x = Integer.parseInt(year);
		System.out.println("Within the year of " + x + artList.numberOfArtInSpecificYearInstalled(x) + " were installed.");
	}
	
	private void getNumberOfProjectType() {
		readProjectTypes();
		artProjectEnum = enumeratingProject(artProject);
		System.out.println("The number of projects of this type is " + artList.numberOfArtSpecificProjectType(artProjectEnum) + ".");
	}
	
	private String readCommand() {
		System.out.println();
		System.out.println("Please enter a command");
		System.out.println("1: 200 art pieces sorted by year");
		System.out.println("2: List of arts with your specified site and project type");
		System.out.println("3: Number of art pieces of each borough");
		System.out.println("4: Number of art pieces with your specified installation year");
		System.out.println("5: Number of art pieces with your specified project type");
		
		System.out.println("Q: quit");
		System.out.println(">>>>>>>");
		String command = in.nextLine().toUpperCase();
		return command;
	}
	
	private void readSiteTypes() {
		System.out.println(">>>>>>>");
		System.out.println("Please enter a site type:");
		System.out.println("Bridge");
		System.out.println("Pedestrian Street Light Pole");
		System.out.println("Plaza");
		System.out.println("SideWalk");
		System.out.println("Pedestrianized Asphalt Space");
		System.out.println("Roundabout");
		System.out.println("Street Seat");
		System.out.println("Barrier");
		System.out.println("Corrugated fence");
		System.out.println("Sidewalk Extension");
		System.out.println("Winter Seasonal Street");
		System.out.println("Street Light Pole");
		System.out.println("Bridge Wall");
		System.out.println("Step Street");
		System.out.println("Seasonal Street");
		System.out.println("Concrete Wall");
		System.out.println("Bridge Archway");
		System.out.println("Bike Share Station");
		System.out.println("Light Poles");
		System.out.println("Triangle");
		System.out.println("BusBulb");
		System.out.println("Median");
		System.out.println("Ferry Terminal");
		System.out.println("Comfort Station");
		System.out.println("Tunnel");
		System.out.println("Plaza Steps");
		System.out.println("Ferry Boat");
		System.out.println("Barrier/Sidewalk");
		System.out.println("Parking Meters");
		System.out.println("Viaduct");
		System.out.println("Subway Entrance");
		artSite = in.nextLine();
	}
	
	private void readProjectTypes() {
		System.out.println(">>>>>>>");
		System.out.println("Please enter a project type");
		System.out.println("Mural");
		System.out.println("Vinyl Wrap");
		System.out.println("Sculpture");
		System.out.println("Interactive Sculpture");
		System.out.println("Projection");
		System.out.println("Vinyl");
		System.out.println("Vinyl Panels");
		System.out.println("Ashpalt Mural");
		System.out.println("Art Display Cases");
		System.out.println("Painted Panels");
		System.out.println("Construction Fence Banner Wrap");
		System.out.println("Signage");
		System.out.println("Ground Vinyl");
		System.out.println("Vinyl Mural");
		System.out.println("Interactive");
		System.out.println("Light Projection");
		System.out.println("Installation");
		System.out.println("Intervention");
		System.out.println("Signage/Vinyl");
		System.out.println("Art Display Case");
		System.out.println("Banner");
		System.out.println("Flag");
		System.out.println("Mural/Sculpture");
		System.out.println("Mural/Interactive");
		artProject = in.nextLine();
	}
	
	public static ArtSiteTypes enumeratingSite(String artSiteType) {
		ArtSiteTypes siteTemp = null;
		
		switch (artSiteType) {
			case "Bridge":
				siteTemp = ArtSiteTypes.Bridge;
				break;
			case "Pedestrian Street Light Pole":
				siteTemp = ArtSiteTypes.PedestrianStreetLightPole;
				break;
			case "Plaza":
				siteTemp = ArtSiteTypes.Plaza;
				break;
			case "SideWalk":
				siteTemp = ArtSiteTypes.Sidewalk;
				break;
			case "Pedestrianized Asphalt Space":
				siteTemp = ArtSiteTypes.PedestrianizedAsphaltSpace;
				break;
			case "Roundabout":
				siteTemp = ArtSiteTypes.Roundabout;
				break;
			case "Street Seat":
				siteTemp = ArtSiteTypes.StreetSeat;
				break;
			case "Barrier":
				siteTemp = ArtSiteTypes.Barrier;
				break;
			case "Corrugated fence":
				siteTemp = ArtSiteTypes.CorrugatedFence;
				break;
			case "Sidewalk Extension":
				siteTemp = ArtSiteTypes.SidewalkExtension;
				break;
			case "Winter Seasonal Street":
				siteTemp = ArtSiteTypes.WinterSeasonalStreet;
				break;
			case "Street Light Pole":
				siteTemp = ArtSiteTypes.StreetLightPole;
				break;
			case "Bridge Wall":
				siteTemp = ArtSiteTypes.BridgeWall;
				break;
			case "Step Street":
				siteTemp = ArtSiteTypes.StepStreet;
				break;
			case "Seasonal Street":
				siteTemp = ArtSiteTypes.SeasonalStreet;
				break;
			case "Concrete Wall":
				siteTemp = ArtSiteTypes.ConcreteWall;
				break;
			case "Bridge Archway":
				siteTemp = ArtSiteTypes.BridgeArchway;
				break;
			case "Bike Share Station":
				siteTemp = ArtSiteTypes.BikeShareStation;
				break;
			case "Light Poles":
				siteTemp = ArtSiteTypes.LightPoles;
				break;
			case "Triangle":
				siteTemp = ArtSiteTypes.Triangle;
				break;
			case "BusBulb":
				siteTemp = ArtSiteTypes.BusBulb;
				break;
			case "Median":
				siteTemp = ArtSiteTypes.Median;
				break;
			case "Ferry Terminal":
				siteTemp = ArtSiteTypes.FerryTerminal;
				break;
			case "Comfort Station":
				siteTemp = ArtSiteTypes.ComfortStation;
				break;
			case "Tunnel":
				siteTemp = ArtSiteTypes.Tunnel;
				break;
			case "Plaza Steps":
				siteTemp = ArtSiteTypes.PlazaSteps;
				break;
			case "Ferry Boat":
				siteTemp = ArtSiteTypes.FerryBoat;
				break;
			case "Barrier/Sidewalk":
				siteTemp = ArtSiteTypes.BarrierSidewalk;
				break;
			case "Parking Meters":
				siteTemp = ArtSiteTypes.ParkingMeters;
				break;
			case "Viaduct":
				siteTemp = ArtSiteTypes.Viaduct;
				break;
			case "Subway Entrance":
				siteTemp = ArtSiteTypes.SubwayEntrance;
				break;
		}
		return siteTemp;
	}
	
	public static ArtProjectTypes enumeratingProject(String artProjectType) {
		ArtProjectTypes projectTemp = null;
		
		switch (artProjectType) {
			case "Mural":
				projectTemp = ArtProjectTypes.Mural;
				break;
			case "Vinyl Wrap":
				projectTemp = ArtProjectTypes.VinylWrap;
				break;
			case "Sculpture":
				projectTemp = ArtProjectTypes.Sculpture;
				break;
			case "Interactive Sculpture":
				projectTemp = ArtProjectTypes.InteractiveSculpture;
				break;
			case "Projection":
				projectTemp = ArtProjectTypes.Projection;
				break;
			case "Vinyl":
				projectTemp = ArtProjectTypes.Vinyl;
				break;
			case "Vinyl Panels":
				projectTemp = ArtProjectTypes.VinylPanels;
				break;
			case "Asphalt Mural":
				projectTemp = ArtProjectTypes.AsphaltMural;
				break;
			case "Art Display Cases":
				projectTemp = ArtProjectTypes.ArtDisplayCases;
				break;
			case "Painted Panels":
				projectTemp = ArtProjectTypes.PaintedPanels;
				break;
			case "Construction Fence Banner Wrap":
				projectTemp = ArtProjectTypes.ConstructionFenceBannerWrap;
				break;
			case "Signage":
				projectTemp = ArtProjectTypes.Signage;
				break;
			case "Ground Vinyl":
				projectTemp = ArtProjectTypes.GroundVinyl;
				break;
			case "Vinyl Mural":
				projectTemp = ArtProjectTypes.VinylMural;
				break;
			case "Interactive":
				projectTemp = ArtProjectTypes.Interactive;
				break;
			case "Light Projection":
				projectTemp = ArtProjectTypes.LightProjection;
				break;
			case "Installation":
				projectTemp = ArtProjectTypes.Installation;
				break;
			case "Intervention":
				projectTemp = ArtProjectTypes.Intervention;
				break;
			case "Signage/Vinyl":
				projectTemp = ArtProjectTypes.SignageVinyl;
				break;
			case "Art Display Case":
				projectTemp = ArtProjectTypes.ArtDisplayCase;
				break;
			case "Banner":
				projectTemp = ArtProjectTypes.Banner;
				break;
			case "Flag":
				projectTemp = ArtProjectTypes.Flag;
				break;
			case "Mural/Sculpture":
				projectTemp = ArtProjectTypes.MuralSculpture;
				break;
			case "Mural/Interactive":
				projectTemp = ArtProjectTypes.MuralInteractive;
				break;
		}
		return projectTemp;
	}
}
