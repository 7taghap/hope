package com.rb.hopeapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



/**
 * This is the final config that defines Web Application configuration and imports Service, Dao and
 * Controller Configuration Rather than doing an import, one can choose to do classpath scanning if
 * thats what is desired via:
 * 
 * <pre>
 *   @ComponentScan(basePackages = "com.welflex")
 * </pre>
 * 
 * The @EnableMvc is a hook-in into the Spring Servlet
 */
//@EnableWebMvc
//@ComponentScan(basePackages = "com.rb.hopeapp")
//@Configuration
//@Import({ ControllerConfig.class, DefaultServiceConfig.class, DefaultDaoConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public Validator getValidator() {
    return new LocalValidatorFactoryBean();
  }

  @Bean
  public ViewResolver getViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setViewClass(JstlView.class);
    resolver.setPrefix("/WEB-INF/pages/");
    resolver.setSuffix(".jsp");

    return resolver;
  }

  private static final Class<?>[] JAXB_CLASSES_TO_BE_BOUND = { Error.class };

  @Bean
  public RequestMappingHandlerAdapter getHandlerAdapter() {
    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
    converters.add(new StringHttpMessageConverter());

    Jaxb2Marshaller m = new Jaxb2Marshaller();
    m.setClassesToBeBound(JAXB_CLASSES_TO_BE_BOUND);

    MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();

    converter.setMarshaller(m);
    converter.setUnmarshaller(m);

    converters.add(converter);
    converters.add(new MappingJacksonHttpMessageConverter());

    RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();

    adapter.setMessageConverters(converters);
    return adapter;
  }
//
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
}
