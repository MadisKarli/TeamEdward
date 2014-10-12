package ee.ut.math.tvt.teamedward;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyValues {

	private Configuration verConfig, appConfig;

	public PropertyValues() throws ConfigurationException {
		super();
		this.verConfig = versionPropertiesValues();
		this.appConfig = applicationPropertiesValues();
	}

	public Configuration versionPropertiesValues()
			throws ConfigurationException {

		Configuration config = null;

		try {
			config = new PropertiesConfiguration("version.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}

		return config;
	}

	public Configuration applicationPropertiesValues()
			throws ConfigurationException {
		Configuration config = null;

		try {
			config = new PropertiesConfiguration("application.properties");

		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
		}

		return config;
	}

	public String getVersion() throws ConfigurationException {

		return verConfig.getString("build.number");

	}

	public String getTeamName() throws ConfigurationException {

		return appConfig.getString("teamName");

	}

	public String getTeamLeader() throws ConfigurationException {

		return appConfig.getString("teamLeader");

	}

	public String getTeamLeaderEmail() throws ConfigurationException {

		return appConfig.getString("teamLeaderEmail");

	}

	public String getTeamMembers() throws ConfigurationException {

		return appConfig.getString("teamLeader") + "    "
				+ appConfig.getString("teamMember1") + "    "
				+ appConfig.getString("teamMember2");

	}

	public void getTeamLogo() throws ConfigurationException, IOException {

		byte[] decodedLogo = null;
		String logoCode = appConfig.getString("teamLogo");
		decodedLogo = Base64.decodeBase64(logoCode.getBytes());
		// convert byte array back to BufferedImage
		InputStream in = new ByteArrayInputStream(decodedLogo);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		ImageIO.write(bImageFromConvert, "jpeg", new File("logo.jpeg"));
	}
}
