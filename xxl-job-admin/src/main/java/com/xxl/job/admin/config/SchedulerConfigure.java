package com.xxl.job.admin.config;

import com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

/**
 * @author zlikun
 * @date 2018-09-27 17:32
 */
@Configuration
public class SchedulerConfigure {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 自动启动
        factoryBean.setAutoStartup(true);
        // 延时启动，应用启动成功后在启动
        factoryBean.setStartupDelay(20);
        // 覆盖DB中JOB：true、以数据库中已经存在的为准：false
        factoryBean.setOverwriteExistingJobs(true);
        factoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        factoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
        return factoryBean;
    }

    @Bean
    public XxlJobDynamicScheduler jobDynamicScheduler(@Value("${xxl.job.accessToken}") String accessToken) {
        XxlJobDynamicScheduler scheduler = new XxlJobDynamicScheduler();
        scheduler.setScheduler(schedulerFactoryBean().getObject());
        scheduler.setAccessToken(accessToken);
        return scheduler;
    }

}
