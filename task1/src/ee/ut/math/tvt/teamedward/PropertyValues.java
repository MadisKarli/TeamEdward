package ee.ut.math.tvt.teamedward;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyValues {
	
	private Configuration verConfig, appConfig;
	
	public PropertyValues () throws ConfigurationException{
		this.verConfig = versionPropertiesValues();
		this.appConfig = applicationPropertiesValues();
	}
	
//create configuration from version.properties
	public Configuration versionPropertiesValues()
			throws ConfigurationException {

		Configuration config = null;

		try {
			config = new PropertiesConfiguration("version.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return config;
	}
//create configuration from application.properties
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
//get BufferedImage from application.properties
	public BufferedImage getTeamLogo() throws ConfigurationException,
			IOException {
		byte[] decodedLogo = null;
		//image is stored as Base64 String
		String logoCode = appConfig.getString("teamLogo");
		//Encode String(logoCode) into sequence of bytes. Decode Base64 data.
		decodedLogo = Base64.decodeBase64(logoCode.getBytes());
		// convert byte array back to BufferedImage
		InputStream in = new ByteArrayInputStream(decodedLogo);
		BufferedImage imageFromConvert = ImageIO.read(in);
		in.close();
		return imageFromConvert;
	}
}
