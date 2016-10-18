package basico;

import com.sun.xml.internal.bind.v2.TODO;

public class ULA {

    private static ULA instance;
    private BancoRegistradores registradores = BancoRegistradores.getInstance();

    public static ULA getInstance() {
        if (instance == null) {
            instance = new ULA();
        }
        return instance;
    }

    public String executarInstrucao(Object instrucao) {
        Integer resultado = 0;
        if (instrucao instanceof R) {
            R typeR = (R) instrucao;
            String func = typeR.getFunc();
            String rd = typeR.getRd();
            Integer valorRs = registradores.getValor(typeR.getRs());
            Integer valorRt = registradores.getValor(typeR.getRt());
            Integer shift = Integer.parseInt(typeR.getSh());
            switch (func) {
                //Adição
                case Consts.ADD_END:
                    resultado = valorRs + valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //Adição(Unsigned)
                case Consts.ADDU_END:
                    resultado = valorRs + valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //Subtração
                case Consts.SUB_END:
                    resultado = valorRs - valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //Subtração (Unsigned)
                case Consts.SUBU_END:
                    resultado = valorRs - valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //OR
                case Consts.OR_END:
                    resultado = valorRs | valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //AND
                case Consts.AND_END:
                    resultado = valorRs & valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //NOR
                case Consts.NOR_END:
                    resultado = ~(valorRs | valorRt);
                    registradores.setValor(rd, resultado);
                    break;

                //XOR
                case Consts.XOR_END:
                    resultado = valorRs ^ valorRt;
                    registradores.setValor(rd, resultado);
                    break;

                //Multiplicação
                case Consts.MULT_END:
                    //TODO
                    break;

                //Multiplicação (Unsigned)
                case Consts.MULTU_END:
                    //TODO
                    break;

                //Divisão
                case Consts.DIV_END:
                    //TODO
                    break;

                //Divisão (Unsigned)
                case Consts.DIVU_END:
                    //TODO
                    break;

                //Move from HI
                case Consts.MFHI_END:
                    //TODO
                    break;

                //Move from LO
                case Consts.MFLO_END:
                    //TODO
                    break;

                //Set Less Than
                case Consts.SLT_END:
                    resultado = 0;
                    if (valorRs < valorRt) {
                        resultado = 1;
                    }
                    registradores.setValor(rd, resultado);
                    break;

                //Shif Left Logical
                case Consts.SLL_END:
                    resultado = valorRt << shift;
                    registradores.setValor(rd, resultado);
                    break;

                //Shift left logical variable
                case Consts.SLLV_END:
                    resultado = valorRt << valorRs;
                    registradores.setValor(rd, resultado);
                    break;

                //Shift Right Logical
                case Consts.SRL_END:
                    resultado = valorRt >> shift;
                    registradores.setValor(rd, resultado);
                    break;

                //Shift Right Logical Variable
                case Consts.SRLV_END:
                    resultado = valorRt >> valorRs;
                    registradores.setValor(rd, resultado);
                    break;

                //Shift Right Arithmetic
                case Consts.SRA_END:
                    resultado = valorRt >> shift;
                    registradores.setValor(rd, resultado);
                    break;

                //Shift Right Arithmetic Variable
                case Consts.SRAV_END:
                    resultado = valorRt >> valorRs;
                    registradores.setValor(rd, resultado);
                    break;

                //Jump Register
                case Consts.JR_END:
                    //TODO (JUMP TO RS)
                    break;
            }


        } else if (instrucao instanceof I) {
            I typeI = (I) instrucao;
            String opCode = typeI.getOpCode();
            String rt = typeI.getRt();
            Integer valorRs = registradores.getValor(typeI.getRs());
            Integer valorRt = registradores.getValor(typeI.getRt());
            short imediato = typeI.getImm();
            switch (opCode) {
                //Load Uper Immediate
                case Consts.LUI:
                    resultado = imediato << 16;
                    registradores.setValor(rt, resultado);
                    break;

                //Adição com Imediato
                case Consts.ADDI:
                    resultado = valorRs + imediato;
                    registradores.setValor(rt, resultado);
                    break;

                //Adição (Imediato Unsigned)
                case Consts.ADDIU:
                    resultado = valorRs + imediato;
                    registradores.setValor(rt, resultado);
                    break;

                //Set less than imediate
                case Consts.SLTI:
                    resultado = 0;
                    if (valorRs < imediato) {
                        resultado = 1;
                    }
                    registradores.setValor(rt, resultado);
                    break;

                //AND (Imediato)
                case Consts.ANDI:
                    resultado = valorRs & imediato;
                    registradores.setValor(rt, resultado);
                    break;

                //OR (Imediato)
                case Consts.ORI:
                    resultado = valorRs | imediato;
                    registradores.setValor(rt, resultado);
                    break;

                //XOR (Imediato)
                case Consts.XORI:
                    resultado = valorRs ^ imediato;
                    registradores.setValor(rt, resultado);
                    break;

                //Load Byte
                case Consts.LB:
                    //TODO
                    break;

                //Load Byte (Unsigned)
                case Consts.LBU:
                    //TODO
                    break;

                //Store Byte
                case Consts.SB:
                    //TODO
                    break;

                //Store Word
                case Consts.SW:
                    //TODO
                    break;

                //Load Word
                case Consts.LW:
                    //TODO
                    break;

                //Branch equals
                case Consts.BEQ:
                    if (valorRs == valorRt) {
                        //GO TO (PC + 4 + IMM)
                    } else {
                        //PC + 4
                    }
                    break;

                //Branch not equals
                case Consts.BNE:
                    if (valorRs != valorRt) {
                        //GO TO (PC + 4 + IMM)
                    } else {
                        //PC + 4
                    }
                    break;

                //Branch less than zero
                case Consts.BLTZ:
                    if (valorRs < 0) {
                        //GO TO (PC + 4 + IMM)
                    } else {
                        //PC + 4
                    }
                    break;
            }
        } else if (instrucao instanceof J) {
            J typeJ = (J) instrucao;
            String opCode = typeJ.getOpCode();
            switch (opCode) {
                //Jump
                case Consts.J:
                    //TODO (JUMP TO ADRESS)
                    break;

                //Jump and Link
                case Consts.JAL:
                    //TODO (GO TO ADRESS AND $31 = PC + 4)
                    break;
            }
        }

        return registradores.showValores();
    }
}
