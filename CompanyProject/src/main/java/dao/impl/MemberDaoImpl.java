package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import entity.Member;
import utils.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		//System.out.println(new MemberDaoImpl().login("abc", "1234"));
		System.out.println(new MemberDaoImpl().checkUsername("tea"));

	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public void addMember(Member member) {
		String sql="insert into member(name,username,password,address,phone) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> login(String username, String password) {
		String sql="select * from member where username=? and password=?";
		List<Member> l=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				l=new ArrayList<>();
				Member member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				l.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public boolean checkUsername(String username) {
		String sql="select * from member where username=?";
		boolean check_username=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				check_username=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check_username;
	}

}
