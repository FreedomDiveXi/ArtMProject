import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class ArtCSVWriter implements ArtWriter{
	public void write(ArtList arts) throws IOException, CsvValidationException {
		ArrayList<Art> artList = new ArrayList<Art>();
		ArtList artTemp = arts;
		String typeWrite = FileConfig.getInstance().getWriteFilename();
		char sep = FileConfig.myInstance.getWriteSep();
		ICSVWriter csvWriter = new CSVWriterBuilder(new FileWriter(typeWrite)).withSeparator(sep).build();
		
		String[] header = {"Program", "Year", "Title", "Artist", "Partner", "Location", "Borough", "Number of Days Difference"};
		csvWriter.writeNext(header);
		
		artList = artTemp.getSortedArtFirstName();
		
		for (Art art : artList) {
			String name = art.getFirstName() + art.getLastName();
			LocalDate install = art.getInstallation();
			LocalDate remove = art.getRemoval();
			Period gap = install.until(remove);
			int days = gap.getDays();
			String[] line = {art.getProgram(), String.valueOf(art.getYear()), art.getTitle(), name, art.getPartner(), art.getSiteLocation(), art.getBorough(), String.valueOf(days)};
			csvWriter.writeNext(line);
		}
		
		csvWriter.close();
	}
}
