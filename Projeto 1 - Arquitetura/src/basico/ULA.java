package basico;

import java.math.BigInteger;

public class ULA {

    private static ULA instance;
    private BancoRegistradores registradores;

    public int jump;
    public boolean isJump;

    public int getJump() {
        return this.jump;
    }

    public boolean isJump() {
        return this.isJump;
    }

    public ULA() {
        this.registradores = BancoRegistradores.getInstance();
        this.jump = 0;
    }

    public static ULA getInstance() {
        if (instance == null) {
            instance = new ULA();
        }
        return instance;
    }

    public String executarInstrucao(Object instrucao, int PC) {
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
                    this.isJump = false;
                    break;

                //Adição(Unsigned)
                case Consts.ADDU_END:
                    resultado = valorRs + valorRt;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Subtração
                case Consts.SUB_END:
                    resultado = valorRs - valorRt;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Subtração (Unsigned)
                case Consts.SUBU_END:
                    resultado = valorRs - valorRt;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //OR
                case Consts.OR_END:
                    resultado = valorRs | valorRt;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //AND
                case Consts.AND_END:
                    resultado = valorRs & valorRt;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //NOR
                case Consts.NOR_END:
                    resultado = ~(valorRs | valorRt);
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //XOR
                case Consts.XOR_END:
                    resultado = valorRs ^ valorRt;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
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
                    hi = new BigInteger(result.toString().substring(0, 32), 2);
                    lo = new BigInteger(result.toString().substring(32, 64), 2);
                    registradores.setValor("HI", Integer.valueOf(hi.shortValue()));
                    registradores.setValor("LO", Integer.valueOf(lo.shortValue()));
                    this.isJump = false;
                    break;

                //Multiplicação (Unsigned)
                case Consts.MULTU_END:
                    resultado = valorRs * valorRt;
                    String binU = Integer.toBinaryString(resultado);
                    //Bit Mais Significativo
                    char firstCharU = binU.charAt(0);
                    StringBuffer resultU = new StringBuffer();
                    for (int i = 1; i <= (64 - binU.length()); i++) {
                        if (firstCharU == '0') {
                            resultU.append("0");
                        } else {
                            resultU.append("1");
                        }

                    }
                    resultU.append(binU);
                    hi = new BigInteger(resultU.toString().substring(0, 32), 2);
                    lo = new BigInteger(resultU.toString().substring(32, 64), 2);
                    registradores.setValor("HI", Integer.valueOf(hi.shortValue()));
                    registradores.setValor("LO", Integer.valueOf(lo.shortValue()));
                    this.isJump = false;
                    break;

                //Divisão
                case Consts.DIV_END:
                    LO = valorRs / valorRt;
                    HI = valorRs % valorRt;
                    registradores.setValor("HI", HI);
                    registradores.setValor("LO", LO);
                    this.isJump = false;
                    break;

                //Divisão (Unsigned)
                case Consts.DIVU_END:
                    LO = valorRs / valorRt;
                    HI = valorRs % valorRt;
                    registradores.setValor("HI", HI);
                    registradores.setValor("LO", LO);
                    this.isJump = false;
                    break;

                //Move from HI
                case Consts.MFHI_END:
                    HI = registradores.getValor("HI");
                    registradores.setValor(rd, HI);
                    this.isJump = false;
                    break;

                //Move from LO
                case Consts.MFLO_END:
                    LO = registradores.getValor("LO");
                    registradores.setValor(rd, LO);
                    this.isJump = false;
                    break;

                //Set Less Than
                case Consts.SLT_END:
                    resultado = 0;
                    if (valorRs < valorRt) {
                        resultado = 1;
                    }
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Shif Left Logical
                case Consts.SLL_END:
                    resultado = valorRt << shift;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Shift left logical variable
                case Consts.SLLV_END:
                    resultado = valorRt << valorRs;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Shift Right Logical
                case Consts.SRL_END:
                    resultado = valorRt >>> shift;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Shift Right Logical Variable
                case Consts.SRLV_END:
                    resultado = valorRt >>> valorRs;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Shift Right Arithmetic
                case Consts.SRA_END:
                    resultado = valorRt >> shift;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Shift Right Arithmetic Variable
                case Consts.SRAV_END:
                    resultado = valorRt >> valorRs;
                    registradores.setValor(rd, resultado);
                    this.isJump = false;
                    break;

                //Jump Register
                case Consts.JR_END:
                    jump = valorRs - 4;
                    this.isJump = true;
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
                    this.isJump = false;
                    break;

                //Adição com Imediato
                case Consts.ADDI:
                    resultado = valorRs + imediato;
                    registradores.setValor(rt, resultado);
                    this.isJump = false;
                    break;

                //Adição (Imediato Unsigned)
                case Consts.ADDIU:
                    resultado = valorRs + imediato;
                    registradores.setValor(rt, resultado);
                    this.isJump = false;
                    break;

                //Set less than imediate
                case Consts.SLTI:
                    resultado = 0;
                    if (valorRs < imediato) {
                        resultado = 1;
                    }
                    registradores.setValor(rt, resultado);
                    this.isJump = false;
                    break;

                //AND (Imediato)
                case Consts.ANDI:
                    resultado = valorRs & imediato;
                    registradores.setValor(rt, resultado);
                    this.isJump = false;
                    break;

                //OR (Imediato)
                case Consts.ORI:
                    resultado = valorRs | imediato;
                    registradores.setValor(rt, resultado);
                    this.isJump = false;
                    break;

                //XOR (Imediato)
                case Consts.XORI:
                    resultado = valorRs ^ imediato;
                    registradores.setValor(rt, resultado);
                    this.isJump = false;
                    break;

                //Load Byte
                case Consts.LB:
                    this.isJump = false;
                    int mem = registradores.getMemoria(valorRs);
                    String data = Integer.toBinaryString(mem);
                    registradores.setValor(rt, Utils.getByte(data, imediato));
                    break;

                //Load Byte (Unsigned)
                case Consts.LBU:
                    this.isJump = false;
                    int mem_u = registradores.getMemoria(valorRs);
                    String data_u = Integer.toBinaryString(mem_u);
                    registradores.setValor(rt, Utils.getByteU(data_u, imediato));
                    break;

                //Store Byte
                case Consts.SB:
                    this.isJump = false;
                    String sb_str = Integer.toBinaryString(registradores.getMemoria(valorRs));
                    String result = Utils.setByte(sb_str, imediato, valorRt);
                    int sb;
                    if (result.charAt(0) == '1') {
                        sb = Integer.parseInt(Utils.twoComplement(result), 2) * -1;
                    } else sb = Integer.parseInt(result, 2);
                    registradores.setMemoria(valorRs, sb);
                    break;

                //Store Word
                case Consts.SW:
                    this.isJump = false;
                    registradores.setValor(rt, registradores.getMemoria(valorRs + imediato));
                    break;

                //Load Word
                case Consts.LW:
                    this.isJump = false;
                    registradores.setMemoria(valorRs + imediato, registradores.getValor(rt));
                    break;

                //Branch equals
                case Consts.BEQ:
                    if (valorRs == valorRt) {
                        this.isJump = true;
                        jump = (imediato * 4);
                    } else {
                        this.isJump = false;
                    }
                    break;

                //Branch not equals
                case Consts.BNE:
                    if (valorRs != valorRt) {
                        this.isJump = true;
                        jump = (imediato * 4);
                    } else {
                        this.isJump = false;
                    }
                    break;

                //Branch less than zero
                case Consts.BLTZ:
                    if (valorRs < 0) {
                        this.isJump = true;
                        jump = PC + (imediato * 4);
                    } else {
                        this.isJump = false;
                    }
                    break;
            }
        } else if (instrucao instanceof J) {
            J typeJ = (J) instrucao;
            String opCode = typeJ.getOpCode();
            switch (opCode) {
                //Jump
                case Consts.J:
                    this.isJump = true;
                    jump = (Integer.parseInt(typeJ.getAdress()) * 4) - 4;
                    break;

                //Jump and Link
                case Consts.JAL:
                    this.isJump = true;
                    jump = (Integer.parseInt(typeJ.getAdress()) * 4) - 4;
                    registradores.setValor("31", PC + 4);
                    break;
            }
        }

        return registradores.showValores();
    }


}
