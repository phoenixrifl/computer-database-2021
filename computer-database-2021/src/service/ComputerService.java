package service;

import dto.ComputerDTO;
import dto.Mappeur;
import exception.IncorrectDateException;
import model.Computer;
import persistence.ComputerDAO;
import validation.DateValidator;

import java.util.List;

public class ComputerService {

    private ComputerDAO computerDAO = new ComputerDAO();
    private Mappeur mappeur = Mappeur.getInstance();
    private DateValidator dateValidator = DateValidator.getInstance();

    private ComputerService(){}

    private static ComputerService INSTANCE = null;

    public static ComputerService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ComputerService();
        }
        return INSTANCE;
    }

    public boolean createDTO(String computerDto){
        String[] computer = computerDto.split(",");
        return create(new ComputerDTO(computer[0],
                computer[1],
                computer[2],
                computer[3]));
    }

    public boolean createComputerDtoWithId(Long id, String computerDto) {
        String[] computer = computerDto.split(",");
        return update(new ComputerDTO(
                String.valueOf(id),
                computer[0],
                computer[1],
                computer[2],
                computer[3]));
    }

    public boolean create(ComputerDTO computerDto){
        Computer computer = this.mappeur.DTOtoModel(computerDto);
        try {
            dateValidator.dateIsValid(computer);
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        }
        this.computerDAO.create(computer);
        return true;
    }

    public boolean delete(Long id) {
       return this.computerDAO.delete(findOne(id));
    }

    public boolean update(ComputerDTO computerDTO) {
        Computer computer = this.mappeur.DTOtoModel(computerDTO);
        try{
            dateValidator.dateIsValid(computer);
        }catch (IncorrectDateException e){
            e.printStackTrace();
        }
        return this.computerDAO.update(computer);
    }

    public Computer findOne(Long id) {
        return this.computerDAO.find(id);
    }

    public List<Computer> findAll() {
        List<Computer> computerList = this.computerDAO.findAll();
        return computerList;
    }
}
