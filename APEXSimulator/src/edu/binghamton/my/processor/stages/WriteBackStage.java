package edu.binghamton.my.processor.stages;

import edu.binghamton.my.interfaces.IProcessorStage;
import edu.binghamton.my.interfaces.Instruction;

public class WriteBackStage implements IProcessorStage {

	private Instruction instruction;

	private static WriteBackStage writeBackStageInstance;

	private WriteBackStage(){}

	public static WriteBackStage getWriteBackStageInstance() {
		if(writeBackStageInstance == null) {
			writeBackStageInstance = new WriteBackStage();
		}
		return writeBackStageInstance;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	@Override
	public void performTask() {
		// TODO Auto-generated method stub

	}

}
