package model;

import java.time.LocalDate;
import java.util.Objects;

public class Computer {
	
	private Integer id;
	private String name;
	private LocalDate introduced;
	private LocalDate discontinued;
	private Integer company_id;
	
	public Computer(Integer id, String name, LocalDate introduced, LocalDate discontinued, Integer company_id) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
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

	public Integer getCompany_id() {
		return company_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Computer computer = (Computer) o;
		return Objects.equals(id, computer.id) && Objects.equals(name, computer.name) && Objects.equals(introduced, computer.introduced) && Objects.equals(discontinued, computer.discontinued) && Objects.equals(company_id, computer.company_id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, introduced, discontinued, company_id);
	}

	@Override
	public String toString() {
		return "Computer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", introduced='" + introduced + '\'' +
				", discontinued='" + discontinued + '\'' +
				", company_id='" + company_id + '\'' +
				'}';
	}
}
