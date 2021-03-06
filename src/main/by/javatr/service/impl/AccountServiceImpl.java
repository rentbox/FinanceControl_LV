package main.by.javatr.service.impl;

import main.by.javatr.bean.Account;
import main.by.javatr.dao.exception.DAOException;
import main.by.javatr.dao.factory.DAOFactory;
import main.by.javatr.dao.factory.FileDAOFactory;
import main.by.javatr.dao.impl.FileAccountDAO;
import main.by.javatr.service.AccountService;
import main.by.javatr.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;


public class AccountServiceImpl implements AccountService {

    private static Logger log = Logger.getLogger(AccountServiceImpl.class.getName());

    private static FileAccountDAO getFileAccountDAO(){

        DAOFactory factory = new FileDAOFactory();
        return (FileAccountDAO) factory.getAccountDAO();
    }

    @Override
    public boolean checkRegistration(Account account) throws ServiceException {

        log.info("Service layer checkRegistration");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();

        boolean b = false;
        try {
            b = fileAccountDAO.findByLogin(account.getLogin());
        } catch (DAOException e) {
            throw new ServiceException("DAOException", e);
        }
        return b;
    }

    @Override
    public boolean registration(Account account) throws ServiceException {
        log.info("Service layer registration");

        try {
            boolean check = checkRegistration(account);
            if (!check) {

                FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();

                fileAccountDAO.add(account);
            }else return false;

        }catch (DAOException e){
            throw new ServiceException("DAOException",e);
        }

        return true;
    }

    @Override
    public boolean logIn(Account account) throws ServiceException {
        log.info("Service layer logIn");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();

        try {
            return fileAccountDAO.find(account);
        } catch (DAOException e) {
            throw new ServiceException("DAOException", e);
        }
    }

    @Override
    public Account changeBalance(Account account) throws ServiceException {
        log.info("Service layer changeBalance");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();
        try {
            account = fileAccountDAO.update(account);
        } catch (DAOException e) {
            throw new ServiceException("DAOException", e);
        }

        return account;
    }

    @Override
    public Account changeCategory(Account account) throws ServiceException {
        log.info("Service layer changeCategory");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();
        try {

            account.setExpenses(account.getFood() + account.getTransport() + account.getEntertainment() + account.getOther());

            account = fileAccountDAO.update(account);
        } catch (DAOException e) {
            throw new ServiceException("DAOException",e);
        }


        return account;
    }

    @Override
    public Account update(Account account) throws ServiceException {
        log.info("Service layer update");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();

        try {
            fileAccountDAO.update(account);
        } catch (DAOException e) {
            throw new ServiceException("DAO Exception", e);
        }
        return account;
    }

    @Override
    public boolean delete(Account account) throws ServiceException {
        log.info("Service layer delete");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();
        try {
            fileAccountDAO.delete(account);
        } catch (DAOException e) {
            throw new ServiceException("DAOException", e);
        }
        return true;
    }

    @Override
    public Account getAccountByLogin(Account account) throws ServiceException {
        log.info("Service layer getAccountByLogin");

        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();
        try {
            fileAccountDAO.get(account);
        } catch (DAOException e) {
            throw new ServiceException("DAOException", e);
        }
        return account;
    }

    @Override
    public List<Account> getAll() throws ServiceException {
        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();
        List<Account> list = null;
        try {
            list = fileAccountDAO.getAll();
        }catch (DAOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Account getAccountById(int id) throws ServiceException {
    log.info("Service layer getAccountByID");
        FileAccountDAO fileAccountDAO = AccountServiceImpl.getFileAccountDAO();

        try {
            return fileAccountDAO.getAccountById(id);
        }catch (DAOException e) {
            throw new ServiceException("DAOException", e);
        }
    }
}
