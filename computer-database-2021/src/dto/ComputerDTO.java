package dto;

public class ComputerDTO {
    private String id, name, introduced, discontinued, companyName, companyId;

    public ComputerDTO() {
    }

    public ComputerDTO(String id, String name, String introduced, String discontinued, String company_id, String company_name) {
        super();
        this.id = id;
        this.name = name;
        this.introduced = introduced;
        this.discontinued = discontinued;
        this.companyName = company_name;
        this.companyId = company_id;

    }

    public ComputerDTO(String id, String name, String dateIntroduced, String dateDiscontinued, String idCompanie) {
        this.id = id;
        this.name = name;
        this.introduced = dateIntroduced;
        this.discontinued = dateDiscontinued;
        this.companyId = idCompanie;
    }


    public ComputerDTO(String name, String dateIntroduced, String dateDiscontinued, String idCompanie) {
        this.id = "-1";
        this.name = name;
        this.introduced = dateIntroduced;
        this.discontinued = dateDiscontinued;
        this.companyId = idCompanie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduced() {
        return introduced;
    }

    public void setIntroduced(String introduced) {
        this.introduced = introduced;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "ComputerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", introduced='" + introduced + '\'' +
                ", discontinued='" + discontinued + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
