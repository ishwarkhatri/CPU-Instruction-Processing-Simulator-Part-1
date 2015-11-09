package edu.binghamton.my.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.binghamton.my.interfaces.ICache;
import edu.binghamton.my.model.ProgramCounter;

public class InstructionCache extends ProgramCounter implements ICache {

	private static InstructionCache iCacheInstance;

	private static List<String> instructionList;

	private InstructionCache(){}

	public static InstructionCache getInstructionCacheInstance() throws IOException {
		if(iCacheInstance == null) {
			iCacheInstance = new InstructionCache();
			init();
		}
		return iCacheInstance;
	}

	private static void init() throws IOException {
		BufferedReader buffReader = new BufferedReader(new FileReader("instructions.txt"));
		instructionList = new ArrayList<String>();
		String instruction;
		int prgCounter = PC;
		while((instruction = buffReader.readLine()) != null) {
			instructionList.add(prgCounter++, instruction);
		}
		buffReader.close();
	}
	public String next() {
		if(PC >= instructionList.size())
			return null;

		return instructionList.get(PC++);
	}
}
