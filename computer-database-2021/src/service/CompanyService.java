package service;

import model.Company;
import persistence.CompanyDAO;

import java.util.List;

public class CompanyService {

    private CompanyDAO companyDAO = new CompanyDAO();
    private CompanyService(){}

    private static CompanyService INSTANCE = null;

    public static CompanyService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CompanyService();
        }
        return INSTANCE;
    }

    public Company find(long id){
        return this.companyDAO.find(id);
    }

    public List<Company> findAll() {
        List<Company> companyList = this.companyDAO.findAll();
        return companyList;
    }
}
