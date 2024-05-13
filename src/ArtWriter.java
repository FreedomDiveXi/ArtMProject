import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public interface ArtWriter {
	void write(ArtList arts) throws IOException, CsvValidationException;
}