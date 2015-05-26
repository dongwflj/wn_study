package builder;

import java.io.IOException;
import java.io.PrintWriter;

public class HtmlBuilder extends Builder {
	private String mFileName;
	private PrintWriter mWriter;
	@Override
	public void makeTitle(String aTitle) {
		mFileName = aTitle + ".html";
		try {
			mWriter = new PrintWriter(new PrintWriter(mFileName));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		mWriter.println("<html><head><title>" + aTitle + "</title></head><body>");
		mWriter.println("<h1>" + aTitle + "</h1>");
	}

	@Override
	public void makeString(String aString) {
		mWriter.println("<p>" + aString + "</p>");
	}

	@Override
	public void makeItems(String[] aItems) {
		mWriter.println("<ul>");
		for (int i = 0; i < aItems.length; i++) {
			mWriter.println("<li>" + aItems[i] + "</li>");
		}
		mWriter.println("</ul>");
	}

	@Override
	public Object getResult() {
		mWriter.println("</body></html>");
		mWriter.close();
		return mFileName;
	}

}
