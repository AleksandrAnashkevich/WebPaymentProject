package by.epam.webpayment.validator;

import by.epam.webpayment.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUser {

    public static boolean validator(User user) {
        return firstNameValid(user.getFirstName())&&secondNameValid(user.getSecondName())&&
                loginValid(user.getLogin())&&passwordValid(user.getPassword())&&
                emailValid(user.getEmail());
    }

    private static boolean firstNameValid(String firstName) {
        Pattern p = Pattern.compile("(^[A-Z]{1}[a-z]{1,14}|[А-Я]{1}[а-я]{1,14}$)");
        Matcher m = p.matcher(firstName);
        return m.matches();
    }

    private static boolean secondNameValid(String secondName) {
        Pattern p = Pattern.compile("(^[A-Z]{1}[a-z]{1,14}|[А-Я]{1}[а-я]{1,14}$)");
        Matcher m = p.matcher(secondName);
        return m.matches();
    }

    private static boolean loginValid(String login) {
        Pattern p = Pattern.compile("(^[0-9a-z]{1,14}$)");
        Matcher m = p.matcher(login);
        return m.matches();
    }

    private static boolean passwordValid(String password) {
        Pattern p = Pattern.compile("(^[0-9a-z]{1,14}$)");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    private static boolean emailValid(String email){
        Pattern p = Pattern
                .compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
