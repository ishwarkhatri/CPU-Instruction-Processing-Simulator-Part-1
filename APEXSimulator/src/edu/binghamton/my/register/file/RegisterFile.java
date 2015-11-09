package edu.binghamton.my.register.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RegisterFile {

	private static RegisterFile registerFileInstance;

	private static volatile Map<String, Integer> registerFileMap = new HashMap<>();

	private RegisterFile(){}

	public static RegisterFile getRegisterFileInstance() throws IOException {
		if(registerFileInstance == null) {
			registerFileInstance = new RegisterFile();
			init();
		}
		return registerFileInstance;
	}

	private static void init() throws IOException {
		Properties properties = new Properties();
		properties.load(new InputStreamReader(new FileInputStream("register_file.txt")));
		for(String rName : properties.stringPropertyNames()) {
			System.out.println(rName + ": " + properties.getProperty(rName));
			registerFileMap.put(rName, Integer.parseInt(properties.getProperty(rName)));
		}
	}

	public Integer getRegisterValue(String registerName) {
		return registerFileMap.get(registerName);
	}

	public void setRegisterValue(String registerName, Integer value) {
		registerFileMap.put(registerName, value);
	}
}
