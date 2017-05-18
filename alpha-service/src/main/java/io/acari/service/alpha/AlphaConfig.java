package io.acari.service.alpha;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AlphaConfig {

    /**
     * An Executor Service would have been sufficient.
     * However this allows Spring to manage the lifecycle of the
     * the service. Preventing the need for a shutdown in the predestroy method any
     * bean that uses the PoorMansExecutor.
     */
    @Bean
    public PoorMansExecutor poorMansExecutor(){
        return new PoorMansExecutor();
    }

}
