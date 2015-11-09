package edu.binghamton.my.entry.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.binghamton.my.processor.stages.DecodeStage;
import edu.binghamton.my.processor.stages.FetchStage;

public class APEXSimulatorMain {
	private static ExecutorService execService = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		execService.execute(FetchStage.getFetchStageInstance());
		execService.execute(DecodeStage.getDecodeStageInstance());

		execService.shutdown();
		System.out.println("Exiting...");
	}

}
