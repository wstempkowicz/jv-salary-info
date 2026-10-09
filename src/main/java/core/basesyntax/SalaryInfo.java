package core.basesyntax;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        String[] salary;
        int i = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        for (String name : names) {
            for (String lnData : data) {
                int namePosition = lnData.indexOf(name);
                if (namePosition != -1) {
                    Date paymentDate = lnData.substring(0, namePosition);
                    Date dateBegin = simpleDateFormat.parse(dateFrom);
                    Date dateEnd = simpleDateFormat.parse(dateTo);
                    if (paymentDate.before(dateTo) 
                        && paymentDate.after(dateFrom) 
                        && paymentDate.compareTo(dateTo)
                        && paymentDate.compareTo(dateFrom)) {
                        if(salary[name]){
                            i--;
                            String[] salaryAdd = lnData.split("[ ]");
                            salary[name][i][2] += salaryAdd[2] * salaryAdd[3];
                        } else {
                            salary[name][i] = lnData.split("[ ]");
                            salary[name][i][2] = salary[i][2] * salary[i][3];
                            i++;
                        }
                    }
                }
            }
        }
        StringBuilder result = "Report for period" dateFrom " - " dateTo;
        for(int i = 0; i < salary.length; i++){
            result.append(\n salary[i].[1]+" - "+ salary[i].[2] );
}

    }
}
