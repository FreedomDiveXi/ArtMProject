
public class WriterFactory {
	public static ArtWriter createWriter(String type) {
		if (type.equals("csv")) {
			ArtCSVWriter artCSV = new ArtCSVWriter();
			return artCSV;
		}
		else if (type.equals("json")) {
			ArtJSONWriter artJSON = new ArtJSONWriter();
			return artJSON;
		}
		else {
			return null;
		}
	}
}
