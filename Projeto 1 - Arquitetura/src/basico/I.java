package basico;

public class I {

    private String instructionName;
    private String opCode;
    private String rd;
    private String rs;
    private String rt;
    private String imm;

    public I(String instructionName, String opCode, String rd, String rs, String rt, String imm) {
        this.instructionName = instructionName;
        this.opCode = opCode;
        this.rd = rd;
        this.rs = rs;
        this.rt = rt;
        this.imm = imm;
    }

    public String getAssemly() {
        String assembly = "";
        String registerRd = "$" + Utils.binToDecimal(rd);
        String registerRs = "$" + Utils.binToDecimal(rs);
        String registerRt = "$" + Utils.binToDecimal(rt);
        short immediate = (short) Integer.parseInt(imm, 2);
        switch (opCode) {
            //Load Uper Immediate
            case Consts.LUI:
                assembly = instructionName + " " + registerRt + ", " + immediate;
                break;
            //Adição com Imediato
            case Consts.ADDI:
                assembly = instructionName + " " + registerRt + ", " + registerRs + ", " + immediate;
                break;
            //Adição (Imediato Unsigned)
            case Consts.ADDIU:
                assembly = instructionName + " " + registerRt + ", " + registerRs + ", " + immediate;
                break;
            //Set less than imediate
            case Consts.SLTI:
                assembly = instructionName + " " + registerRt + ", " + registerRs + ", " + immediate;
                break;
            //AND (Imediato)
            case Consts.ANDI:
                assembly = instructionName + " " + registerRt + ", " + registerRs + ", " + immediate;
                break;
            //OR (Imediato)
            case Consts.ORI:
                assembly = instructionName + " " + registerRt + ", " + registerRs + ", " + immediate;
                break;
            //XOR (Imediato)
            case Consts.XORI:
                assembly = instructionName + " " + registerRt + ", " + registerRs + ", " + immediate;
                break;
            //Load Byte
            case Consts.LB:
                assembly = instructionName + " " + registerRt + ", " + immediate + "(" + registerRs + ")";
                break;
            //Load Byte (Unsigned)
            case Consts.LBU:
                assembly = instructionName + " " + registerRt + ", " + immediate + "(" + registerRs + ")";
                break;
            //Store Byte
            case Consts.SB:
                assembly = instructionName + " " + registerRt + ", " + immediate + "(" + registerRs + ")";
                break;

            //Store Word
            case Consts.SW:
                assembly = instructionName + " " + registerRt + ", " + immediate + "(" + registerRs + ")";
                break;
            //Load Word
            case Consts.LW:
                assembly = instructionName + " " + registerRt + ", " + immediate + "(" + registerRs + ")";
                break;
            //Branch equals
            case Consts.BEQ:
                assembly = instructionName + " " + registerRs + ", " + registerRt + ", " + immediate;
                break;
            //Branch not equals
            case Consts.BNE:
                assembly = instructionName + " " + registerRs + ", " + registerRt + ", " + immediate;
                break;
            //Branch less than zero
            case Consts.BLTZ:
                assembly = instructionName + " " + registerRs + ", " + immediate;
                break;
        }
        return assembly;
    }
}
