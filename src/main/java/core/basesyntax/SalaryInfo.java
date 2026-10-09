package core.basesyntax;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        int i = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder result = new StringBuilder();
        result.append("Report for period " + dateFrom + " - " + dateTo);
        Date dateBegin;
        Date dateEnd;
        try {
            dateBegin = simpleDateFormat.parse(dateFrom);
            dateEnd = simpleDateFormat.parse(dateTo);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        for (String name : names) {
            int salaryByHour = 0;
            for (String lnData : data) {
                int namePosition = lnData.indexOf(name);
                if (namePosition != -1) {
                    String tmpDate = lnData.trim().substring(0, namePosition);
                    Date paymentDate;
                    try {
                        paymentDate = simpleDateFormat.parse(tmpDate);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    if (!paymentDate.before(dateBegin) && !paymentDate.after(dateEnd)) {
                        String[] salary = lnData.split("[ ]");
                        if (salary[1].equals(name)) {
                            salaryByHour += Integer.parseInt(salary[2]) * Integer.parseInt(salary[3]);
                        }
                    }
                }
            }
            result.append("\n" + name + " - " + salaryByHour);
            i++;
        }
        return result.toString();
    }
}
