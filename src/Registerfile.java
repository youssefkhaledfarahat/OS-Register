
public class Registerfile {
static String [] registers=new String[32];
public static void main(String[] args) {
	String two="00000000000000000000000000000010";
	// TODO Auto-generated method stub
	registers[0]="00000000000000000000000000000000";//name R0 purpose maintains the value of zero always
	registers[1]="00000000000000000000000000000001";//name R1 purpose maintains the value of one always
	//registers 2-31 are named R2-R31 respectively and they are all general purpose registers
	//filling the registers array with any value 
	for(int i=2;i<registers.length;i++){
		registers[i]=two;
	}
}



}
