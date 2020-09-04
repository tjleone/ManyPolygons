import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SuppressWarnings("ucd")
public class LogUtil {
	
	private static FileHandler fileHandler;
	
	@SuppressWarnings("ucd")
	public static void setupLogging(String filename, Logger logger, Level level) {
		try {
			fileHandler = new FileHandler("log/" + filename + ".log", false);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileHandler.setLevel(Level.ALL);
		// A Filter can be used to provide fine grain control over what is
		// logged, beyond the control provided by log levels.
		// _fileHandler.setFilter(FILTER);
		fileHandler.setFormatter(new SimpleFormatter());
		
		logger.setLevel(Level.ALL);
		logger.addHandler(fileHandler);
	}
	
	@SuppressWarnings("ucd")
	public static void tearDownLogging() {
		fileHandler.close();
	}
}
