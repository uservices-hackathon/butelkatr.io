package pl.uservices.butelkatr;

import com.ofg.infrastructure.environment.EnvironmentSetupVerifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

import static com.ofg.config.BasicProfiles.*;

@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new EnvironmentSetupVerifier(Arrays.asList(DEVELOPMENT, PRODUCTION, TEST)));
        application.run(args);
    }
}
