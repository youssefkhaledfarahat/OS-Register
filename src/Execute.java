public class Execute{
static String LWresult ="";
public static String extendTo8Bits(String x) {
	while(x.length()<8) {
		x = "0"+x;
	}
	return x;
}
public static String executeALU(String code, String operand1, String operand2) {
	 int ALUresultint = 0 ;
    ////// ADD/////
    if (code.equals("0000")) {
    	int o1=Integer.parseInt(operand1, 2);
    	int o2=Integer.parseInt(operand2, 2);
    	ALUresultint=o1+o2;
       // ALUresultint = Integer.parseInt(operand1, 2) + Integer.parseInt(operand2, 2);
        System.out.println("result is"+extendTo8Bits(Integer.toBinaryString(ALUresultint)));
      return  extendTo8Bits(Integer.toBinaryString(ALUresultint));
    }
    /////// SUB//////////
    else if (code.equals("0001")) {
        ALUresultint = Integer.parseInt(operand1, 2) - Integer.parseInt(operand2, 2);
        System.out.println("resultsub is"+extendTo8Bits(Integer.toBinaryString(ALUresultint)));
        return  extendTo8Bits(Integer.toBinaryString(ALUresultint));
    }
    ///// MULTIPLY//////
    else if (code.equals("0010")) {
        ALUresultint = Integer.parseInt(operand1, 2) *Integer.parseInt(operand2, 2);
        System.out.println("resultmultiply is"+extendTo8Bits(Integer.toBinaryString(ALUresultint)));
        return  extendTo8Bits(Integer.toBinaryString(ALUresultint));
    }
    return "invalid code";
}
public static String executeALU(String code, String operand1, int operand2) {
	int ALUresultint = 0 ;
    //// ADD IMMEDIATE////
    if (code.equals("0011")) {
        ALUresultint = Integer.parseInt(operand1, 2) + operand2;
        return  extendTo8Bits(Integer.toBinaryString(ALUresultint));
      }
    return "invalid code";
}
public static String executeLogical(String code, String operand1, String operand2) {
	int Logicalresultint = 0;
	String Logicalresult ="";
	//OR////
	if(code.equals("0100")) {
		int o1=Integer.parseInt(operand1,2);
		int o2=Integer.parseInt(operand2,2);
		Logicalresultint=o1|o2;
		System.out.println("result or is"+Integer.toBinaryString(Logicalresultint));
		Logicalresult = Integer.toBinaryString(Logicalresultint);
//	for(int i=0;i<8;i++) {
//		if(operand1.charAt(i)=='1'||operand2.charAt(i)=='1'){
//		Logicalresult =Logicalresult+"1";
//		}
//		else {
//			Logicalresult= Logicalresult+"0";
//		}	
//	}	
	}
	///SHIFT LEFT//// OPERAND 2 IS THE SHIFTED AMOUNT
	if(code.equals("0101")) {
	int shiftedAmount = Integer.parseInt(operand2, 2);
	int o1 =Integer.parseInt(operand1, 2);
	int shifted=o1<<shiftedAmount;
//	for(int i=0;i<shiftedAmount;i++) {
//		amount = amount*2;
//	}	
//	Logicalresultint =amount;
	Logicalresult = Integer.toBinaryString(shifted);
	System.out.println("result shiftleft is"+Logicalresult);
	}	
	//// SHIFT RIGHT
	if(code.equals("0110")) {
		int shiftedAmount = Integer.parseInt(operand2, 2);
		int o1 =Integer.parseInt(operand1, 2);
		int shifted=o1>>shiftedAmount;
//	for(int i=0;i<shiftedAmount;i++) {
//		amount = amount/2;
//	}	
	//Logicalresultint =amount;
		Logicalresult = Integer.toBinaryString(shifted);
		System.out.println("result shiftright is"+Logicalresult);
	}	
	return  extendTo8Bits(Logicalresult);
}
public static String executeLogical(String code, String operand1, int operand2) {
	String Logicalresult ="";
	////AND IMMEDIATE///
	if(code.equals("0111")) {
	for(int i=0;i<8;i++) {
		if(operand1.charAt(i)=='1'&&extendTo8Bits(Integer.toBinaryString(operand2)).charAt(i)=='1'){
		Logicalresult = Logicalresult+"1";
		}
		else {
			Logicalresult = Logicalresult+"0";
		}
	}
	return Logicalresult;
	}
	 return "invalid code";
	}
public static void main  (String [] args){
    String add=executeALU("0000", "00000101", "00000011");// add 5+3
    System.out.println("add "+ add);
    String sub=executeALU("0001", "00000101", "00000011");// sub 5-3
    System.out.println("sub "+ sub);
    String mul=executeALU("0010","00000101", "00000011");// mul 5*3
    System.out.println("mul "+ mul);
    String addi=executeALU("0011", "00000101",3);// addi 5+3
    System.out.println("addi "+ addi);
    String or =executeLogical("0100", "00000011","00000101"); // 3 or 5
    System.out.println("or "+ or);
    String shiftleft=executeLogical("0101","00000101", "00000011"); // shift 5 three times left
    System.out.println("shift left "+ shiftleft);
    String shiftright=executeLogical("0110", "00000101","00000011");// shift 5 three times right
    System.out.println("shift right "+ shiftright);
    String andi=executeLogical("0111", "00000101",3); // 5 andi 3
    System.out.println("andi "+ andi);
}
}