package net.sling4j.examples.simplest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoCli {

    public static void main(String[] args) throws Exception {
	log.debug("main() called.");
	
	System.out.println("Hello World! Echo!");
	System.out.println("(Will exit after 6 echos or 30 seconds)");
	System.out.println();

	Thread t = new Thread(EchoCli::sleepAndKill);
	t.start();

	System.out.println("java.version=" + System.getProperty("java.version"));
	System.out.println("java.home=" + System.getProperty("java.home"));
	System.out.println();

	System.out.println("Hello World! Echo!");

	System.out.println("Say something.");

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	for (int i = 0; i < 6; i++) {
	    String s = br.readLine();
	    System.out.println("You said: " + s);
	    if (s.equalsIgnoreCase("exit")) {
		System.exit(6);
	    }
	}

    }

    public static void sleepAndKill() {
	try {
	    Thread.sleep(30000);
	    System.exit(30);
	} catch (Exception e) {
	}
    }
}
