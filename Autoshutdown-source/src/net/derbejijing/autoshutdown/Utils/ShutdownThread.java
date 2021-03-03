package net.derbejijing.autoshutdown.Utils;

import java.io.IOException;

public class ShutdownThread extends Thread {
	public int delay;
	
	public void run() {
		try {
			String shutdownCommand;
		    String operatingSystem = System.getProperty("os.name");
	
		    if ("Linux".equalsIgnoreCase(operatingSystem) || "Mac OS X".equalsIgnoreCase(operatingSystem)) {
		        shutdownCommand = "shutdown -h +" + delay;
		    }
		    else if ("Windows".equalsIgnoreCase(operatingSystem)) {
		        shutdownCommand = "shutdown.exe -s -t " + delay*60;
		    }
		    else {
		        throw new RuntimeException("Unsupported operating system.");
		    }
			
		    Runtime.getRuntime().exec(shutdownCommand);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
