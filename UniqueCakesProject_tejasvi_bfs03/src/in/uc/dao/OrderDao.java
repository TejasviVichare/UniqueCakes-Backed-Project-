package in.uc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.uc.pojo.Order;
import in.uc.utility.DBConnection;

public class OrderDao {

	Connection conn=DBConnection.getConnect();
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int i=0;
	
	public boolean addordercake(Order o) {
		 
		 
		try {
			System.out.println("inside Orderdoa add method");
			
			sql="insert into Orders(custemail,orderprice,orderdate,orderstatus,cid)values(?,?,?,?,?)";
		    ps=conn.prepareStatement(sql);
			ps.setString(1, o.getCustemail());
			ps.setDouble(2, o.getOrderprice());
			ps.setString(3, o.getOrderdate());
			ps.setString(4, o.getOrderstatus());
			ps.setInt(5, o.getCake().getCakeid());
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
	public boolean updateOrder(Order o) {

		try {
			System.out.println("inside cakedoa updateOrder method");
			
			sql="update Orders set custemail=?,orderprice=?,orderdate=?,orderprice=?,cid=? where orderid=?";
		    ps=conn.prepareStatement(sql);
			ps.setString(1, o.getCustemail());
			ps.setDouble(2, o.getOrderprice());
			ps.setString(3, o.getOrderdate());
			ps.setString(4, o.getOrderstatus());
			ps.setInt(5, o.getCake().getCakeid());
			ps.setInt(6, o.getOrderid());
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
	public boolean deleteOrder(int orderid) {
		try {
			System.out.println("inside Orderdoa deleteOrder method");	
			sql="delete from Orders where orderid=?";
		    ps=conn.prepareStatement(sql);	
		    ps.setInt(1, orderid);
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
}
//Add cakes,update order,Delete Order
