package com.ssl.generator;

import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssl on 2017/6/9.
 */
public class GeneratorBySpringBoot {
    private static Logger logger = Logger.getLogger(GeneratorBySpringBoot.class);

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        logger.info("Start generator ...开始");
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true; // 是否覆盖原来的文件
        File configFile = new File("G:\\intelijIdea_workplace\\mybatis-generator-tool\\src\\test\\resources\\spring-boot.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        logger.info("Finish generator");
    }
}
