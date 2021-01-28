package dto;

import model.Company;
import model.Computer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mappeur {
    private static Mappeur instance = null;

    private Mappeur(){}

    public final static Mappeur getInstance() {
        if(Mappeur.instance == null) {
            instance = new Mappeur();
        }
        return instance;
    }

    public ComputerDTO ModelToDTO(Computer computer) {
        ComputerDTO computerDTO = new ComputerDTO();
        if(computer != null) {
            computerDTO.setId(String.valueOf(computer.getId()));
            computerDTO.setName(computer.getName());
            computerDTO.setIntroduced(String.valueOf(computer.getIntroduced()));
            computerDTO.setDiscontinued(String.valueOf(computer.getDiscontinued()));
            if(computer.getCompany() != null) {
                computerDTO.setCompanyId(String.valueOf(computer.getCompany().getId()));
                if(computer.getCompany().getName() != null)
                    computerDTO.setCompanyName(computer.getCompany().getName());
            }
        }
        return computerDTO;
    }

    public Computer DTOtoModel(ComputerDTO computerDTO) {
        LocalDate introduced = null, discontinued = null;
        Computer computer = null;
        try{
            if(!computerDTO.getIntroduced().equals("null")) {
                introduced = LocalDate.parse(computerDTO.getIntroduced());
            }
            if(!computerDTO.getDiscontinued().equals("null")) {
                discontinued = LocalDate.parse(computerDTO.getDiscontinued());
            }
            computer = new Computer(
                    Integer.parseInt(computerDTO.getId()),
                    computerDTO.getName(),
                    introduced,
                    discontinued,
                    Long.parseLong(computerDTO.getCompanyId()),
                    computerDTO.getCompanyName()
            );
        }catch(Exception e){
            e.printStackTrace();
        }
        return computer;
    }
    public ArrayList<Computer> DTOtoModel(ArrayList<ComputerDTO> computerDto) {
        ArrayList<Computer> tmp = new ArrayList<Computer>();
        for(ComputerDTO c : computerDto) {
            tmp.add(DTOtoModel(c));
        }
        return tmp;
    }
    public ArrayList<ComputerDTO> ModelToDTO(ArrayList<Computer> computer) {
        ArrayList<ComputerDTO> tmp = new ArrayList<ComputerDTO>();
        for(Computer c : computer) {
            tmp.add(ModelToDTO(c));
        }
        return tmp;
    }

    public CompanyDTO ModelToDTOCompany(Company company) {
        return new CompanyDTO(String.valueOf(company.getId()), company.getName());
    }

    public Company DTOTOModelCompany(CompanyDTO companyDto) {
        return new Company(Long.parseLong(companyDto.getId()), companyDto.getName());
    }

    public ArrayList<Company> DTOToModel_(ArrayList<CompanyDTO> companyDto) {
        ArrayList<Company> tmp = new ArrayList<Company>();
        for (CompanyDTO c : companyDto) {
            tmp.add(DTOTOModelCompany(c));
        }
        return tmp;
    }

    public ArrayList<CompanyDTO> ModelToDTO_(ArrayList<Company> company) {
        ArrayList<CompanyDTO> tmp = new ArrayList<CompanyDTO>();
        for (Company c : company) {
            tmp.add(ModelToDTOCompany(c));
        }
        return tmp;
    }
}
