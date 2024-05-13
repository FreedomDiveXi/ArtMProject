import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ArtCSVReader implements ArtReader{
	public ArtList load() throws CsvValidationException, IOException {
		ArtList arts = new ArtList();
		String type = FileConfig.getInstance().getReadFilename();
		char sep = FileConfig.myInstance.getReadSep();
		
		CSVParser parser = new CSVParserBuilder().withSeparator(sep).build();
		
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader(type)).withCSVParser(parser).withSkipLines(1).build();
			String[] nextLine = reader.readNext();
			while (nextLine != null) {
				Art art = readLine(nextLine);
				arts.add(art);
				nextLine = reader.readNext();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error reading the line within the file.");
			e.printStackTrace();
		}
		
		return arts;
	}
	
	/**
	 * read one art from a row within the field values
	 * This method expects a Scanner object associated with an open file
	 * 
	 * This method is meant to be called repetitively in order to read multiple arts from the file
	 * @param a String containing pipe delimited values for one art
	 * @return a Art object 
	 */
	public static Art readLine(String[] nextLine) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");	
		
		String artProgram = nextLine[0];
		String artYear = nextLine[1];
		String artTitle = nextLine[2];
		String artName = nextLine[3];
		String artPartner = nextLine[4];
		String artSiteLocation = nextLine[5];
		String artBorough = nextLine[6];
		String artSiteType = nextLine[7];
		String artProjectType = nextLine[8];
		String artInstallation = nextLine[9];
		String artRemoval = nextLine[10];
		String artLatitude = nextLine[11];
		String artLongitude = nextLine[12];
		
		int year = Integer.valueOf(artYear);
		
		ArtSiteTypes specificSite = enumeratingSite(artSiteType);
		ArtProjectTypes specificProject = enumeratingProject(artProjectType);
		
		String artFirstName, artLastName;
		int tempCounter = 0;
		int placeHolder = 0;
		for (int x = 0; x < artName.length()-1; x++) {
			if (artName.substring(x,x+1).equals(" ")) {
				tempCounter++;
				placeHolder = x;
			}
		}
		if (tempCounter == 0) {
			artFirstName = "NA";
			artLastName = artName;
		}
		else {
			artFirstName = artName.substring(0, placeHolder);
			artLastName = artName.substring(placeHolder+1);
		}
		
		LocalDate artInstall = LocalDate.parse(artInstallation, formatter);
		LocalDate artRemove;
		if (artRemoval.equals("EMPTY")) {
			artRemove = LocalDate.of(0, 1, 1);
		}
		else {
			artRemove = LocalDate.parse(artRemoval, formatter);
		}
		
		double artLat, artLong;
		if (artLatitude.equals("EMPTY")) {
			artLat = 0;
		}
		else {
			artLat = Double.parseDouble(artLatitude);;
		}
		if (artLongitude.equals("EMPTY")) {
			artLong = 0;
		}
		else {
			artLong = Double.parseDouble(artLongitude);;
		}
		
		Art art = new Art(artProgram, year, artTitle, artFirstName, artLastName, artPartner, artSiteLocation, artBorough, specificSite, specificProject, artInstall, artRemove, artLat, artLong);
		return art;
	}
	
	/**
	 * Enumerating method for site types
	 * @param artSiteType
	 * @return
	 */
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
	
	/**
	 * Enumerating method for project types
	 * @param artProjectType
	 * @return
	 */
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
