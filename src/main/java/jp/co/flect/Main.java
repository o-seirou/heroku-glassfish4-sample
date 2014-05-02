package jp.co.flect;

import java.io.File;
import java.io.IOException;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;

public class Main {

	public static void main(String... args) throws IOException, GlassFishException {
		String port = System.getenv("PORT");
		if (port == null || port.isEmpty()) {
			port = "8080";
		}
		GlassFishProperties prop = new GlassFishProperties();
		prop.setPort("http-listener", Integer.valueOf(port));

		final GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(prop);

		Runtime.getRuntime().addShutdownHook(
			new Thread(
				new Runnable() {
					@Override
					public void run() {
						try {
							glassfish.stop();
							glassfish.dispose();
							System.err.println("GlassFish stoped.");
						} catch (GlassFishException e) {
							e.printStackTrace();
						}
					}
				}
			)
		);

		glassfish.start();
		System.err.println("GlassFish starting..");

		Deployer deployer = glassfish.getDeployer();
		ScatteredArchive archive = new ScatteredArchive("testapp", ScatteredArchive.Type.WAR);
		archive.addClassPath(new File("target", "classes"));
//		archive.addMetadata(new File("resources", "web.xml"));
		String appName = deployer.deploy(archive.toURI(), "--contextroot=test");
	}
}
