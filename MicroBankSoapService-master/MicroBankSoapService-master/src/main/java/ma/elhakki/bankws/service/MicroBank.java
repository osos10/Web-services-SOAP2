package ma.elhakki.bankws.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import ma.elhakki.bankws.Utils;
import ma.elhakki.bankws.entities.Account;

import java.util.*;
import java.util.stream.Stream;

@WebService(name = "BankWS")
public class MicroBank {

    @WebMethod
    public double toMAD(@WebParam(name="euroAmount") double amountInEuro) {
        return amountInEuro * 15;
    }

    @WebMethod
    public Account getAccount(int code) {
        return new Account(code, Utils.randomAmount(), new Date());
    }

    @WebMethod
    public List<Account> getAccounts() {
        return Stream.generate(Utils::randomAccount)
                .distinct()
                .limit(50)
                .toList();
    }

}
