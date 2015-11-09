package edu.binghamton.my.processor.stages;

import edu.binghamton.my.interfaces.IProcessorStage;
import edu.binghamton.my.interfaces.Instruction;

public class MemoryStage implements IProcessorStage {

	private Instruction instruction;

	private static MemoryStage memoryStageInstance;

	private MemoryStage(){}

	public MemoryStage getMemoryStageInstance() {
		if(memoryStageInstance == null) {
			memoryStageInstance = new MemoryStage();
		}
		return memoryStageInstance;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	@Override
	public void performTask() {
		// TODO Auto-generated method stub

	}

}
