package com.skillstorm.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// in using this we don't need to setup a web.xml
public class DelegatingFilterProxyInitializer extends AbstractSecurityWebApplicationInitializer {
	// bootstrap the DelegatingFilterProxy
	// adds the url-pattern to be /* (will intercept all requests for me)
}
