package Main;

import DAO.ImageDAO;
import Window.Chatting;
import Window.Emoticon;

public class mainClass {

	public static void main(String[] args) {
		new Chatting();
		new Emoticon();
		new ImageDAO();
	}
}