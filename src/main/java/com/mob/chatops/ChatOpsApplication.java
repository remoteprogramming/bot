package com.mob.chatops;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.listener.message.MessageCreateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Set;

@SpringBootApplication
public class ChatOpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatOpsApplication.class, args);
	}

	@Autowired
	private Set<MessageCreateListener> messageListeners;

	@Autowired
	private Environment env;

	@Bean
	@ConfigurationProperties("discord-api")
	public DiscordApi discordApi() {
		System.out.println("Initialising api");
		String token = env.getProperty("TOKEN");
		DiscordApiBuilder builder = new DiscordApiBuilder().setToken(token).setAllIntents();
		DiscordApi api = builder.login().join();

		System.out.println("Initialising listeners");
		messageListeners.forEach(api::addMessageCreateListener);
		api.getListeners().values().forEach(value -> value.forEach(list -> System.out.println(list.toString())));

		System.out.println("Initiated");

		return api;
	}
}
