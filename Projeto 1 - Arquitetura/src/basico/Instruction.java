package basico;

public class Instruction {
	private String rs;
	private String rd;
	private String rt;
	private String type;
	private String operationName = null;
	
	public static final String ADD = "000000";
	public static final String ADD_END = "100000";
	public static final String AND = "000000";
	public static final String AND_END = "100100";
	public static final String SUB = "000000";
	public static final String SUB_END = "100010";
	public static final String SLT = "000000";
	public static final String SLT_END = "101010";
	public static final String OR = "000000";
	public static final String OR_END = "100101";
	public static final String NOR = "000000";
	public static final String NOR_END = "100111";
	public static final String XOR = "000000";
	public static final String XOR_END = "100110";
	public static final String JR = "000000";
	public static final String JR_END = "001000";
	public static final String MFHI = "000000";
	public static final String MFHI_END = "010000";
	public static final String MFLO = "000000";
	public static final String MFLO_END = "010010";
	public static final String ADDU = "000000";
	public static final String ADDU_END = "100001";
	public static final String SUBU = "000000";
	public static final String SUBU_END = "100011";
	public static final String MULT = "000000";
	public static final String MULT_END = "011000";
	public static final String MULTU = "000000";
	public static final String MULTU_END = "011001";
	public static final String SLL = "000000";
	public static final String SLLV = "000000";
	public static final String SLLV_END = "000100";
	public static final String SRL = "000000";
	public static final String SRL_END = "000010";
	public static final String SRA = "000000";
	public static final String SRA_END = "000011";
	public static final String SRLV = "000000";
	public static final String SRLV_END = "000110";
	public static final String SRAV = "000000";
	public static final String SRAV_END = "000111";
	public static final String SYSCALL = "000000";
	public static final String SYSCALL_END = "001100";
	
	public static final String SLTI = "001010";
	public static final String XORI = "001110";
	public static final String ORI = "001101";
	public static final String JAL = "000011";
	public static final String ADDI = "001000";
	public static final String ADDIU = "001001";
	public static final String LUI = "001111";
	public static final String LW = "100011";
	public static final String SW = "101011";
	public static final String J = "000010";
	public static final String ANDI = "001100";
	public static final String BEQ = "000100";
	public static final String BLTZ = "000001";
	public static final String BNE = "000101";
	

	public Instruction(){
			this.operationName = null;
			this.type = null;
			this.rs = null;
			this.rd = null;
			this.rt = null;
		}
	public String getOperationName() {
		return this.operationName;
	}
	public String getType(){
		return this.type;
	}
	public String getRs(){
		return this.rs;
	}
	public String getRd(){
		return this.rd;
	}
	public String getRt(){
		return this.rt;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setRs(String rs){
		this.rs = rs;
	}
	public void setRd(String rd){
		this.rd = rd;
	}
	public void setRt(String rt){
		this.rt = rt;
	}


	public String verifyOperationSubType(String instructionBin){
		String operation = null;
		String type = null;
		switch(instructionBin.substring(26, 32)){
			case ADD_END:
				operation = "ADD";
				type = "R";
				break;
			case AND_END:
				operation = "AND";
				type = "R";
				break;
			case SUB_END:
				operation = "SUB";
				type = "R";
				break;
			case SLT_END:
				operation = "SLT";
				type = "R";
				break;
			case OR_END:
				operation = "OR";
				type = "R";
				break;
			case NOR_END:
				operation = "NOR";
				type = "R";
				break;
			case XOR_END:
				operation = "XOR";
				type = "R";
				break;
			case JR_END:
				operation = "JR";
				type = "R";
				break;
			case MFHI_END:
				operation = "MFHI";
				type = "R";
				break;
			case MFLO_END:
				operation = "MFLO";
				type = "R";
				break;
			case ADDU_END:
				operation = "ADDU";
				type = "R";
				break;
			case SUBU_END:
				operation = "SUBU";
				type = "R";
				break;
			case MULT_END:
				operation = "MULT";
				type = "R";
				break;
			case SLL:
				operation = "SLL";
				type = "R";
				break;
			case SRL_END:
				operation = "SRL";
				type = "R";
				break;
			case SRA_END:
				operation = "SRA";
				type = "R";
				break;
			case SRLV_END:
				operation = "SRLV";
				type = "R";
				break;
			case SRAV_END:
				operation = "SRAV";
				type = "R";
				break;
			case SYSCALL_END:
				operation = "SYSCALL";
				break;
		}
		if(type != null){
			setType(type);
		}
		return operation;
	}
	
	public void verifyOperationType(String instructionBin){
		String operation = null;
		String type = null;
		
		switch(instructionBin.substring(0, 6)){
			case "000000":
				operation = verifyOperationSubType(instructionBin);
				break;
			case LUI:
				operation = "LUI";
				type = "I";
				break;
			case ADDI:
				operation = "ADDI";
				type = "I";
				break;
			case SLTI:
				operation = "SLTI";
				type = "I";
				break;
			case ANDI:
				operation = "ANDI";
				type = "I";
				break;
			case ORI:
				operation = "ORI";
				type = "I";
				break;
			case XORI:
				operation = "XORI";
				type = "I";
				break;
			case LW:
				operation = "LW";
				type = "I";
				break;
			case SW:
				operation = "SW";
				type = "I";
				break;
			case J:
				operation = "J";
				type = "J";
				break;
			case BLTZ:
				operation = "BLTZ";
				type = "I";
				break;
			case BEQ:
				operation = "BEQ";
				type = "I";
				break;
			case BNE:
				operation = "BNE";
				type = "I";
				break;
			case ADDIU:
				operation = "ADDIU";
				type = "I";
				break;
			case JAL:
				operation = "JAL";
				type = "J";
				break;
		}
		if (type != null) {
			setType(type);
		}
		if(operation != null){
			setOperationName(operation.toLowerCase());
		}

		setupInstructionByType(getType(), getOperationName(), instructionBin);
	}

	public void setupInstructionByType(String type, String operation, String instructionBin){
		String inst = operation;

		if(type == "R"){
			setRs(" $" + instructionBin.substring(6, 11) + ",");
			setRd(" $" + instructionBin.substring(11, 16) + ",");
			setRt(" $" + instructionBin.substring(16, 21));
		}
		else if(type == "I"){
			//TODO
		}
		else if(type == "J"){
			//TODO
		}

	}

	public String printInstByType(String type) {
		if (type == "R") {
			return this.getOperationName().concat(this.getRs()).concat(this.getRd()).concat(this.getRt());
		} else if (type == "I") {
			return null;
		} else if (type == "J") {
			return null;
		}
		return null;
	}
}
