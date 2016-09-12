package basico;

/**
 * Created by Joao Paulo Ribeiro on 08/09/2016.
 */


public class Instruction {


    /**
     * Método que seta os parametros de uma instrução de acordo com os subtipos
     * da operação "000000"
     *
     * @param instructionBin
     * @return
     */
    public String verifyOperationSubType(String instructionBin) {
        String assemblyInstruction = "";


        switch (instructionBin.substring(26, 32)) {
            case Consts.ADD_END:

                assemblyInstruction = ("add" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;
            case Consts.AND_END:

                assemblyInstruction = ("and" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.SUB_END:

                assemblyInstruction = ("sub" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.SLT_END:

                assemblyInstruction = ("slt" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;
            case Consts.OR_END:
                assemblyInstruction = ("or" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;
            case Consts.NOR_END:

                assemblyInstruction = ("nor" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.XOR_END:

                assemblyInstruction = ("xor" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;
            case Consts.JR_END:

                assemblyInstruction = ("jr" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                return assemblyInstruction;
            case Consts.MFHI_END:

                assemblyInstruction = ("mfhi" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)));
                return assemblyInstruction;
            case Consts.MFLO_END:
                assemblyInstruction = ("mflo" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)));
                return assemblyInstruction;
            case Consts.ADDU_END:

                assemblyInstruction = ("addu" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;
            case Consts.SUBU_END:

                assemblyInstruction = ("subu" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.MULT_END:

                assemblyInstruction = ("mult" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;
            case Consts.MULTU_END:

                assemblyInstruction = ("multu" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;
            case Consts.DIV_END:

                assemblyInstruction = ("div" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;
            case Consts.SLL_END:

                assemblyInstruction = ("sll" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                return assemblyInstruction;
            case Consts.SLLV_END:

                assemblyInstruction = ("sllv" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)));

                return assemblyInstruction;
            case Consts.SRL_END:

                assemblyInstruction = ("srl" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                return assemblyInstruction;

            case Consts.SRA_END:

                assemblyInstruction = ("sra" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                return assemblyInstruction;

            case Consts.SRLV_END:

                assemblyInstruction = ("srlv" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                return assemblyInstruction;

            case Consts.SRAV_END:

                assemblyInstruction = ("srav" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)));

                return assemblyInstruction;
            case Consts.SYSCALL_END:
                assemblyInstruction = "syscall";
                return assemblyInstruction;

        }
        return null;
    }

    /**
     * Metodo que verifica o tipo da operação e seta os parametros da instrução
     *
     * @param instructionBin
     */
    public String verifyOperationType(String instructionBin) {

        String assemblyInstruction = "";


        switch (instructionBin.substring(0, 6)) {
            case "000000":
                assemblyInstruction = verifyOperationSubType(instructionBin);
                return assemblyInstruction;
            case Consts.LUI:

                assemblyInstruction = "lui" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " +
                        Utils.binToDecimal(instructionBin.substring(16, 32));
                return assemblyInstruction;

            case Consts.ADDI:

                assemblyInstruction = "addi" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32));
                return assemblyInstruction;
            case Consts.SLTI:

                assemblyInstruction = "slti" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32));
                return assemblyInstruction;

            case Consts.ANDI:

                assemblyInstruction = "andi" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32));
                return assemblyInstruction;
            case Consts.ORI:

                assemblyInstruction = ("ori" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                return assemblyInstruction;
            case Consts.XORI:

                assemblyInstruction = ("xori" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                return assemblyInstruction;

            case Consts.LW:

                assemblyInstruction = ("lw" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                return assemblyInstruction;

            case Consts.SW:

                assemblyInstruction = ("sw" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                return assemblyInstruction;
            case Consts.J:

                assemblyInstruction = ("j " + Utils.binToDecimal(instructionBin.substring(6, 32)));
                return assemblyInstruction;

            case Consts.BLTZ:

                assemblyInstruction = ("bltz" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)));

                return assemblyInstruction;
            case Consts.BEQ:

                assemblyInstruction = ("beq" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32)));
                return assemblyInstruction;

            case Consts.BNE:

                assemblyInstruction = "bne" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32));

                return assemblyInstruction;

            case Consts.ADDIU:

                assemblyInstruction = "addiu" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + Utils.binToDecimal(instructionBin.substring(16, 32));

                return assemblyInstruction;


            case Consts.JAL:

                assemblyInstruction = "jal " + Utils.binToDecimal(instructionBin.substring(6, 32));
                return assemblyInstruction;
            case Consts.LB:

                assemblyInstruction = "lb" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")";
                return assemblyInstruction;
            case Consts.LBU:

                assemblyInstruction = ("lbu" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                return assemblyInstruction;
            case Consts.SB:

                assemblyInstruction = ("sb" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                return assemblyInstruction;
        }
        return null;
    }

}
