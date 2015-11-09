package edu.binghamton.my.instructions.raw;

import edu.binghamton.my.interfaces.Instruction;

public class RawInstruction implements Instruction {

	private String rawInstruction;

	public String getRawInstruction() {
		return rawInstruction;
	}

	public void setRawInstruction(String rawInstruction) {
		this.rawInstruction = rawInstruction;
	}

}
