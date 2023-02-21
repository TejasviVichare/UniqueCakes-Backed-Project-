package in.uc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.uc.pojo.Cake;
import in.uc.utility.DBConnection;

public class CakeDao {
	
	Connection conn=DBConnection.getConnect();
	 String sql=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 int i=0;
	public boolean addCake(Cake c) {
	 
	 
		try {
			System.out.println("inside cakedoa add method");
			
			sql="insert into cakes(cakename,caketype,cakeweight,cakeprice)values(?,?,?,?)";
		    ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCakename());
			ps.setString(2, c.getCaketype());
			ps.setDouble(3, c.getCakeweight());
			ps.setDouble(4, c.getCakeprice());
			System.out.println("query :"+ps);
		    i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean updateCake(Cake c) {

		try {
			System.out.println("inside cakedoa updateCake method");
			
			sql="update cakes set cakename=?,caketype=?,cakeweight=?,cakeprice=? where cakeid=?";
		    ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCakename());
			ps.setString(2, c.getCaketype());
			ps.setDouble(3, c.getCakeweight());
			ps.setDouble(4, c.getCakeprice());
			ps.setInt(5, c.getCakeid());
			System.out.println("query :"+ps);
		    i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deleteCake(int cakeid) {
		try {
			System.out.println("inside cakedoa deleteCake method");	
			sql="delete from cakes where cakeid=?";
		    ps=conn.prepareStatement(sql);	
		    ps.setInt(1, cakeid);
			System.out.println("query :"+ps);
		    i=ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Cake> showCakeList(){
		List<Cake> cakelist = new ArrayList<Cake>();
		try {
		
			System.out.println("Inside cakedou cake list method");
			sql="select *from cakes";
		    ps=conn.prepareStatement(sql);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Cake c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakeweight(rs.getDouble(4));
		    	c.setCakeprice(rs.getDouble(5));
		    	
		    	cakelist.add(c);
		    }
		    return cakelist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return cakelist;

	}
	
	public Cake searchCakeById(int cakeid) {
		Cake c=null;
		try {
			System.out.println("inside cakedoa searchCake by id method");
			
			sql="select *from cakes where cakeid=?";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1, cakeid);
		    rs=ps.executeQuery();
		    if(rs.next()){
		    	c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakeweight(rs.getDouble(4));
		    	c.setCakeprice(rs.getDouble(5));
		    	
		    	
		    }
		    return c;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return c;

	}
	
	public List<Cake> searchCakeByType(String caketype){
		List<Cake> cakelist = new ArrayList<Cake>();
		try {
			
			System.out.println("Inside cakedou searchCakeByType method");
			sql="select *from cakes where caketype=?";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1, caketype);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Cake c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakeweight(rs.getDouble(4));
		    	c.setCakeprice(rs.getDouble(5));
		    	
		    	cakelist.add(c);
		    }
		    return cakelist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return cakelist;
	}
	public List<Cake> searchCakeByName(String cakename){
		List<Cake> cakelist = new ArrayList<Cake>();
		try {
			
			System.out.println("Inside cakedou searchCakeByName method");
			sql="select *from cakes where cakename=?";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1, cakename);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Cake c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakeweight(rs.getDouble(4));
		    	c.setCakeprice(rs.getDouble(5));
		    	
		    	cakelist.add(c);
		    }
		    return cakelist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return cakelist;
	}


}
