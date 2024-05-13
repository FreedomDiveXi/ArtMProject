import java.io.FileNotFoundException;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class SystemStartUp {

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvValidationException {
		ArtList arts = new ArtList();
		
		String typeRead = FileConfig.getInstance().getReadType();
		ArtReader artRead = ReaderFactory.createReader(typeRead);
		arts = artRead.load();
		
		String typeWrite = FileConfig.getInstance().getWriteType();
		ArtWriter artWrite = WriterFactory.createWriter(typeWrite);
		artWrite.write(arts);
		
		ArtUI artUI = new ArtUI(arts);
		artUI.run();
		System.out.println("System shutting down, goodbye.");
	}

}
