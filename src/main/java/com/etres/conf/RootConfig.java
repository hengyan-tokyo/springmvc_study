package com.etres.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages="com.etres",excludeFilters= {
		
		@Filter(type=FilterType.ANNOTATION,classes=Controller.class)
}
		)
public class RootConfig {
	
	

}
