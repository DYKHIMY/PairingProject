import static org.junit.Assert.*;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testMain() {
		   String[] args = {"-n","10","-m","1","100","-o","5","-c","-b"};
	        String[] args1 = {"-o"};
	        String[] args2 = {"-n","-m","1","100"};
	        String[] args3 = {"-n","100000","-m","100"};
	        String[] args4 = {"-m","1000","44","-n"};
	        String[] args5 = {"-o","100"};
	        String[] args6 = {"-m","-3","1"};
	        String[] args7 = {"-n","100000","-m","d","100"};
	        new Command();
	        Command.main(args);
	        Command.main(args1);
	        Command.main(args2);
	        Command.main(args3);
	        Command.main(args4);
	        Command.main(args5);
	        Command.main(args6);
	        Command.main(args7);
	}

}
