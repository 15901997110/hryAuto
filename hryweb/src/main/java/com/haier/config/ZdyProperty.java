package com.haier.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/10/30 15:11
 */
@Component
public class ZdyProperty {
    @Value("${zdy.debug}")
    public String debug;
}
