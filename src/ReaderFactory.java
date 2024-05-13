
public class ReaderFactory {
	public static ArtReader createReader(String type) {
		if (type.equals("csv")) {
			ArtCSVReader artCSV = new ArtCSVReader();
			return artCSV;
		}
		else if (type.equals("json")) {
			ArtJSONReader artJSON = new ArtJSONReader();
			return artJSON;
		}
		else {
			return null;
		}
	}
}
