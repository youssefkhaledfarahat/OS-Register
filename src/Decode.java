
public class Decode {
static	String typecode="";
static	String uniquecode="";
static String  first="";
static String  second="";
static String result ="";
public static void instdecode(String instruction,String pc){
	typecode=instruction.substring(0, 3);
	uniquecode=instruction.substring(3, 7);
	if(typecode.equals("000")){
		System.out.println("instruction type is arithmetic");
		//add
		if(uniquecode.equals("0000")){
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			int j=Integer.parseInt(second, 2);
			System.out.println("second register is"+" "+j);
			String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeALU(uniquecode, operand1, operand2);
		}
		//sub
		if(uniquecode.equals("0001")){
			System.out.println("enters Sub");
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			int j=Integer.parseInt(second, 2);
			String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeALU(uniquecode, operand1, operand2);
		}
		//multiply
		if(uniquecode.equals("0010")){
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			int j=Integer.parseInt(second, 2);
			String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeALU(uniquecode, operand1, operand2);
		}
		//addimmediate
		if(uniquecode.equals("0011")){
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			int j=Integer.parseInt(second, 2);
			//String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeALU(uniquecode, operand1, j);
		}
	}
	else if(typecode.equals("001")){
		System.out.println("instruction type is logical");
		//or
		if(uniquecode.equals("0100")){
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			int j=Integer.parseInt(second, 2);
			System.out.println("second register is"+" "+j);
			String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeLogical(uniquecode, operand1, operand2);
		}
		//shift left
		if(uniquecode.equals("0101")){
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			int j=Integer.parseInt(second, 2);
			//System.out.println("second register is"+" "+j);
			//String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeLogical(uniquecode, operand1, second);
		}
		//shift right
		if(uniquecode.equals("0110")){
			first=instruction.substring(7, 15);
			System.out.println(first);
			int i=Integer.parseInt(first, 2);
			String operand1=Registerfile.registers[i];
			second=instruction.substring(15, 23);
			//int j=Integer.parseInt(second, 2);
			//System.out.println("second register is"+" "+j);
			//String operand2=Registerfile.registers[j];
			result=instruction.substring(23, 31);
			Execute.executeLogical(uniquecode, operand1, second);
		}
	}
	
}
public static void Execute(String instruction){

}
public static void main (String [] args){
	//instdecode("00000000000000000000000000000000", "00000000000000000000000000000000");
//	System.out.println(typecode);
//	System.out.println(uniquecode);
//	System.out.println(first);
//	System.out.println(second);
//	System.out.println(result);


}
}
