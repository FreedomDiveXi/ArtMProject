import java.util.ArrayList;
import java.util.Collections;

public class ArtList {
	private ArrayList<Art> artList;
	
	/**
	 * constructor for artlist creating a new arraylist of art
	 */
	public ArtList() {
		artList = new ArrayList<Art>();
	}
	
	/**
	 * method to add an art into the arraylist of art
	 * @param art
	 */
	public void add(Art art) {
		artList.add(art);
	}
	
	/**
	 * method returns the arrayList size
	 * @return
	 */
	public int size() {
		return artList.size();
	}
	
	/**
	 * method to find specific year within the arraylist and adds it into a copy of it which gets return
	 * @param year
	 * @return
	 */
	public ArrayList<Art> findYear(int year) {
		ArrayList<Art> artListSpecificYear = new ArrayList<Art>();
		
		for (Art artTemp : artList) {
			if (artTemp.getYear() == year) {
				artListSpecificYear.add(artTemp);
			}
		}
		return artListSpecificYear;
	}
	
	/**
	 * method to find specific project type within the arraylist and adds it into a copy of it which gets return
	 * @param projectType
	 * @return
	 */
	public ArrayList<Art> findProjectType(ArtProjectTypes projectType) {
		ArrayList<Art> artListSpecificProjectType = new ArrayList<Art>();
		
		for (Art artTemp : artList) {
			if (artTemp.getProjectType() == projectType) {
				artListSpecificProjectType.add(artTemp);
			}
		}
		return artListSpecificProjectType;
	}
	
	/**
	 * method to count the number of borough inside the data set
	 * @param borough
	 * @return
	 */
	public int counter(String borough) {
		int counter = 0; 
		
		for (Art artTemp : artList) {
			if (artTemp.getBorough().equals(borough)) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * method to find specific project and site type within the arraylist and adds it into a copy of it which gets return
	 * @param siteType
	 * @param projectType
	 * @return
	 */
	public ArrayList<Art> findSiteAndProjectType(ArtSiteTypes siteType, ArtProjectTypes projectType) {
		ArrayList<Art> artListSiteAndProjectType = new ArrayList<Art>();
		
		for (Art artTemp : artList) {
			if ((artTemp.getSiteType() == siteType) && (artTemp.getProjectType() == projectType)) {
				artListSiteAndProjectType.add(artTemp);
			}
		}
		return artListSiteAndProjectType;
	}
	
	/**
	 * method that sorts the array by year
	 * @return
	 */
	public ArrayList<Art> getSortedArtListByYear() {
		ArrayList<Art> artSorted = new ArrayList<Art>();
		
		for (Art artTemp : artList) {
			artSorted.add(artTemp);
		}
		Collections.sort(artSorted, (first, second) -> String.valueOf(first.getYear()).compareTo(String.valueOf(second.getYear())));
		return artSorted;
	}
	
	/**
	 * method that limits a copy of the arraylist to 200 and returns it
	 * @param artListTemp
	 * @return
	 */
	public ArrayList<Art> setListTo200(ArrayList<Art> artListTemp) {
		ArrayList<Art> art200 = new ArrayList<Art>();
		
		if (artListTemp.size() >= 200) {
			for (Art artTemp : artListTemp) {
				art200.add(artTemp);
				if (art200.size() == 200) {
					break;
				}
			}
		}
		else art200 = artListTemp;
		return art200;
		
	}
	
	/**
	 * the main method that sorts the arraylist by year and limits it to 200 
	 * @return
	 */
	public ArrayList<Art> sortedByYear() {
		ArrayList<Art> artSorted = new ArrayList<Art>();
		
		artSorted = getSortedArtListByYear();
		artSorted = setListTo200(artSorted);
		return artSorted;
		
	}
	
	/**
	 * the main method that uses the method to sort the copy arraylist by last name that has the specified site and project type
	 * @param siteType
	 * @param projectType
	 * @return
	 */
	public ArrayList<Art> getSortedArtListByLastNameWithSpecifications(ArtSiteTypes siteType, ArtProjectTypes projectType) {
		ArrayList<Art> artSorted = new ArrayList<Art>();
		
		artSorted = findSiteAndProjectType(siteType, projectType);
		Collections.sort(artSorted, (first, second) -> first.getLastName().compareTo(second.getLastName()));
		return artSorted;
	}
	
	/**
	 * the main method that returns a string stating each borough and the number of art inside the data set
	 * @return
	 */
	public String listOfBorough() {
		return "\nBrooklyn: " + counter("Brooklyn") + 
				"\nManhattan: " + counter("Manhattan") + 
				"\nManhatan: " + counter("Manhatan") +
				"\nMahattan: " + counter("Mahattan") +
				"\nManhttan: " + counter("Manhttan") +
				"\nQueens: " + counter("Queens") + 
				"\nBronx: " + counter("Bronx") + 
				"\nStaten Island: " + counter("Staten Island") + 
				"\nManhattan/Brooklyn: " + counter("Manhattan/Brooklyn") + 
				"\nManhattan/Staten Island: " + counter("Manhattan/Staten Island") + 
				"\nManhattan/Queens/Brooklyn/Bronx: " + counter("Manhattan/Queens/Brooklyn/Bronx") + 
				"\nAll boroughs: " + counter("All boroughs") + 
				"\nTotal: " + artList.size();
	}
	
	/**
	 * the main method that uses the method to return the size of the copy arraylist that has the specified year
	 * @param year
	 * @return
	 */
	public int numberOfArtInSpecificYearInstalled(int year) {
		ArrayList<Art> artTemp = new ArrayList<Art>();
		
		artTemp = findYear(year);
		return artTemp.size();
	}
	
	/**
	 * the main method that uses the method to return the size of the copy arraylist that has the specified project type
	 * @param projectType
	 * @return
	 */
	public int numberOfArtSpecificProjectType(ArtProjectTypes projectType) {
		ArrayList<Art> artTemp = new ArrayList<Art>();
		
		artTemp = findProjectType(projectType);
		return artTemp.size();
	}
	
	public ArrayList<Art> getSortedArtFirstName() {
		ArrayList<Art> artSorted = new ArrayList<Art>();
		
		for (Art artTemp : artList) {
			artSorted.add(artTemp);
		}
		Collections.sort(artSorted, (first, second) -> first.getFirstName().compareTo(second.getFirstName()));
		return artSorted;
	}
}
