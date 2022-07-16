package toy.inflation.toyprices.domain;

public class GasStation {
	private String key;
	private String type;
	private String routeName;
	private String numOfRows;
	private String pageNo;
	
	public GasStation() {}
	
	public GasStation(String key, String type) {
		this.key = key;
		this.type = type;
	}
	
	public GasStation(String key, String type, String routeName, String numOfRows, String pageNo) {
		this.key = key;
		this.type = type;
		this.routeName = routeName;
		this.numOfRows = numOfRows;
		this.pageNo = pageNo;
	}
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
