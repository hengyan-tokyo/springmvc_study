package com.etres.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages="com.etres",includeFilters= {
		@Filter(type=FilterType.ANNOTATION,classes=Controller.class)
},useDefaultFilters=false)
public class WebMvcConig {

}
