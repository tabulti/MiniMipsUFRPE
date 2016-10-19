package basico;

import java.math.BigInteger;

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
        Integer HI = 0;
        Integer LO = 0;
        BigInteger hi;
        BigInteger lo;
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
                    //TODO (CHECK)
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
                    //TODO (CHECK)
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
                    resultado = valorRs * valorRt;
                    String bin = Integer.toBinaryString(resultado);
                    //Bit Mais Significativo
                    char firstChar = bin.charAt(0);
                    StringBuffer result = new StringBuffer();
                    for (int i = 1; i <= (64 - bin.length()); i++) {
                        if (firstChar == '0') {
                            result.append("0");
                        } else {
                            result.append("1");
                        }

                    }
                    result.append(bin);
                    hi = new BigInteger(result.toString().substring(0, 32),2);
                    lo = new BigInteger(result.toString().substring(32, 64),2);

                    registradores.setValor("HI", Integer.valueOf(hi.shortValue()));
                    registradores.setValor("LO", Integer.valueOf(lo.shortValue()));
                    break;

                //Multiplicação (Unsigned)
                case Consts.MULTU_END:
                    //TODO (CHECK)
                    break;

                //Divisão
                case Consts.DIV_END:
                    LO = valorRs / valorRt;
                    HI = valorRs % valorRt;
                    registradores.setValor("HI", HI);
                    registradores.setValor("LO", LO);
                    break;

                //Divisão (Unsigned)
                case Consts.DIVU_END:
                    //TODO (CHECK)
                    LO = valorRs / valorRt;
                    HI = valorRs % valorRt;
                    registradores.setValor("HI", HI);
                    registradores.setValor("LO", LO);
                    break;

                //Move from HI
                case Consts.MFHI_END:
                    HI = registradores.getValor("HI");
                    registradores.setValor(rd, HI);
                    break;

                //Move from LO
                case Consts.MFLO_END:
                    LO = registradores.getValor("LO");
                    registradores.setValor(rd, LO);
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
                    resultado = valorRt >>> shift;
                    registradores.setValor(rd, resultado);
                    break;

                //Shift Right Logical Variable
                case Consts.SRLV_END:
                    resultado = valorRt >>> valorRs;
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
                    //TODO (CHECK)
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
