package basico;

public class J{

    private String instructionName;
    private String opCode;
    private String adress ;

    public J(String instructionName, String opCode, String adress){
        this.instructionName = instructionName;
        this.opCode = opCode;
        this.adress = adress;
    }

    public String getAssembly(){
        String assembly = "";
        String label = Utils.binToDecimal(adress);
        switch (opCode){
            //Jump
            case Consts.J:
                assembly = instructionName + " " + label;
                break;
            //Jump and Link
            case Consts.JAL:
                assembly = instructionName + " " + label;
                break;
        }
        return assembly;
    }

}
