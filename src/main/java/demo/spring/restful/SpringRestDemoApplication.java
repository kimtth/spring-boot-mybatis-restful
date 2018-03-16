package demo.spring.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

// You are fine if all your components are defined in the above package or a
// sub-package of it.

// same as @Configuration @EnableAutoConfiguration @ComponentScan
// spring-boot will scan for components in packages below com.nice.application,
// so if your controller is in com.nice.controller you need to scan for it
// explicitly.
@ComponentScan(basePackages = { "demo.spring.restful.*" })
@SpringBootApplication
public class SpringRestDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(SpringRestDemoApplication.class, args);
		System.err.println(appContext.getApplicationName());

		for (String name : appContext.getBeanDefinitionNames()) {
			if (name.contains("user")) {
				System.err.println(name);
			}
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringRestDemoApplication.class);
	}

}
