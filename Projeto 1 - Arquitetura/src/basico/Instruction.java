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
            case Consts.ADD_END: //ADD
                assemblyInstruction = ("add" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " +
                        "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;

            case Consts.AND_END: //AND
                assemblyInstruction = ("and" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " +
                        "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.SUB_END: //SUB
                assemblyInstruction = ("sub" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " +
                        "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.SLT_END: //SLT
                assemblyInstruction = ("slt" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;

            case Consts.OR_END: //OR
                assemblyInstruction = ("or" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " +
                        "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;

            case Consts.NOR_END: //NOR
                assemblyInstruction = ("nor" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.XOR_END: //XOR
                assemblyInstruction = ("xor" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.JR_END: //JR
                assemblyInstruction = ("jr" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                return assemblyInstruction;

            case Consts.MFHI_END: //MFHI
                assemblyInstruction = ("mfhi" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)));
                return assemblyInstruction;

            case Consts.MFLO_END: //MFLO
                assemblyInstruction = ("mflo" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)));
                return assemblyInstruction;

            case Consts.ADDU_END: //ADDU
                assemblyInstruction = ("addu" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));

                return assemblyInstruction;

            case Consts.SUBU_END: //SUBU
                assemblyInstruction = ("subu" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.MULT_END: //MULT
                assemblyInstruction = ("mult" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.MULTU_END: //MULTU
                assemblyInstruction = ("multu" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.DIV_END: //DIV
                assemblyInstruction = ("div" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.DIVU_END: //DIVU
                assemblyInstruction = ("multu" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + "$"
                        + Utils.binToDecimal(instructionBin.substring(11, 16)));
                return assemblyInstruction;

            case Consts.SLL_END: //SSL
                assemblyInstruction = ("sll" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                return assemblyInstruction;

            case Consts.SLLV_END: //SLLV
                assemblyInstruction = ("sllv" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                return assemblyInstruction;

            case Consts.SRL_END: //SRL
                assemblyInstruction = ("srl" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                return assemblyInstruction;

            case Consts.SRA_END: //SRA
                assemblyInstruction = ("sra" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "" + Utils.binToDecimal(instructionBin.substring(21, 26)));
                return assemblyInstruction;

            case Consts.SRLV_END: //SRLV
                assemblyInstruction = ("srlv" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                return assemblyInstruction;

            case Consts.SRAV_END: //SRAV
                assemblyInstruction = ("srav" + " $" + Utils.binToDecimal(instructionBin.substring(16, 21)) + ", " + "$" + Utils.binToDecimal(instructionBin.substring(11, 16))
                        + ", " + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)));
                return assemblyInstruction;

            case Consts.SYSCALL_END: //SYSCALL
                assemblyInstruction = "syscall";
                return assemblyInstruction;

        }
        return null;
    }

    /**
     * Metodo que verifica o tipo da operação e seta os parametros da instrução
     * @param instructionBin
     */
    public String verifyOperationType(String instructionBin) {
        String opCode = "";
        String rs = "";
        String rt = "";
        String rd = "";
        String sh = "";
        String func = "";
        String assemblyInstruction = "";

        switch (instructionBin.substring(0, 6)) {
            case "000000":
                assemblyInstruction = verifyOperationSubType(instructionBin);
                return assemblyInstruction;
            case Consts.LUI: //LUI
                assemblyInstruction = "lui" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " +
                        (short) Integer.parseInt(instructionBin.substring(16, 32), 2);
                return assemblyInstruction;

            case Consts.ADDI: //ADDI
                assemblyInstruction = "addi" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2);
                return assemblyInstruction;

            case Consts.SLTI: //SLTI
                assemblyInstruction = "slti" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2);
                return assemblyInstruction;

            case Consts.ANDI: //ANDI
                assemblyInstruction = "andi" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2);
                return assemblyInstruction;

            case Consts.ORI: //ORI
                assemblyInstruction = ("ori" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2));
                return assemblyInstruction;

            case Consts.XORI: //XORI
                assemblyInstruction = ("xori" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2));
                return assemblyInstruction;

            case Consts.LW: //LW
                assemblyInstruction = ("lw" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + (short) Integer.parseInt(instructionBin.substring(6, 11), 2)) + ")";
                return assemblyInstruction;

            case Consts.SW: //SW
                assemblyInstruction = ("sw" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + Utils.binToDecimal(instructionBin.substring(16, 32)) + "($" + (short) Integer.parseInt(instructionBin.substring(6, 11), 2)) + ")";
                return assemblyInstruction;

            case Consts.J: //J
                assemblyInstruction = ("j " + Utils.binToDecimal(instructionBin.substring(6, 32)));
                return assemblyInstruction;

            case Consts.BLTZ: //BLTZ
                assemblyInstruction = ("bltz" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + (short) Integer.parseInt(instructionBin.substring(16, 32), 2));
                return assemblyInstruction;

            case Consts.BEQ: //BEQ
                assemblyInstruction = ("beq" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2));
                return assemblyInstruction;

            case Consts.BNE: //BNE
                assemblyInstruction = "bne" + " $" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2);
                return assemblyInstruction;

            case Consts.ADDIU: //ADDIU
                assemblyInstruction = "addiu" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + "$" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ", " + (short) Integer.parseInt(instructionBin.substring(16, 32), 2);
                return assemblyInstruction;

            case Consts.JAL: //JAL
                assemblyInstruction = "jal " + Utils.binToDecimal(instructionBin.substring(6, 32));
                return assemblyInstruction;

            case Consts.LB: //LB
                assemblyInstruction = "lb" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + (short) Integer.parseInt(instructionBin.substring(16, 32), 2) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")";
                return assemblyInstruction;

            case Consts.LBU: //LBU
                assemblyInstruction = ("lbu" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + (short) Integer.parseInt(instructionBin.substring(16, 32), 2) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                return assemblyInstruction;

            case Consts.SB: //SB
                assemblyInstruction = ("sb" + " $" + Utils.binToDecimal(instructionBin.substring(11, 16)) + ", "
                        + (short) Integer.parseInt(instructionBin.substring(16, 32), 2) + "($" + Utils.binToDecimal(instructionBin.substring(6, 11)) + ")");
                return assemblyInstruction;
        }
        return null;
    }

}
