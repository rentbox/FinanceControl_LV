package main.by.javatr.controller.command.impl;

import main.by.javatr.bean.Account;
import main.by.javatr.bean.Session;
import main.by.javatr.controller.command.Command;
import main.by.javatr.controller.exception.ControllerException;
import main.by.javatr.controller.validation.ControllerValidation;
import main.by.javatr.service.AccountService;
import main.by.javatr.service.exception.ServiceException;
import main.by.javatr.service.impl.AccountServiceImpl;
import org.apache.log4j.Logger;

public class ChangeTransport implements Command {

    private static Logger log = Logger.getLogger(ChangeTransport.class.getName());

    @Override
    public String execute(String request) throws ControllerException {
        log.info("Controller layer execute");

        String[] str = request.trim().split(" +");

        Session session = Session.getInstance();
        Account account = session.getAccount();

        if(!ControllerValidation.isBan() && ControllerValidation.isLogin() && str.length == 2) {

            try {
                account.setTransport(account.getTransport() + Double.parseDouble(str[1]));
            }catch (NumberFormatException e){
                throw new ControllerException("NumericFormatException");
            }
            AccountService accountService = new AccountServiceImpl();
            try {
                accountService.changeCategory(account);
            } catch (ServiceException e) {
                throw new ControllerException("Service Exc", e);
            }
            return new String("Balance " + account.getBalance() + account.getCurrentCur() + " Expenses " + account.getExpenses() + account.getCurrentCur() + " Food " + account.getFood() + account.getCurrentCur() + " Transport " + account.getTransport() + account.getCurrentCur() + " Entertainment " + account.getEntertainment() + account.getCurrentCur() + " Other " + account.getOther() + account.getCurrentCur());
        }
    return "wrong request";
    }
}
