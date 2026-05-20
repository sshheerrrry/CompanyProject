package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ChatDao;
import model.Chat;
import util.DbConnection;

public class ChatDaoImpl implements ChatDao{

	public static void main(String[] args) {
		//Chat chat=new Chat("abc","測試2","2026 0506練習");
		//new ChatDaoImpl().addChat(chat);
		//System.out.println(new ChatDaoImpl().selectAll());
		
		for(Chat chat:new ChatDaoImpl().selectAll())
		{
			System.out.println("id:"+chat.getId()+
					"\n主題:"+chat.getSubject()+
					"\n內容:"+chat.getContent()+"\n");
		}

	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void addChat(Chat chat) {
		String sql="insert into chat(name,subject,content) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, chat.getName());
			ps.setString(2, chat.getSubject());
			ps.setString(3, chat.getContent());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Chat> selectAll() {
		String sql="select * from chat order by id desc";
		List<Chat> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Chat chat=new Chat();
				chat.setId(rs.getInt("id"));
				chat.setName(rs.getString("name"));
				chat.setSubject(rs.getString("subject"));
				chat.setContent(rs.getString("content"));
				l.add(chat);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return l;
	}

}