package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Negin Mousavi
 */
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "cart_number")
    private String cartNumber;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Column(name = "opening_date")
    private Date openingDate;
    private double balance;
    @Column(length = 4)
    private String cvv2;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @ManyToOne
    private User user;
    // اطلاعات سه تراکنش آخر انجام شده به همراه تاریخ آنها.
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public String toString() {
        return "model.Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", cartNumber='" + cartNumber + '\'' +
                ", type=" + type +
                ", openingDate=" + openingDate +
                ", balance=" + balance +
                ", cvv2='" + cvv2 + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
