package basico;

/**
 * Created by Joao Paulo Ribeiro on 08/09/2016.
 */


public class Instruction {
    private String rs;
    private String rd;
    private String rt;
    private String imm;
    private String type;
    private String operationName = null;
    private int qtdRegistres = 0;
    private boolean hasImmediate = false;

    public Instruction() {
        this.operationName = null;
        this.type = null;
        this.rs = null;
        this.rd = null;
        this.rt = null;
        this.imm = null;
        this.qtdRegistres = 0;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public String getType() {
        return this.type;
    }

    public String getRs() {
        return this.rs;
    }

    public String getRd() {
        return this.rd;
    }

    public String getRt() {
        return this.rt;
    }

    public String getImm() {
        return imm;
    }

    public void setImm(String imm) {
        this.imm = imm;
    }

    public int getQtdRegistres() {
        return this.qtdRegistres;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public void setQtdRegistrers(int qtd) {
        this.qtdRegistres = qtdRegistres;
    }


    /**
     * Método que seta os parametros de uma instrução de acordo com os subtipos
     * da operação "000000"
     *
     * @param instructionBin
     * @return
     */
    public String verifyOperationSubType(String instructionBin) {
        String operation = null;
        String type = null;
        int qtd_registres = 0;


        switch (instructionBin.substring(26, 32)) {
            case Consts.ADD_END:
                operation = "add";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("add" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.AND_END:
                operation = "and";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("and" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.SUB_END:
                operation = "sub";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("sub" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.SLT_END:
                operation = "slt";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("slt" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.OR_END:
                operation = "or";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("or" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.NOR_END:
                operation = "nor";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("nor" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.XOR_END:
                operation = "xor";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("xor" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;
            case Consts.JR_END:
                operation = "jr";
                type = Consts.TYPE_R;
                System.out.println("jr" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                break;
            case Consts.MFHI_END:
                operation = "mfhi";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_1_REGISTRERS;
                System.out.println("mfhi" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)));
                break;
            case Consts.MFLO_END:
                operation = "mflo";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_1_REGISTRERS;
                System.out.println("mflo" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)));
                break;
            case Consts.ADDU_END:
                operation = "addu";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("addu" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.SUBU_END:
                operation = "subu";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("subu" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.MULT_END:
                operation = "mult";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                System.out.println("mult" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;
            case Consts.MULTU_END:
                operation = "mult";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                System.out.println("multu" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;
            case Consts.SLL:
                operation = "sll";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("sll" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                break;

            case Consts.SRL_END:
                operation = "srl";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("srl" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                break;

            case Consts.SRA_END:
                operation = "sra";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("sra" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                break;

            case Consts.SRLV_END:
                operation = "srlv";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("srlv" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.SRAV_END:
                operation = "srav";
                type = Consts.TYPE_R;
                qtd_registres = Consts.TYPE_3_REGISTRERS;
                System.out.println("srav" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                break;

            case Consts.SYSCALL_END:
                operation = "syscall";
                System.out.println("syscall");
                break;
        }
        if (type != null) {
            this.setType(type);
        }
        if (qtd_registres != 0) {
            this.setQtdRegistrers(qtd_registres);
        }
        return operation;
    }

    /**
     * Metodo que verifica o tipo da operação e seta os parametros da instrução
     *
     * @param instructionBin
     */
    public void verifyOperationType(String instructionBin) {
        String operation = null;
        String type = null;
        String fullInstruction = "";
        int qtd_registres = 0;


        switch (instructionBin.substring(0, 6)) {
            case "000000":
                operation = verifyOperationSubType(instructionBin);
                break;
            case Consts.LUI:
                operation = "lui";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_1_REGISTRERS;
                hasImmediate = true;
                System.out.println("lui" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " +
                        Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            case Consts.ADDI:
                operation = "addi";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                hasImmediate = true;
                System.out.println("addi" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            case Consts.SLTI:
                operation = "slti";
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                hasImmediate = true;
                type = Consts.TYPE_I;
                System.out.println("slti" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            case Consts.ANDI:
                operation = "andi";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                hasImmediate = true;
                System.out.println("andi" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            case Consts.ORI:
                operation = "ori";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                hasImmediate = true;
                System.out.println("ori" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            case Consts.XORI:
                operation = "xori";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                hasImmediate = true;
                System.out.println("xori" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            //TODO: lw $1, 100($2)
            case Consts.LW:
                operation = "lw";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_1_REGISTRERS;
                System.out.println("lw" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                break;
            //TODO: sw $1, 100($2)
            case Consts.SW:
                operation = "sw";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_1_REGISTRERS;
                System.out.println("sw" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                break;
            //TODO: j start
            case Consts.J:
                operation = "j";
                type = Consts.TYPE_J;
                System.out.println("j " + Utils.binToDecimal(instructionBin.substring(6, 32)));
                break;
            //TODO: bltz $1, start
            case Consts.BLTZ:
                operation = "bltz";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_1_REGISTRERS;
                System.out.println("bltz" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            //TODO: beq $1, $2, start
            case Consts.BEQ:
                operation = "beq";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                System.out.println("beq" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            //TODO: bne $1, $2, start
            case Consts.BNE:
                operation = "bne";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                System.out.println("bne" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            case Consts.ADDIU:
                operation = "addiu";
                type = Consts.TYPE_I;
                qtd_registres = Consts.TYPE_2_REGISTRERS;
                hasImmediate = true;
                System.out.println("addiu" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                break;
            //TODO: jal start
            case Consts.JAL:
                operation = "jal";
                type = Consts.TYPE_J;
                System.out.println("jal " + Utils.binToDecimal(instructionBin.substring(6, 32)));
                break;
        }
        if (type != null) {
            this.setType(type);
        }
        if (operation != null) {
            this.setOperationName(operation);
        }
        if (qtd_registres != 0) {
            this.setQtdRegistrers(qtd_registres);
        }
    }

    /**
     * Método que extrai 3 registradores de uma instrução tipo R
     * convertendo-os para o formato decimal
     *
     * @param instructionBin
     */
    public void setupInstructionTypeR3Registrers(String instructionBin) {
        this.setRs(" " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ",");
        this.setRt(" " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ",");
        this.setRd(" " + "$" + Utils.binToDecimal(instructionBin.substring(16, 21)));
    }

}
