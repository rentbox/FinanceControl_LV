package main.by.javatr.controller.command.impl.admincommand;

import main.by.javatr.bean.Account;
import main.by.javatr.bean.Session;
import main.by.javatr.controller.command.Command;
import main.by.javatr.service.AccountService;
import main.by.javatr.service.exception.ServiceException;
import main.by.javatr.service.impl.AccountServiceImpl;
import org.apache.log4j.Logger;

public class GetAdmin implements Command {

    private static Logger log = Logger.getLogger(GetAdmin.class.getName());

    @Override
    public String execute(String request){

        log.info("Controller layer execute");

        Session session = Session.getInstance();
        Account account = session.getAccount();


        if(!session.isLogin()) return "wrong request";

        if(account.isAdmin()){

            String[] str = request.split(" ");

            if(str.length != 2){
                return "wrong request";
            }

            AccountService service = new AccountServiceImpl();

            Account account1 = new Account();
            account1.setLogin(str[1]);


            try {
                if (service.checkRegistration(account1)){
                    service.getAccountByLogin(account1);
                    account1.setAdmin(true);
                    service.update(account1);
                    return new String(account1.getLogin() + " become an admin");
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }


        }
            return new String("failed");
    }
}
