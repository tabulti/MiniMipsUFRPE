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
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
        this.sh = sh;
        this.func = func;
    }

    public String getAssembly() {
        String assembly = "";
        String registerRs = "$" + Utils.binToDecimal(this.rs);
        String registerRt = "$" + Utils.binToDecimal(this.rt);
        String registerRd = "$" + Utils.binToDecimal(this.rd);
        String shift = Utils.binToDecimal(this.sh);

        switch (this.func) {
            //Adição
            case Consts.ADD_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //Adição(Unsigned)
            case Consts.ADDU_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //Subtração
            case Consts.SUB_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //Subtração (Unsigned)
            case Consts.SUBU_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //OR
            case Consts.OR_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //AND
            case Consts.AND_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //NOR
            case Consts.NOR_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //XOR
            case Consts.XOR_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //Multiplicação
            case Consts.MULT_END:
                assembly = this.instructionName + " " + registerRs + ", " + registerRt;
                break;
            //Multiplicação (Unsigned)
            case Consts.MULTU_END:
                assembly = this.instructionName + " " + registerRs + ", " + registerRt;
                break;
            //Divisão
            case Consts.DIV_END:
                assembly = this.instructionName + " " + registerRs + ", " + registerRt;
                break;
            //Divisão (Unsigned)
            case Consts.DIVU_END:
                assembly = this.instructionName + " " + registerRs + ", " + registerRt;
                break;
            //Move from HI
            case Consts.MFHI_END:
                assembly = this.instructionName + " " + registerRd;
                break;
            //Move from LO
            case Consts.MFLO_END:
                assembly = this.instructionName + " " + registerRd;
                break;
            //Set Less Than
            case Consts.SLT_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRs + ", " + registerRt;
                break;
            //Shif Left Logical
            case Consts.SLL_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRt + ", " + shift;
                break;

            case Consts.SLLV_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRt + ", " + registerRs;
                break;
            //Shift Right Logical
            case Consts.SRL_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRt + ", " + shift;
                break;
            //Shift Right Logical Variable
            case Consts.SRLV_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRt + ", " + registerRs;
                break;
            //Shift Right Arithmetic
            case Consts.SRA_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRt + ", " + shift;
                break;
            //Shift Right Arithmetic Variable
            case Consts.SRAV_END:
                assembly = this.instructionName + " " + registerRd + ", " + registerRt + ", " + registerRs;
                break;
            //Jump Register
            case Consts.JR_END:
                assembly = this.instructionName + " " + registerRs;
                break;
        }
        return assembly;
    }
}
