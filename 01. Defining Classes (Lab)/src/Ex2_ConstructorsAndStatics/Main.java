package Ex2_ConstructorsAndStatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> accounts = new HashMap<>();
        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] inputs = input.split(" ");
            String command = inputs[0];
            switch (command) {
                case "Create":
                    BankAccount newAcc = new BankAccount();
                    accounts.put(newAcc.getId(), newAcc);
                    System.out.printf("Account %s created%n", newAcc);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(inputs[1]);
                    BankAccount accToDeposit = accounts.get(id);
                    if (accToDeposit == null) {
                        System.out.println("Account does not exist");
                    } else {
                        double amount = Double.parseDouble(inputs[2]);
                        accToDeposit.deposit(amount);
                        System.out.printf("Deposited %.0f to %s%n",amount, accToDeposit);
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(inputs[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int accId = Integer.parseInt(inputs[1]);
                    BankAccount acc = accounts.get(accId);
                    if (acc == null) {
                        System.out.println("Account does not exist");
                    } else {
                        int years = Integer.parseInt(inputs[2]);
                        System.out.printf("%.2f%n", acc.getInterest(years));
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
