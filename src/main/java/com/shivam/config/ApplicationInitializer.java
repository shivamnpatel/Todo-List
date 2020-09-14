package com.shivam.config;

// Alternate for web.xml, which initialize Dispatcher Servlet (there is one another way as well)
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class<?> config[] = {ApplicationConfig.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		String servletMapping[] = {"/"};
			return servletMapping;
	}

}
