package oprea.constantin.service.configuration;

import oprea.constantin.service.interceptor.MyRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }

    @Bean
    public MyRequestInterceptor myInterceptor() {
        return new MyRequestInterceptor(); // let Spring go nuts injecting stuff
    }

}