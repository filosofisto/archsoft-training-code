package com.archsoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		try(PrintWriter out = new PrintWriter(new File("teste.html"))) {
			out.println("<html>");
			out.println("<body>");
			out.println("<form>");
			out.println("<input type='text'/>");
			out.println("<input type='submit'/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
