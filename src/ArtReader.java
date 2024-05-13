import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public interface ArtReader {
	ArtList load() throws CsvValidationException, IOException;
}
