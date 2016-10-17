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
        if (instrucao instanceof R) {
            R typeR = (R) instrucao;
            String func = typeR.getFunc();
            Integer rd = getRegistrador(typeR.getRd());
            Integer valorRs = registradores.getValor(getRegistrador(typeR.getRs()));
            Integer valorRt = registradores.getValor(getRegistrador(typeR.getRt()));
            switch (func) {
                //Adição
                case Consts.ADD_END:
                    registradores.setValor(rd, valorRs + valorRt);
                    break;
                //Adição(Unsigned)
                case Consts.ADDU_END:
                    registradores.setValor(rd, valorRs + valorRt);
                    break;
                //Subtração
                case Consts.SUB_END:
                    registradores.setValor(rd, valorRs - valorRt);
                    break;
                //Subtração (Unsigned)
                case Consts.SUBU_END:
                    registradores.setValor(rd, valorRs - valorRt);
                    break;
                //OR
                case Consts.OR_END:
                    registradores.setValor(rd, valorRs | valorRt);
                    break;
                //AND
                case Consts.AND_END:
                    registradores.setValor(rd, valorRs & valorRt);
                    break;
                //NOR
                case Consts.NOR_END:
                    registradores.setValor(rd, ~(valorRs | valorRt));
                    break;
                //XOR
                case Consts.XOR_END:
                    registradores.setValor(rd, valorRs ^ valorRt);
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
                    if(valorRs < valorRt){
                        registradores.setValor(rd, 1);
                    }else{
                        registradores.setValor(rd, 0);
                    }
                    break;
                //Shif Left Logical
                case Consts.SLL_END:
                    //TODO
                    break;
                case Consts.SLLV_END:
                    //TODO
                    break;
                //Shift Right Logical
                case Consts.SRL_END:
                    //TODO
                    break;
                //Shift Right Logical Variable
                case Consts.SRLV_END:
                    //TODO
                    break;
                //Shift Right Arithmetic
                case Consts.SRA_END:
                    //TODO
                    break;
                //Shift Right Arithmetic Variable
                case Consts.SRAV_END:
                    //TODO
                    break;
                //Jump Register
                case Consts.JR_END:
                    //TODO (JUMP TO RS)
                    break;
            }


        } else if (instrucao instanceof I) {
            I typeI = (I) instrucao;
            String opCode = typeI.getOpCode();
            Integer rt = getRegistrador(typeI.getRt());
            Integer valorRs = registradores.getValor(getRegistrador(typeI.getRs()));
            Integer valorRt = registradores.getValor(getRegistrador(typeI.getRt()));
            short imediato = typeI.getImm();
            switch (opCode) {
                //Load Uper Immediate
                case Consts.LUI:
                    break;
                //Adição com Imediato
                case Consts.ADDI:
                    registradores.setValor(rt, valorRs + imediato);
                    break;
                //Adição (Imediato Unsigned)
                case Consts.ADDIU:
                    registradores.setValor(rt, valorRs + imediato);
                    break;
                //Set less than imediate
                case Consts.SLTI:
                    if(valorRs < imediato){
                        registradores.setValor(rt, 1);
                    }else{
                        registradores.setValor(rt, 0);
                    }
                    break;
                //AND (Imediato)
                case Consts.ANDI:
                    registradores.setValor(rt, valorRs & imediato);
                    break;
                //OR (Imediato)
                case Consts.ORI:
                    registradores.setValor(rt, valorRs | imediato);
                    break;
                //XOR (Imediato)
                case Consts.XORI:
                    registradores.setValor(rt, valorRs ^ imediato);
                    break;
                //Load Byte
                case Consts.LB:
                    //TODO
                    break;
                //Load Byte (Unsigned)
                case Consts.LBU:
                    //TODO;
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
                    if(valorRs == valorRt){
                        //GO TO (PC + 4 + IMM)
                    }else{
                        //PC + 4
                    }
                    break;
                //Branch not equals
                case Consts.BNE:
                    if(valorRs != valorRt){
                        //GO TO (PC + 4 + IMM)
                    }else{
                        //PC + 4
                    }
                    break;
                //Branch less than zero
                case Consts.BLTZ:
                    if(valorRs < 0){
                        //GO TO (PC + 4 + IMM)
                    }else{
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

    public Integer getRegistrador(String registrador) {
        registrador = registrador.replace("$", "");
        return Integer.parseInt(registrador);
    }

}
