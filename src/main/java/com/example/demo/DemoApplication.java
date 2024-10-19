package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(KafkaProducerService kafkaTemplate){
		return args -> {
			kafkaTemplate.send("task-topic", "taskId", new TaskStatus("taskId", "taskName", 50.0f, TaskStatus.Status.RUNNING));
			kafkaTemplate.send("task-topic", "taskId", new TaskStatus("taskId", "taskName", 100.0f, TaskStatus.Status.FINISHED));
			System.err.println("here");
		};
	}
}
