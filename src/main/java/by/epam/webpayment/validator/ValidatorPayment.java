package by.epam.webpayment.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorPayment {
    public static boolean validator(String amount){
        return amountValid(amount);
    }

    public static boolean validator(String name, String amount, String number) {
        return nameValid(name) && amountValid(amount) && numberValid(number);
    }

    private static boolean nameValid(String name) {
        Pattern p = Pattern.compile("(^[A-Z]{1}[A-Za-z]{1,14}|[А-Я]{1}[а-я]{1,20}$)");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private static boolean amountValid(String amount) {
        Pattern p = Pattern.compile("^(?!0.*$)([0-9]{1,3}(,[0-9]{3})?(,[0-9]{3})?(\\.[0-9]{2})?)$");
        Matcher m = p.matcher(amount);
        return m.matches();
    }

    private static boolean numberValid(String number) {
        Pattern p = Pattern.compile("^[0-9]{4,10}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
