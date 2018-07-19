package com.dawn.soundCloudexerise;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class SoundCloudExeriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoundCloudExeriseApplication.class, args).close();
	}
	
	/**
	 * Initialize thread pool configuration
	 * @return
	 */
	@Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("SoundCloudLookup-");
        executor.initialize();
        return executor;
    }
}

