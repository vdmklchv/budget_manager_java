package budget;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MoneyFormatter {
    static String format(double digit) {
        DecimalFormat df = new DecimalFormat("#,###,###,##0.00", new DecimalFormatSymbols(Locale.US));
        return df.format(digit);
    }
}
