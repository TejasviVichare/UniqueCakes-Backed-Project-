package in.uc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.uc.pojo.Cake;
import in.uc.pojo.Cart;
import in.uc.utility.DBConnection;

public class CartDao {

	Connection conn=DBConnection.getConnect();
	 String sql=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 int i=0;
	 
	 public boolean addToCart(Cart c) {
		 try {
				System.out.println("inside addToCart method");
				
				sql="insert into cart(custemail,cid)values(?,?)";
			    ps=conn.prepareStatement(sql);
				ps.setString(1, c.getCustemail());
				ps.setInt(2, c.getCake().getCakeid());
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
	 
	 public List<Cart> showMyCart(String email){
		 List<Cart> clist=new ArrayList<Cart>();
		 
		 try {
			 System.out.println("Inside Mycart Method");
			 sql="select cakeid,cakename,caketype,cakeweight,cakeprice,custemail,quantity,cartid\n"
			 		+ "from cakes inner join cart\n"
			 		+ "on cakes.cakeid=cart.cid where custemail=?";
			
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, email);
			 System.out.println("Query :"+ps);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 Cake c=new Cake();
				 Cart c1=new Cart();
				 c.setCakeid(rs.getInt(1));
				 c.setCakename(rs.getString(2));
				 c.setCaketype(rs.getString(3));
				 c.setCakeweight(rs.getDouble(4));
				 c.setCakeprice(rs.getDouble(5));
				 
				 c1.setCustemail(rs.getString(6));
				 c1.setQuantity(rs.getInt(7));
				 c1.setCartid(rs.getInt(8));
				 c1.setCake(c);
				 clist.add(c1);
				 
			 }
				return clist;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;		 
	 }
	 
	 public boolean deleteMyCart(int cartid) {
			try {
				System.out.println("inside deleteMyCart method");	
				sql="delete from cart where cartid=?";
			    ps=conn.prepareStatement(sql);	
			    ps.setInt(1, cartid);
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
