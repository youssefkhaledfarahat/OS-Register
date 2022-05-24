
public class Memory {
static String[] mem=new String [2048]; //from 0 to 1023 instructions and from 1024 to the end data
static boolean fetch=true;
static String pc="00000000000000000000000000000000";
public static void Increment(){
	int decimalpc=Integer.parseInt(pc, 2);
	decimalpc=decimalpc+4;
	pc=Integer.toBinaryString(decimalpc);
	while(pc.length()<32){
		pc="0"+pc;
	}
}
	public static void main(String[] args) {
		// arithmetic type code is "000" add unique code is"0000"
		String add="00000000000000100000010000000100";// r1+r2
		String sub="00000010000001000000001000000100";//r2-r1
		String multiply="00000100000001000000001000000100";//r2*r1
		String or="00101000000001000000001000000100";//r2|R1
		String shiftleft="00101010000001000000001000000100";//shift r2 left by 1 bit
		String shiftright="00101100000001000000001000000100";//shift r2 right by 1 bit
//	String test="1100";
//	int t=Integer.parseInt(test,2);
//	int t1=t>>2;
//	String test1=Integer.toBinaryString(t1) ;
//	System.out.println("this is TEST"+" "+test1);
//		
		
		
		mem[0]=add;
		mem[4]=sub;
		mem[8]=multiply;
		mem[12]=or;
		mem[16]=shiftleft;
		mem[20]=shiftright;
		
		//String second=add.substring(7, 15);
		//System.out.println(second);
		String two="00000000000000000000000000000010";
		// TODO Auto-generated method stub
		Registerfile.registers[0]="00000000000000000000000000000000";//name R0 purpose maintains the value of zero always
		Registerfile.registers[1]="00000000000000000000000000000001";//name R1 purpose maintains the value of one always
		//registers 2-31 are named R2-R31 respectively and they are all general purpose registers
		//filling the registers array with any value 
		for(int i=2;i<Registerfile.registers.length;i++){
			Registerfile.registers[i]=two;
		}
		for(int i=0;i<6;i++){
		Fetch.InstFetch(pc);
		Increment();
		}
	}

}
