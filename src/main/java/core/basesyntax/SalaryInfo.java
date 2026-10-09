package core.basesyntax;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        DateTimeFormatter dateTimeFormatter = new DATE_FORMATTER;
        StringBuilder result = new StringBuilder();
        result.append("Report for period " + dateFrom + " - " + dateTo);
        LocalDate dateBegin;
        LocalDate dateEnd;
        try {
            dateBegin = LocalDate.parse(dateFrom);
            dateEnd = LocalDate.parse(dateTo);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        for (String name : names) {
            int salaryByHour = 0;
            for (String lnData : data) {
                int namePosition = lnData.indexOf(name);
                if (namePosition != -1) {
                    String[] dataFields = lnData.split(" ");
                    LocalDate paymentDate;
                    try {
                        paymentDate = LocalDate.parse(dataFields[0]);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    if (!paymentDate.before(dateBegin) && !paymentDate.after(dateEnd)) {
                        String[] salary = dataFields;
                        if (salary[1].equals(name)) {
                            salaryByHour += Integer.parseInt(salary[2]) * Integer.parseInt(salary[3]);
                        }
                    }
                }
            }
            result.append(name + " - " + salaryByHour);
            System.lineSeparator()
        }
        return result.toString();
    }
}
