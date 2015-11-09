package edu.binghamton.my.processor.stages;

import java.io.IOException;

import edu.binghamton.my.cache.InstructionCache;
import edu.binghamton.my.instructions.raw.RawInstruction;
import edu.binghamton.my.interfaces.IProcessorStage;
import edu.binghamton.my.interfaces.Instruction;
import edu.binghamton.my.latches.FetchDecodeLatch;

public class FetchStage implements IProcessorStage, Runnable {

	private Instruction instruction;

	private InstructionCache iCache;

	private static FetchStage fetchStageInstance;

	private FetchStage(){}
	
	public static FetchStage getFetchStageInstance() {
		if(fetchStageInstance == null) {
			fetchStageInstance = new FetchStage();
		}
		return fetchStageInstance;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	@Override
	public void performTask() {
		if(FetchDecodeLatch.isDataConsumed) {
			String nextInstruction;
			try {
				nextInstruction = InstructionCache.getInstructionCacheInstance().next();
				System.out.println("Next instruction: " + nextInstruction);
				if(nextInstruction == null) {
					FetchDecodeLatch.isFetchingCompleted = true;
					System.out.println("Fetching completed");
					return;
				}
				RawInstruction rawInstruction = new RawInstruction();
				rawInstruction.setRawInstruction(nextInstruction);
				
				FetchDecodeLatch.getFetchDecodeLatchInstance().storeData(rawInstruction);
				FetchDecodeLatch.isDataConsumed = false;
				
			} catch(IOException e) {
				e.printStackTrace();
				nextInstruction = null;
			}
		}
	}

	@Override
	public void run() {
		for(;;) {
			if(!FetchDecodeLatch.isFetchingCompleted) {
				performTask();
			}
			else {
				break;
			}
		}
	}

}
