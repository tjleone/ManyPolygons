/**
 *    LogUtil is part of the ManyPolygons project
 *    Copyright (C) 2020  TJ Leone
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
