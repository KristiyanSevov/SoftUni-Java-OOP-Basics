package Ex1_BankAccount;

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
            int id = Integer.parseInt(inputs[1]);
            switch (command) {
                case "Create":
                    if (accounts.containsKey(id)) {
                        System.out.println("Account already exists");
                    } else {
                        accounts.put(id, new BankAccount(id));
                    }
                    break;
                case "Deposit":
                    BankAccount accToDeposit = accounts.get(id);
                    if (accToDeposit == null) {
                        System.out.println("Account does not exist");
                    } else {
                        double amount = Double.parseDouble(inputs[2]);
                        accToDeposit.deposit(amount);
                    }
                    break;
                case "Withdraw":
                    BankAccount accToWithdraw = accounts.get(id);
                    if (accToWithdraw == null) {
                        System.out.println("Account does not exist");
                    } else {
                        double amount = Double.parseDouble(inputs[2]);
                        try {
                            accToWithdraw.withdraw(amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Print":
                    BankAccount accToPrint = accounts.get(id);
                    if (accToPrint == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(accToPrint);
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
