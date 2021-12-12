import model.Account;
import model.AccountType;
import model.User;
import service.AccountService;
import service.UserService;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class Main {
    static UserService userService = new UserService();
    static AccountService accountService = new AccountService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Hi :) what do you wanna do?\n1.create an account\n2.update your info\n3.deposit\n4.withdraw\nyour answer: ");
        byte answer;
        answerLoop:
        do {
            answer = scanner.nextByte();
            switch (answer) {
                case 1:
                    createAcc();
                    break answerLoop;
                case 2:
                    updateUserInfo();//TODO
                    break answerLoop;
                case 3:
                    deposit();//TODO
                    break answerLoop;
                case 4:
                    withdraw();//TODO
                    break answerLoop;
                default:
                    printInvalidInput();
            }
        } while (true);

/*        User user = new User();
        user.setCreationDate(new Date());
        user.setFirstName("jack");
        user.setLastName("ho");
        user.setNationalCode("0021899436");
        user.setType(UserType.GOOD_DEALER);*/

/*        Account account = new Account();
        account.setAccountNumber("002211");
        account.setBalance(25000);
        account.setCartNumber("32165412");
        account.setCvv2("2741");
        account.setOpeningDate(new Date());
        account.setType(AccountType.CURRENT);
        account.setUser(user);
        user.getAccounts().add(account);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();*/

/*        System.out.println(userService.findByFirstName("jack"));
        System.out.println(userService.findByLastName("ho"));*/


/*        String userName;

        session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "Select user.firstName from User user where user.nationalCode=:code";
            System.out.println(hql);
            Query query = session.createQuery(hql);
            query.setParameter("code", "0021899436");
            List result = query.list();

            System.out.println("result set: " + result);

            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                userName = (String) iterator.next();
            }
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }*/
    }

    private static void createAcc() {
        User user;
        System.out.print("Do you have account yet?(y/n)\nyour answer: ");
        scanner.nextLine();
        String answer = scanner.nextLine();
        if (answer.equals("n"))
            user = getNewUserInfo();
        else
            user = getUser();

        System.out.print("ok... what account do you want?\n1.SHORT_TERM\n2.LONG_TERM\n3.CURRENT\n4.GOOD_LOAN\nyour answer: ");
        byte accountType = scanner.nextByte();
        Account account = new Account();
        switch (accountType) {
            case 1:
                account.setType(AccountType.SHORT_TERM);
                break;
            case 2:
                account.setType(AccountType.LONG_TERM);
                break;
            case 3:
                account.setType(AccountType.CURRENT);
                break;
            default:
            case 4:
                account.setType(AccountType.GOOD_LOAN);
                break;
        }

        account.setAccountNumber(generateNumberString("10", 1000000000));
        account.setCartNumber(generateNumberString("7", 7777777));
        account.setCvv2(generateNumberString("4", 4444));
        account.setOpeningDate(new Date());
        System.out.print("enter your base balance: ");
        double balance = scanner.nextDouble();
        account.setBalance(balance);
        //TODO: expirationDate
        account.setUser(user);
        accountService.save(account);
    }

    private static void printInvalidInput() {
        System.out.println("invalid input");
    }

    private static User getUser() {
        System.out.print("enter your name: ");
        String name = scanner.nextLine();
        return userService.findByFirstName(name);
    }

    private static User getNewUserInfo() {
        User user = new User();
        System.out.print("first name: ");
        String fName = scanner.nextLine();
        System.out.print("last name: ");
        String lName = scanner.nextLine();
        System.out.print("national code: ");
        String nationalCode = scanner.nextLine();
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setNationalCode(nationalCode);
        user.setCreationDate(new Date());
        return user;
    }

    public static String generateNumberString(String digit, int bound) {
        Random rnd = new Random();
        int number = rnd.nextInt(bound);
        String format = "%0" + digit + "d";
        return String.format(format, number);
    }

    private static void withdraw() {

    }

    private static void deposit() {

    }

    private static void updateUserInfo() {
        System.out.print("enter your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        User user = userService.findByFirstName(name);
        System.out.print("hi %s %s. which field do you wanna edit?\n1.first name\n2.last name\n3.national code\nyour answer: ");
        byte answer = scanner.nextByte();
        System.out.print("it will be: ");
        scanner.nextLine();
        String changedTo = scanner.nextLine();
        switch (answer) {
            case 1:
                userService.editFirstName(user, changedTo);
                break;
            case 2:
                userService.editLastName(user, changedTo);
                break;
            case 3:
                userService.editNationalCode(user, changedTo);
                break;
            default:
                printInvalidInput();
        }
        System.out.println("...DONE...");
    }
}
