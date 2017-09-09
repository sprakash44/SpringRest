package com.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.imcs.config.BeanConfig;
@Import(BeanConfig.class)
@Configuration
public class RestConfig {

}
