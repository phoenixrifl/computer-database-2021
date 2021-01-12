package persistence;

import model.Company;

import java.util.ArrayList;

public class CompanyDAO extends DAO<Company> {
    @Override
    public boolean create(Company obj) {
        return false;
    }

    @Override
    public boolean delete(Company obj) {
        return false;
    }

    @Override
    public boolean update(Company obj) {
        return false;
    }

    @Override
    public Company find(int id) {
        return null;
    }

    @Override
    public ArrayList<Company> findAll() {
        return null;
    }
}
