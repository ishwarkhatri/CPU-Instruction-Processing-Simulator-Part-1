package edu.binghamton.my.latches;

import edu.binghamton.my.instructions.raw.RawInstruction;
import edu.binghamton.my.interfaces.ILatch;
import edu.binghamton.my.interfaces.Instruction;

public class FetchDecodeLatch implements ILatch {

	public static volatile boolean isDataConsumed = true;

	public static volatile boolean isFetchingCompleted = false;

	private static volatile RawInstruction rawInstruction;

	private static FetchDecodeLatch fetchDecodeLatchInstance;

	private FetchDecodeLatch(){}

	public static FetchDecodeLatch getFetchDecodeLatchInstance(){
		if(fetchDecodeLatchInstance == null) {
			fetchDecodeLatchInstance = new FetchDecodeLatch();
		}
		return fetchDecodeLatchInstance;
	}

	@Override
	public void storeData(Instruction rawInstruction) {
		RawInstruction temp = (RawInstruction) rawInstruction;
		FetchDecodeLatch.rawInstruction = temp;
	}

	@Override
	public Instruction getData() {
		return FetchDecodeLatch.rawInstruction;
	}

}
