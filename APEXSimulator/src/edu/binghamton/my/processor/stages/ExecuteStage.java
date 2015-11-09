package edu.binghamton.my.processor.stages;

import edu.binghamton.my.interfaces.IExecutionUnit;
import edu.binghamton.my.interfaces.IProcessorStage;
import edu.binghamton.my.interfaces.Instruction;

public class ExecuteStage implements IProcessorStage {

	private IExecutionUnit executionUnit;

	private Instruction instruction;

	private static ExecuteStage executeStageInstance;

	private ExecuteStage() {}

	public static ExecuteStage getExecuteStageInstance() {
		if(executeStageInstance == null) {
			executeStageInstance = new ExecuteStage();
		}
		return executeStageInstance;
	}

	public void setExecutionUnit(IExecutionUnit executionUnit) {
		this.executionUnit = executionUnit;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	@Override
	public void performTask() {
		// TODO Auto-generated method stub

	}

}
