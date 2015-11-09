package edu.binghamton.my.processor.stages;

import java.io.IOException;
import java.util.Scanner;

import edu.binghamton.my.constants.InstructionType;
import edu.binghamton.my.instructions.raw.RawInstruction;
import edu.binghamton.my.instructions.register.to.register.ADDInstruction;
import edu.binghamton.my.instructions.register.to.register.SUBInstruction;
import edu.binghamton.my.interfaces.IProcessorStage;
import edu.binghamton.my.interfaces.Instruction;
import edu.binghamton.my.latches.DecodeExecuteLatch;
import edu.binghamton.my.latches.FetchDecodeLatch;
import edu.binghamton.my.model.Register;
import edu.binghamton.my.register.file.RegisterFile;

public class DecodeStage implements IProcessorStage, Runnable {

	private static DecodeStage decodeStageInstance;

	private Instruction instruction;

	private DecodeStage(){}
	
	public static DecodeStage getDecodeStageInstance() {
		if(decodeStageInstance == null) {
			decodeStageInstance = new DecodeStage();
		}
		return decodeStageInstance;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	@Override
	public void performTask() {
		if(!FetchDecodeLatch.isDataConsumed) {
			RawInstruction rawInstruction = (RawInstruction) FetchDecodeLatch.getFetchDecodeLatchInstance().getData();
			FetchDecodeLatch.isDataConsumed = true;

			Instruction decodedInstruction;
			try{
				decodedInstruction = getDecodedInstruction(rawInstruction);
				if(DecodeExecuteLatch.isDataConsumed) {
					DecodeExecuteLatch.getDecodeExecuteLatchInstance().storeData(decodedInstruction);
					DecodeExecuteLatch.isDataConsumed = false;
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private Instruction getDecodedInstruction(RawInstruction rawInstruction) throws IOException {
		String instructionType = rawInstruction.getRawInstruction().split(" ")[0];
		InstructionType type = InstructionType.getInstructionType(instructionType);
		Instruction instruction = null;
		if(type == InstructionType.ADD) {
			ADDInstruction addInstruction = new ADDInstruction(rawInstruction.getRawInstruction());
			setRegisterValueFromRF(addInstruction.getSrcRegisterA());
			setRegisterValueFromRF(addInstruction.getSrcRegisterB());
			setRegisterValueFromRF(addInstruction.getDestRegister());
			return addInstruction;
			
		} else if(type == InstructionType.SUB) {
			SUBInstruction subInstruction = new SUBInstruction(rawInstruction.getRawInstruction());
			setRegisterValueFromRF(subInstruction.getSrcRegisterA());
			setRegisterValueFromRF(subInstruction.getSrcRegisterB());
			setRegisterValueFromRF(subInstruction.getDestRegister());
			return subInstruction;
		}
		return instruction;
	}

	private void setRegisterValueFromRF(Register reg) throws IOException {
		reg.setRegisterValue(RegisterFile.getRegisterFileInstance().getRegisterValue(reg.getRegisterName()));
	}

	@Override
	public void run() {
		for(;;) {
			//System.out.println("DecodeStage");
			performTask();
			if(FetchDecodeLatch.isFetchingCompleted)
				break;
		}
	}

}
