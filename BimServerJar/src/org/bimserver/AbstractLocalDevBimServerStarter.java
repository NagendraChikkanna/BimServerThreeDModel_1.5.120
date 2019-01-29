package org.bimserver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

public class AbstractLocalDevBimServerStarter {
	private BimServer bimServer;

	public void start(int id, String address, String name, int port, int pbport, Path[] pluginDirectories, Path home, ResourceFetcher resourceFetcher, String resourceBase, boolean autoSetup) {
		BimServerConfig config = new BimServerConfig();
		if (home != null) {
			config.setHomeDir(home);
		} else {
			config.setHomeDir(Paths.get("tmptestdata/home" + (id == -1 ? "" : id)));
		}
		config.setResourceFetcher(resourceFetcher);
		config.setStartEmbeddedWebServer(true);
		config.setClassPath(System.getProperty("java.class.path"));
		config.setLocalDev(true);
		config.setEnvironment(Environment.LOCAL_DEV);
		config.setPort(port);
		config.setStartCommandLine(true);
		config.setResourceBase(resourceBase);

		try {
			fixLogging(config);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		bimServer = new BimServer(config);
		bimServer.getVersionChecker().getLocalVersion().setDate(new Date());
		bimServer.setEmbeddedWebServer(new EmbeddedWebServer(bimServer, config.getResourcebase(), config.isLocalDev()));
		Logger LOGGER = LoggerFactory.getLogger(LocalDevBimServerStarter.class);
		try {
			bimServer.start();
			/*if (bimServer.getServerInfo().getServerState() == ServerState.MIGRATION_REQUIRED) {
				bimServer.getServerInfoManager().registerStateChangeListener(new StateChangeListener() {
					@Override
					public void stateChanged(ServerState oldState, ServerState newState) {
						if (oldState == ServerState.MIGRATION_REQUIRED && newState == ServerState.RUNNING) {
							try {
								LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
							} catch (PluginException e) {
								LOGGER.error("", e);
							}
						}
					}
				});
			} 
			else if (bimServer.getServerInfo().getServerState() == ServerState.RUNNING) {
				long start = System.nanoTime();
				LOGGER.info("Loading plugins...");
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
				if (autoSetup) {
					try {
						AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
						adminInterface.setup("http://localhost:" + port, name, "My Description", "http://localhost:" + port + "/img/bimserver.png", "Administrator", "admin@bimserver.org", "admin");
						SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
						settingsInterface.setCacheOutputFiles(false);
						settingsInterface.setPluginStrictVersionChecking(false);
					} catch (Exception e) {
						// Ignore
					}
				}
				bimServer.activateServices();
				long end = System.nanoTime();
				LOGGER.info("All plugins loaded (" + ((end - start) / 1000000) + " ms)");
				
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
				if (autoSetup) {
					try {
						AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
						adminInterface.setup("http://localhost:" + port, name, "My Description", "http://localhost:" + port + "/img/bimserver.png", "Administrator", "admin@bimserver.org", "admin");
						SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
						settingsInterface.setCacheOutputFiles(false);
						settingsInterface.setPluginStrictVersionChecking(false);
					} catch (Exception e) {
						// Ignore
					}
				}
				bimServer.activateServices();
			} 
			else if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
				if (autoSetup) {
					try {
						AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
						adminInterface.setup("http://localhost:" + port, name, "My Description", "http://localhost:" + port + "/img/bimserver.png", "Administrator", "admin@bimserver.org", "admin");
						SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
						settingsInterface.setCacheOutputFiles(false);
						settingsInterface.setPluginStrictVersionChecking(false);
					} catch (Exception e) {
						// Ignore
					}
				}
				bimServer.activateServices();
			} 
			else {
				LOGGER.error("BIMserver did not startup correctly");
			}*/
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
			bimServer.activateServices();
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		}
	}

	/**
	 * Add a file appender to every logger we can find (the loggers should already have been configured via logback.xml)
	 * 
	 * @throws IOException
	 */
	private void fixLogging(BimServerConfig config) throws IOException {
		Path logFolder = config.getHomeDir().resolve("logs");
		if (!Files.isDirectory(logFolder)) {
			Files.createDirectories(logFolder);
		}
		Path file = logFolder.resolve("bimserver.log");

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		PatternLayoutEncoder ple = new PatternLayoutEncoder();

		ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
		ple.setContext(lc);
		ple.start();
		FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
		String filename = file.toAbsolutePath().toString();

		if (lc instanceof LoggerContext) {
		    if (!lc.isStarted()) {
		    	lc.start();
		    }
		}
		
		System.out.println("Logging to " + filename);
		
		fileAppender.setFile(filename);
		fileAppender.setEncoder(ple);
		fileAppender.setContext(lc);
		fileAppender.start();

		for (ch.qos.logback.classic.Logger log : lc.getLoggerList()) {
			if (log.getLevel() != null) {
				log.addAppender(fileAppender);
			}
		}
	}

	public BimServer getBimServer() {
		return bimServer;
	}
}
