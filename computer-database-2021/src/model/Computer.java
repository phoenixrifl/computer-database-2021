package model;

import java.time.LocalDate;
import java.util.Objects;

public class Computer {
	
	private Integer id;
	private String name;
	private LocalDate introduced;
	private LocalDate discontinued;
	private Company company;

	public Computer() {
	}

	public Computer(Integer id, String name, LocalDate introduced, LocalDate discontinued, Long company_id, String companyName) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		if(company_id!=0){
			this.company = new Company(company_id, companyName);
		}else
			this.company = null;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getIntroduced() {
		return introduced;
	}

	public void setIntroduced(LocalDate introduced) {
		this.introduced = introduced;
	}

	public LocalDate getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(LocalDate discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompany() {
		return company;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Computer computer = (Computer) o;
		return Objects.equals(id, computer.id) && Objects.equals(name, computer.name) && Objects.equals(introduced, computer.introduced) && Objects.equals(discontinued, computer.discontinued) && Objects.equals(company, computer.company);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, introduced, discontinued, company);
	}

	@Override
	public String toString() {
		if(company != null) {
			return "Computer{" +
					"id=" + id +
					", name='" + name + '\'' +
					", introduced='" + introduced + '\'' +
					", discontinued='" + discontinued + '\'' +
					", company_name='" + company.getName() + '\'' +
					'}' + "\n";
		}else
			return "Computer{" +
					"id=" + id +
					", name='" + name + '\'' +
					", introduced='" + introduced + '\'' +
					", discontinued='" + discontinued + '\'' +
					", company_name='" + "" + '\'' +
					'}' + "\n";
	}
}
