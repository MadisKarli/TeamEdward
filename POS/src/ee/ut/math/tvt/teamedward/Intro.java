package ee.ut.math.tvt.teamedward;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Intro {

	static Logger logger = Logger.getLogger(Intro.class);

	public static void main(String[] args) throws IOException,
			ConfigurationException {
		BasicConfigurator.configure();
		logger.info("Initializing intro window");
		IntroUI.tutvus();
		logger.info("The intro window has been initialized.");
	}

}
