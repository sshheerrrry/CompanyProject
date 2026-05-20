package dao;

import java.util.List;

import model.Chat;

public interface ChatDao {
	//create
		void addChat(Chat chat);
		
		//read
		List<Chat> selectAll();

}
