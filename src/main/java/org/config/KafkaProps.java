package org.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class KafkaProps {

    private static final Properties PROPS = new Properties();
    private static final String CONFIG_FILE = "producer.properties";
    private static final Logger logger = LoggerFactory.getLogger(KafkaProps.class);

    private KafkaProps() {}

    static {
        processConfiguration();
    }

    private static void processConfiguration() {
        try(InputStream inputStream = KafkaProps.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if(inputStream == null) throw new RuntimeException("Unable to find " + CONFIG_FILE);
            PROPS.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static Properties getProps() {
        return PROPS;
    }

}
