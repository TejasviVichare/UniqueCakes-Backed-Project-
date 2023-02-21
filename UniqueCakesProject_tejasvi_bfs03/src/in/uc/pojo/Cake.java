package in.uc.pojo;

public class Cake {

	private int cakeid;
	private String cakename;
	private String caketype;
	private double cakeweight;
	private double cakeprice;
	
	public Cake() {
		super();
	}
	public Cake(String cakename, String caketype, double cakeweight, double cakeprice) {
		super();
		this.cakename = cakename;
		this.caketype = caketype;
		this.cakeweight = cakeweight;
		this.cakeprice = cakeprice;
	}
	public Cake(int cakeid, String cakename, String caketype, double cakeweight, double cakeprice) {
		super();
		this.cakeid = cakeid;
		this.cakename = cakename;
		this.caketype = caketype;
		this.cakeweight = cakeweight;
		this.cakeprice = cakeprice;
	}
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	public String getCaketype() {
		return caketype;
	}
	public void setCaketype(String caketype) {
		this.caketype = caketype;
	}
	public double getCakeweight() {
		return cakeweight;
	}
	public void setCakeweight(double cakeweight) {
		this.cakeweight = cakeweight;
	}
	public double getCakeprice() {
		return cakeprice;
	}
	public void setCakeprice(double cakeprice) {
		this.cakeprice = cakeprice;
	}
	@Override
	public String toString() {
		return "Cake [cakeid=" + cakeid + ", cakename=" + cakename + ", caketype=" + caketype + ", cakeweight="
				+ cakeweight + ", cakeprice=" + cakeprice + "]";
	}
	
	
}
