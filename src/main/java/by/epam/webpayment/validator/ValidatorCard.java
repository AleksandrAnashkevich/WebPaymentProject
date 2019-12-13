package by.epam.webpayment.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorCard {

    public static boolean numberValid(String number){
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public static boolean depositValid(String deposit){
        Pattern p = Pattern.compile("^(?!0.*$)([0-9]{1,3}(,[0-9]{3})?(,[0-9]{3})?(\\.[0-9]{2})?)$");
        Matcher m = p.matcher(deposit);
        return m.matches();
    }


}
