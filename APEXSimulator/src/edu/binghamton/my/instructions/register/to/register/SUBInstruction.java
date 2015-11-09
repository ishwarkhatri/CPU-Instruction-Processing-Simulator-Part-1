package edu.binghamton.my.instructions.register.to.register;

import edu.binghamton.my.interfaces.IRegisterToRegisterInstruction;
import edu.binghamton.my.model.ProgramCounter;
import edu.binghamton.my.model.Register;

public class SUBInstruction extends ProgramCounter implements IRegisterToRegisterInstruction {

	private Register destRegister = new Register();

	private Register srcRegisterA = new Register();

	private Register srcRegisterB = new Register();

	public SUBInstruction(String rawInstruction) {
		String[] parts = rawInstruction.split(" ")[1].split(",");
		
		this.destRegister.setRegisterName(parts[0]);
		this.srcRegisterA.setRegisterName(parts[1]);
		this.srcRegisterB.setRegisterName(parts[2]);
	}

	public Register getDestRegister() {
		return destRegister;
	}

	public void setDestRegister(Register destRegister) {
		this.destRegister = destRegister;
	}

	public Register getSrcRegisterA() {
		return srcRegisterA;
	}

	public void setSrcRegisterA(Register srcRegisterA) {
		this.srcRegisterA = srcRegisterA;
	}

	public Register getSrcRegisterB() {
		return srcRegisterB;
	}

	public void setSrcRegisterB(Register srcRegisterB) {
		this.srcRegisterB = srcRegisterB;
	}

}