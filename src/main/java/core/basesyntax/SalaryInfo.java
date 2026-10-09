package core.basesyntax;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        int[] salary;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        for (String name : names) {
            for (String lnData : data) {
                int namePosition = lnData.indexOf(name);
                if (namePosition != -1) {
                    Date paymentDate = lnData.substring(0, namePosition);
                    Date dateFrom = simpleDateFormat.parse(dateFrom);
                    Date dateTo = simpleDateFormat.parse(dateTo);
                    if (paymentDate.before(dateTo) && paymentDate.after(dateFrom)) {
                        if(salary)
                        String salary = lnData.split("[ ]");
                    }
                }
            }
        }
        for()
        salaryTime = "Report for period" dateFrom " - " dateTo;
        salary +

    }
}
