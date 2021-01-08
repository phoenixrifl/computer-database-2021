package Model;

public class Computer {
	
	private Integer id;
	private String name;
	private String introduced;
	private String discontinued;
	private String company_id;
	
	public Computer(Integer id, String name, String introduced, String discontinued, String company_id) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
}
