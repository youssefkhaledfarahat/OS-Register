
public class Fetch {
	public static void	InstFetch(String PC){
		//int decimalpc=Integer.parseInt(PC,2);
		//decimalpc=decimalpc+4;
		 //PC = Integer.toBinaryString(decimalpc);
		int oldpc=Integer.parseInt(PC,2);
		String fetchedinstruction=Memory.mem[oldpc];
		//Program_Counter.increment();
		 //String result=ProgCount();//incremented pc
		//System.out.println("Program counter is:"+" "+Memory.pc);
		 Decode.instdecode(fetchedinstruction,Memory.pc);
		 System.out.println("instruction is:"+" "+fetchedinstruction);
		 System.out.println("Program counter is:"+" "+Memory.pc);

	}
}
