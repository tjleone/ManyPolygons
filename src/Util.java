import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class Util {

	public static FileHandler createFileHandler(String filename) throws IOException {
		FileHandler fileHandler = new FileHandler("log/" + filename + ".log", false);
		fileHandler.setLevel(Level.ALL);
		// A Filter can be used to provide fine grain control over what is
		// logged, beyond the control provided by log levels.
		// _fileHandler.setFilter(FILTER);
		fileHandler.setFormatter(new SimpleFormatter());
		return fileHandler;
	}
	
	public static double tanDegrees(double d) {
		return Math.tan(Math.toRadians(d));
	}

}
