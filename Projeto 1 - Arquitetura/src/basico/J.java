package basico;

public class J {

    private String instructionName;
    private String opCode;
    private String adress;

    public J(String instructionName, String opCode, String adress) {
        this.instructionName = instructionName;
        this.opCode = opCode;
        this.adress = Utils.binToDecimal(adress);
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

    public String getAdress() {
        return adress;
    }

    public int getDecimalAdress(){
        return Integer.parseInt(Utils.binToDecimal(adress));
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAssembly() {
        String assembly = "";

        switch (opCode) {
            //Jump
            case Consts.J:
                assembly = instructionName + " " + adress;
                break;
            //Jump and Link
            case Consts.JAL:
                assembly = instructionName + " " + adress;
                break;
        }
        return assembly;
    }

}
