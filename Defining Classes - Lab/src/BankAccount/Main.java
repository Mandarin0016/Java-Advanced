package BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        List<BankAccount> accounts = new ArrayList<>();
        List<Integer> accountsId = new ArrayList<>();
        while (!data[0].equals("End")) {
            BankAccount newBankAccount;
            switch (data[0]) {
                case "Create":
                    newBankAccount = new BankAccount();
                    System.out.printf("Account ID%d created%n", newBankAccount.getAccountId());
                    accounts.add(newBankAccount);
                    accountsId.add(newBankAccount.getAccountId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    int amount = Integer.parseInt(data[2]);
                    if (!accountsId.contains(id)){
                        System.out.println("Account does not exist");
                    }else {
                        accounts.get(id - 1).deposit(amount);
                        System.out.println("Deposited " + amount + " to ID" + id);
                    }
                    break;
                case "SetInterest":
                    double newInterestRate = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    break;
                case "GetInterest":
                    int bankId = Integer.parseInt(data[1]);
                    if (!accountsId.contains(bankId)){
                        System.out.println("Account does not exist");
                    }else {
                        int years = Integer.parseInt(data[2]);
                        System.out.printf("%.2f%n", accounts.get(bankId - 1).getInterest(years));
                    }
                    break;
            }
            data = scanner.nextLine().split("\\s+");
        }
    }
}
