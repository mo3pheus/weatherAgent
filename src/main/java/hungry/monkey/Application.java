package hungry.monkey;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.FileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Application {
    public static Properties projectProperties = new Properties();

//    public static void configureLogging(String logFileName, String logFilePath) {
//        String patternLayoutString = "%d [%t] %p %c :: %m%n";
//        final PatternLayout layout = PatternLayout.newBuilder().withPattern(patternLayoutString).build();
//        String logFilename = logFilePath + "/" + logFileName;
//        final FileAppender appender = FileAppender.newBuilder()
//                .withCreateOnDemand(true)
//                .withFileName(logFilename)
//                .withAppend(true)
//                .setLayout(layout)
//                .setName(logFileName).build();
//        loggerConfig.setLevel(Level.DEBUG);
//        loggerConfig.addAppender(appender, Level.DEBUG, null);
//    }

    public static void configureProperties(String[] args) {
        projectProperties = new Properties();
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("--")) {
                String key = args[i].replaceAll("--", "");
                projectProperties.put(key, args[i + 1]);
                System.out.println("Property = " + args[i] + " value = " + args[i + 1]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        //configureProperties(args);

        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.info("This is the weather agent application.");
        System.out.println("This is the weather agent application");
    }
}