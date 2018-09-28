package com.xxl.job.core.log;

import org.junit.Test;

/**
 * @author zlikun
 * @date 2018-09-28 11:44
 */
public class XxlJobLoggerTest {

    @Test
    public void log() {

        XxlJobLogger.log("姓名：{}, 年龄：{}", "张三", 17);

    }
}