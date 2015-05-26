package interpreter;

import java.util.StringTokenizer;

public class Parser {
	private StringTokenizer mTokenizer;
	private String mCurrentToken;
	public Parser(String aText) {
		mTokenizer = new StringTokenizer(aText);
		nextToken();
	}
	public String nextToken() {
		if (mTokenizer.hasMoreTokens()) {
			mCurrentToken = mTokenizer.nextToken();
		}
		else {
			mCurrentToken = null;
		}
		return mCurrentToken;
	}
	public String currentToken() {
		return mCurrentToken;
	}
	public void skipToken(String aToken) throws Exception {
		if (!aToken.equals(mCurrentToken)) {
			throw new Exception("Warning: no expected token to skip");
		}
		nextToken();
	}
	public int currentNumber() throws Exception {
		int number = 0;
		try {
			number = Integer.parseInt(mCurrentToken);
		}
		catch (NumberFormatException e) {
			throw new Exception("Warning: parse number error");
		}
		return number;
	}
}
