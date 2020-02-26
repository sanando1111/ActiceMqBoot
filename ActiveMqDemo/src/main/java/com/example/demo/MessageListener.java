package com.example.demo;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageListener {

	@JmsListener(destination = "MyQueue")
	public void listen(String message) {
		System.out.println("Message in queue:" + message);
	}
}
