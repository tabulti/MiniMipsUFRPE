package basico;

public class Decodificador {

    public Object decodificarSubTipo(String instrucaoBinaria) {
        R typeR;
        String opCode = instrucaoBinaria.substring(0, 6);
        String rs = instrucaoBinaria.substring(6, 11);
        String rt = instrucaoBinaria.substring(11, 16);
        String rd = instrucaoBinaria.substring(16, 21);
        String sh = instrucaoBinaria.substring(21, 26);
        String func = instrucaoBinaria.substring(26, 32);

        switch (func) {

            case Consts.ADD_END:
                typeR = new R("add", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.AND_END:
                typeR = new R("and", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SUB_END:
                typeR = new R("sub", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SLT_END:
                typeR = new R("slt", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.OR_END:
                typeR = new R("or", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.NOR_END:
                typeR = new R("nor", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.XOR_END:
                typeR = new R("xor", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.JR_END:
                typeR = new R("jr", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.MFHI_END:
                typeR = new R("mfhi", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.MFLO_END:
                typeR = new R("mflo", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.ADDU_END:
                typeR = new R("addu", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SUBU_END:
                typeR = new R("subu", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.MULT_END:
                typeR = new R("mult", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.MULTU_END:
                typeR = new R("multu", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.DIV_END:
                typeR = new R("div", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.DIVU_END:
                typeR = new R("divu", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SLL_END:
                typeR = new R("sll", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SLLV_END:
                typeR = new R("sllv", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SRL_END:
                typeR = new R("srl", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SRA_END:
                typeR = new R("sra", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SRLV_END:
                typeR = new R("srlv", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SRAV_END:
                typeR = new R("srav", opCode, rs, rt, rd, sh, func);
                return typeR;

            case Consts.SYSCALL_END:
                String syscall = new String("syscall");
                return syscall;

        }
        return null;
    }


    public Object decodificar(String instrucaoBinaria) {
        I typeI;
        J typeJ;
        String opCode = instrucaoBinaria.substring(0, 6);
        String rs = instrucaoBinaria.substring(6, 11);
        String rt = instrucaoBinaria.substring(11, 16);
        String rd = instrucaoBinaria.substring(16, 21);
        String imm = instrucaoBinaria.substring(16, 32);
        String adress = instrucaoBinaria.substring(6, 32);

        switch (opCode) {

            case "000000":
                return decodificarSubTipo(instrucaoBinaria);

            case Consts.LUI:
                typeI = new I("lui", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.ADDI:
                typeI = new I("addi", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.SLTI:
                typeI = new I("slti", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.ANDI:
                typeI = new I("andi", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.ORI:
                typeI = new I("ori", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.XORI:
                typeI = new I("xori", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.LW:
                typeI = new I("lw", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.SW:
                typeI = new I("sw", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.J:
                typeJ = new J("j", opCode, adress);
                return typeJ;

            case Consts.BLTZ:
                typeI = new I("bltz", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.BEQ:
                typeI = new I("beq", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.BNE:
                typeI = new I("bne", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.ADDIU:
                typeI = new I("addiu", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.JAL:
                typeJ = new J("jal", opCode, adress);
                return typeJ;

            case Consts.LB:
                typeI = new I("lb", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.LBU:
                typeI = new I("lbu", opCode, rd, rs, rt, imm);
                return typeI;

            case Consts.SB:
                typeI = new I("sb", opCode, rd, rs, rt, imm);
                return typeI;
        }
        return null;
    }


}
