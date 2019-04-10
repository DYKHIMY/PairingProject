import static org.junit.Assert.*;

import org.junit.Test;

public class MakeQuestionTest {

	@Test
	public void testMakeQuestion3() {

		new MakeQuestion().MakeQuestion3(1000, 1, 100, 3, true, true);
		new MakeQuestion().MakeQuestion3(10, 1, 100, 3, false, false);
		new MakeQuestion().MakeQuestion3(10, 5, 100, 1, true, true);
		new MakeQuestion().MakeQuestion3(10, 1, 100, 1, false, false);

	}

}
