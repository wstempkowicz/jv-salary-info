package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder result = new StringBuilder("");
        result.append("Report for period " + dateFrom.trim() + " - " + dateTo.trim());
        LocalDate dateBegin = LocalDate.parse(dateFrom.trim(), DATE_FORMATTER);
        LocalDate dateEnd = LocalDate.parse(dateTo.trim(), DATE_FORMATTER);
        String[] dataLn;
        for (int i = 0; i < names.length; i++) {
            int salaryByHour = 0;
            if (dateBegin.isBefore(dateEnd)) {
                for (int j = 0; j < data.length; j++) {
                    dataLn = data[j].split("\\s+");
                    if (dataLn[1].equals(names[i])) {
                        LocalDate paymentDate = LocalDate.parse(dataLn[0], DATE_FORMATTER);
                        if (!paymentDate.isBefore(dateBegin) && !paymentDate.isAfter(dateEnd)) {
                            salaryByHour += Integer.parseInt(dataLn[2])
                                    * Integer.parseInt(dataLn[3]);
                        }
                    }
                }

            }
            result.append(System.lineSeparator() + names[i] + " - " + salaryByHour);
        }
        return result.toString();
    }
}
