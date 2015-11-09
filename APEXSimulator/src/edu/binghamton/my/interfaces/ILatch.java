package edu.binghamton.my.interfaces;

public interface ILatch {
	void storeData(Instruction instruction);
	Instruction getData();
}
