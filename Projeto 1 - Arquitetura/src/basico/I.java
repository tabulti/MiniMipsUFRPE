package basico;

public class I {

    private String instructionName;
    private String opCode;
    private String rd;
    private String rs;
    private String rt;
    private short imm;

    public I(String instructionName, String opCode, String rd, String rs, String rt, String imm) {
        this.instructionName = instructionName;
        this.opCode = opCode;
        this.rd = "$" + Utils.binToDecimal(rd);
        this.rs = "$" + Utils.binToDecimal(rs);
        this.rt = "$" + Utils.binToDecimal(rt);
        this.imm = (short) Integer.parseInt(imm, 2);
    }

    public String getInstructionName() {
        return instructionName;
    }

    public void setInstructionName(String instructionName) {
        this.instructionName = instructionName;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public short getImm() {
        return imm;
    }

    public void setImm(short imm) {
        this.imm = imm;
    }

    public String getAssembly() {
        String assembly = "";
        switch (opCode) {
            //Load Uper Immediate
            case Consts.LUI:
                assembly = instructionName + " " + rt + ", " + imm;
                break;
            //Adição com Imediato
            case Consts.ADDI:
                assembly = instructionName + " " + rt + ", " + rs + ", " + imm;
                break;
            //Adição (Imediato Unsigned)
            case Consts.ADDIU:
                assembly = instructionName + " " + rt + ", " + rs + ", " + imm;
                break;
            //Set less than imediate
            case Consts.SLTI:
                assembly = instructionName + " " + rt + ", " + rs + ", " + imm;
                break;
            //AND (Imediato)
            case Consts.ANDI:
                assembly = instructionName + " " + rt + ", " + rs + ", " + imm;
                break;
            //OR (Imediato)
            case Consts.ORI:
                assembly = instructionName + " " + rt + ", " + rs + ", " + imm;
                break;
            //XOR (Imediato)
            case Consts.XORI:
                assembly = instructionName + " " + rt + ", " + rs + ", " + imm;
                break;
            //Load Byte
            case Consts.LB:
                assembly = instructionName + " " + rt + ", " + imm + "(" + rs + ")";
                break;
            //Load Byte (Unsigned)
            case Consts.LBU:
                assembly = instructionName + " " + rt + ", " + imm + "(" + rs + ")";
                break;
            //Store Byte
            case Consts.SB:
                assembly = instructionName + " " + rt + ", " + imm + "(" + rs + ")";
                break;

            //Store Word
            case Consts.SW:
                assembly = instructionName + " " + rt + ", " + imm + "(" + rs + ")";
                break;
            //Load Word
            case Consts.LW:
                assembly = instructionName + " " + rt + ", " + imm + "(" + rs + ")";
                break;
            //Branch equals
            case Consts.BEQ:
                assembly = instructionName + " " + rs + ", " + rt + ", " + imm;
                break;
            //Branch not equals
            case Consts.BNE:
                assembly = instructionName + " " + rs + ", " + rt + ", " + imm;
                break;
            //Branch less than zero
            case Consts.BLTZ:
                assembly = instructionName + " " + rs + ", " + imm;
                break;
        }
        return assembly;
    }
}
