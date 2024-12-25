interface CreditCardInterface {
    void viewCreditAmount();
    void useCard(int amount);
    void payCredit(int amount);
    void increaseLimit(int amount);
}

class SilverCardCustomer implements CreditCardInterface {
    String name;
    String cardNumber;
    int creditAmount = 0;
    int creditLimit = 50000;

    public SilverCardCustomer(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void viewCreditAmount() {
        System.out.println("Credit Amount: " + creditAmount);
    }

    @Override
    public void useCard(int amount) {
        if (creditAmount + amount <= creditLimit) {
            creditAmount += amount;
            System.out.println("Card used for " + amount + ". Total credit: " + creditAmount);
        } else {
            System.out.println("Transaction declined. Limit exceeded.");
        }
    }

    @Override
    public void payCredit(int amount) {
        if (creditAmount >= amount) {
            creditAmount -= amount;
            System.out.println("Paid " + amount + ". Remaining credit: " + creditAmount);
        } else {
            System.out.println("Insufficient credit amount.");
        }
    }

    @Override
    public void increaseLimit(int amount) {
        System.out.println("Silver card limit cannot be increased.");
    }
}

class GoldCardCustomer extends SilverCardCustomer {
    int increaseCount = 0;

    public GoldCardCustomer(String name, String cardNumber) {
        super(name, cardNumber);
        creditLimit = 100000;
    }

    @Override
    public void increaseLimit(int amount) {
        if (increaseCount < 3 && amount <= 5000) {
            creditLimit += amount;
            increaseCount++;
            System.out.println("Limit increased by " + amount + ". New credit limit: " + creditLimit);
        } else {
            System.out.println("Limit increase failed. Either limit exceeded or maximum increases reached.");
        }
    }
}

public class CreditCardTest {
    public static void main(String[] args) {
        SilverCardCustomer silver = new SilverCardCustomer("Alice", "1234567812345678");
        GoldCardCustomer gold = new GoldCardCustomer("Bob", "8765432187654321");

        silver.viewCreditAmount();
        silver.useCard(20000);
        silver.payCredit(5000);
        silver.increaseLimit(1000);

        gold.viewCreditAmount();
        gold.useCard(50000);
        gold.payCredit(10000);
        gold.increaseLimit(3000);
    }
}
