package edu.binghamton.my.constants;

public enum InstructionType {

	ADD,
	SUB,
	MOVC,
	MUL,
	AND,
	OR,
	EXOR,
	LOAD,
	STORE,
	BZ,
	BNZ,
	JUMP,
	BAL,
	HALT;
	
	public static InstructionType getInstructionType(String instruction) {
		if("add".equalsIgnoreCase(instruction))
			return ADD;
		if("sub".equalsIgnoreCase(instruction))
			return SUB;
		if("movc".equalsIgnoreCase(instruction))
			return MOVC;
		if("mul".equalsIgnoreCase(instruction))
			return MUL;
		if("and".equalsIgnoreCase(instruction))
			return AND;
		if("or".equalsIgnoreCase(instruction))
			return OR;
		if("exor".equalsIgnoreCase(instruction))
			return EXOR;
		if("load".equalsIgnoreCase(instruction))
			return LOAD;
		if("store".equalsIgnoreCase(instruction))
			return STORE;
		if("bz".equalsIgnoreCase(instruction))
			return BZ;
		if("bnz".equalsIgnoreCase(instruction))
			return BNZ;
		if("jump".equalsIgnoreCase(instruction))
			return JUMP;
		if("bal".equalsIgnoreCase(instruction))
			return BAL;
		if("halt".equalsIgnoreCase(instruction))
			return HALT;

		return null;
	}
}
