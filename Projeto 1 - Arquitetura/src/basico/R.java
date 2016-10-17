package basico;

public class R {

    private String instructionName;
    private String opCode;
    private String func;
    private String rd;
    private String rs;
    private String rt;
    private String sh;

    R(String instructionName, String opCode, String rs, String rt, String rd, String sh, String func) {
        this.instructionName = instructionName;
        this.opCode = opCode;
        this.rs = "$" + Utils.binToDecimal(rs);
        this.rt = "$" + Utils.binToDecimal(rt);
        this.rd = "$" + Utils.binToDecimal(rd);
        this.sh = Utils.binToDecimal(sh);
        this.func = func;
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

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
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

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getAssembly() {
        String assembly = "";

        switch (this.func) {
            //Adição
            case Consts.ADD_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //Adição(Unsigned)
            case Consts.ADDU_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //Subtração
            case Consts.SUB_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //Subtração (Unsigned)
            case Consts.SUBU_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //OR
            case Consts.OR_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //AND
            case Consts.AND_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //NOR
            case Consts.NOR_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //XOR
            case Consts.XOR_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //Multiplicação
            case Consts.MULT_END:
                assembly = this.instructionName + " " + rs + ", " + rt;
                break;
            //Multiplicação (Unsigned)
            case Consts.MULTU_END:
                assembly = this.instructionName + " " + rs + ", " + rt;
                break;
            //Divisão
            case Consts.DIV_END:
                assembly = this.instructionName + " " + rs + ", " + rt;
                break;
            //Divisão (Unsigned)
            case Consts.DIVU_END:
                assembly = this.instructionName + " " + rs + ", " + rt;
                break;
            //Move from HI
            case Consts.MFHI_END:
                assembly = this.instructionName + " " + rd;
                break;
            //Move from LO
            case Consts.MFLO_END:
                assembly = this.instructionName + " " + rd;
                break;
            //Set Less Than
            case Consts.SLT_END:
                assembly = this.instructionName + " " + rd + ", " + rs + ", " + rt;
                break;
            //Shif Left Logical
            case Consts.SLL_END:
                assembly = this.instructionName + " " + rd + ", " + rt + ", " + sh;
                break;

            case Consts.SLLV_END:
                assembly = this.instructionName + " " + rd + ", " + rt + ", " + rs;
                break;
            //Shift Right Logical
            case Consts.SRL_END:
                assembly = this.instructionName + " " + rd + ", " + rt + ", " + sh;
                break;
            //Shift Right Logical Variable
            case Consts.SRLV_END:
                assembly = this.instructionName + " " + rd + ", " + rt + ", " + rs;
                break;
            //Shift Right Arithmetic
            case Consts.SRA_END:
                assembly = this.instructionName + " " + rd + ", " + rt + ", " + sh;
                break;
            //Shift Right Arithmetic Variable
            case Consts.SRAV_END:
                assembly = this.instructionName + " " + rd + ", " + rt + ", " + rs;
                break;
            //Jump Register
            case Consts.JR_END:
                assembly = this.instructionName + " " + rs;
                break;
        }
        return assembly;
    }
}
