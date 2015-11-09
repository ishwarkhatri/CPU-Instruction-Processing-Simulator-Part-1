package edu.binghamton.my.latches;

import edu.binghamton.my.interfaces.ILatch;
import edu.binghamton.my.interfaces.Instruction;

public class DecodeExecuteLatch implements ILatch {

	public static volatile boolean isDataConsumed = true;

	public static volatile Instruction instruction;

	public static DecodeExecuteLatch decodeExecuteLatchInstance;

	private DecodeExecuteLatch(){}

	public static DecodeExecuteLatch getDecodeExecuteLatchInstance() {
		if(decodeExecuteLatchInstance == null) {
			decodeExecuteLatchInstance = new DecodeExecuteLatch();
		}
		return decodeExecuteLatchInstance;
	}

	@Override
	public void storeData(Instruction instruction) {
		DecodeExecuteLatch.instruction = instruction;
	}

	@Override
	public Instruction getData() {
		return DecodeExecuteLatch.instruction;
	}

}
