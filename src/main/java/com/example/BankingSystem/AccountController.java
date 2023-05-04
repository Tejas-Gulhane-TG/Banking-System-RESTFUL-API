package com.example.BankingSystem;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/SBI")
public class AccountController {
    HashMap<Integer, User> Map1= new HashMap<>();

    @PostMapping("/New-Account-Create")
    public String CreateAccount(@RequestBody User user){
        if(Map1.containsKey(user.getAccountNo())){
            return "Account Number Already Exist";
        }
        else{
            Map1.put(user.getAccountNo(), user);
        }
        return "New Account Created";
    }

//    get Balance using Account No And Password
    @GetMapping("/Get-Balance")
    public String GetBalance(@RequestParam("AccountNo") int AccountNo, @RequestParam("Password") int pass){
        if(Map1.containsKey(AccountNo)){
            User user=Map1.get(AccountNo);
            if(user.getPassword() == pass){
                return "Main balance is : "+user.getBalance();
            }
            else {
                return "Password wrong ";
            }
        }
        return "Account was not found";
    }

//    Get all Account No list
    @GetMapping("/Get-All-Accounts")
    public HashMap<Integer, User> GetAllAccount(){
       return Map1;
    }
//    Withdraw Money
    @GetMapping("/MoneyWithdraw")
    public String WithdrawMoney(@RequestParam("Account-No") int AccountNo, @RequestParam("Password") int Pass, @RequestParam("Money") double Money){
        if(Map1.containsKey(AccountNo)){
            User user=Map1.get(AccountNo);
            if(Pass == user.getPassword()){
                if(user.getBalance()>=Money){
                    user.setBalance(user.getBalance()-Money);
                    return Money+" Money withdraw from Account No "+user.getAccountNo()+" Remaining Balance is "+user.getBalance();
                }
                else return "Insufficient Money";
            }
            else return "Wrong Password";
        }
        else return "Account not Found";
    }

    @GetMapping("/DepositMoney")
    public String DepositMoney(@RequestParam("Account-No") int AccountNo, @RequestParam("Money") double Money){
        if(Map1.containsKey(AccountNo)){
            User user = Map1.get(AccountNo);
            user.setBalance(user.getBalance()+Money);
            return +Money+" Added to the Account No "+user.getAccountNo()+" Main Balance is "+user.getBalance();
        }
        else return "Account was not found";
    }

    @GetMapping("/GetAccountDetails")
    public String GetDetails(@RequestParam("Account-No") int AccountNo, @RequestParam("Password") int Pass){
        if(Map1.isEmpty()){
            return "Bank is Empty ";
        }
        if(Map1.containsKey(AccountNo)){
            User user = Map1.get(AccountNo);
            if(user.getPassword()==Pass){
                return "Account Details \nAccount holder name : "+user.getName()+"\nAge : "+user.getAge()+"\nAccount No : "+user.getAccountNo()+"\nMain balance : "+user.getBalance()+"\nAddress : "+user.getAddress();
            }
            else return "Wrong Password";
        }
        else return "Account Not found";
    }

    @GetMapping("/ChangePassword")
    public String ChangePassword(@RequestParam("Account-No") int AccountNo, @RequestParam("Password") int Pass, @RequestParam("New-Password") int NewPassword){
        if(Map1.containsKey(AccountNo)){
            User user=Map1.get(AccountNo);
            if(Pass == user.getPassword()){
                user.setPassword(NewPassword);
                return "New Password Set";
            }
            else return "Old Password Wrong";
        }
        else return "Account not Found";
    }

    @GetMapping("/DeleteAccount")
    public String DeleteAccount(@RequestParam("AccountNo")int AccountNo, @RequestParam("Password") int Pass){
        if(Map1.containsKey(AccountNo)){
            User user = Map1.get(AccountNo);
            if(user.getPassword() == Pass){
                Map1.remove(AccountNo);
                return "Account Remove from Data base";
            }
            else return "Wrong Password";
        }
        else return "Account Not found";
    }
}
