package in.uc.pojo;

public class Order {
	private int orderid;
	private String custemail;
	private int orderprice;
	private String orderdate;
	private String orderstatus;
	private Cake cake;
	
	public Order() {
		super();
	}

	public Order(String custemail, int orderprice, String orderdate, String orderstatus, Cake cake) {
		super();
		this.custemail = custemail;
		this.orderprice = orderprice;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.cake = cake;
	}

	public Order(int orderid, String custemail, int orderprice, String orderdate, String orderstatus, Cake cake) {
		super();
		this.orderid = orderid;
		this.custemail = custemail;
		this.orderprice = orderprice;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.cake = cake;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public int getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", custemail=" + custemail + ", orderprice=" + orderprice + ", orderdate="
				+ orderdate + ", orderstatus=" + orderstatus + ", cake=" + cake + "]";
	}
}
