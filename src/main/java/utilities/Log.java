package utilities;

import org.apache.log4j.Logger;

public class Log {
  // Initialize Log4j instance
  private static final Logger Log = Logger.getLogger(Log.class.getName());

  // Error Level Logs
  public static void error(String message) {
    Log.error(message);
  }

  // Fatal Level Logs
  public static void fatal(String message) {
    Log.fatal(message);
  }

  // Debug Level Logs
  public static void debug(String message) {
    Log.debug(message);
  }
}
