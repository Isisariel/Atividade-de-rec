public class AccountRecord {
    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    // Construtor padrão
    public AccountRecord() {
        this(0, "", "", 0.0);
    }

    // Construtor com parâmetros
    public AccountRecord(int account, String firstName, String lastName, double balance) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    // Métodos de acesso e modificação para account
    public void setAccount(int account) {
        this.account = account;
    }

    public int getAccount() {
        return account;
    }

    // Métodos de acesso e modificação para firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    // Métodos de acesso e modificação para lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    // Métodos de acesso e modificação para balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Representação textual do objeto AccountRecord
    @Override
    public String toString() {
        return String.format("Account: %d%nFirst Name: %s%nLast Name: %s%nBalance: %.2f%n",
                             account, firstName, lastName, balance);
    }
}