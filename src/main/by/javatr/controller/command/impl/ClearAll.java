package main.by.javatr.controller.command.impl;

import main.by.javatr.bean.Account;
import main.by.javatr.controller.command.Command;
import main.by.javatr.controller.controllerException.ControllerException;
import main.by.javatr.service.ServiceException.ServiceException;

public class ClearAll implements Command {
    @Override
    public String execute(String request) throws ControllerException, ServiceException {

        String[] str = request.split(" ");

        if(str.length != 1) return "wrong request";

        if(Account.getAccount() == null) return "wrong request";

        if(!Account.getAccount().isBan()) {


            Account account = Account.getInstance();

            account.setOther(0);
            account.setFood(0);
            account.setEntertainment(0);
            account.setTransport(0);
            account.setExpenses(0);
            account.setBalance(0);
            account.setCurrentCur('$');

            return "Balance " + account.getBalance() + account.getCurrentCur() + " Expenses " + account.getExpenses() + account.getCurrentCur() + " Food " + account.getFood() + account.getCurrentCur() + " Transport " + account.getTransport() + account.getCurrentCur() + " Entertainment " + account.getEntertainment() + account.getCurrentCur() + " Other " + account.getOther() + account.getCurrentCur();
        }
    return "wrong request";
    }
}