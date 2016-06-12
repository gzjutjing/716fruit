package configuration;

import com.jing.commons.GlobalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2016/4/12.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBoot {
    private static Logger logger = LoggerFactory.getLogger(SpringBoot.class);

    public static void main(String[] args) {
        logger.debug(GlobalUtils.logToLineInfo("spring boot启动开始"));
        SpringApplication.run(SpringBoot.class, args);
        logger.debug(GlobalUtils.logToLineInfo("spring boot启动结束"));
    }
}
