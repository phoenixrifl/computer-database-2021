package validation;

import exception.IncorrectDateException;
import model.Computer;
import java.time.LocalDate;

public class DateValidator {
    private static DateValidator instance = null;
    private DateValidator(){}

    public final static DateValidator getInstance() {
        if(DateValidator.instance == null) {
            instance = new DateValidator();
        }
        return instance;
    }

    public boolean dateIsValid(Computer computer) throws IncorrectDateException {
        LocalDate introduced = computer.getIntroduced(), discontinued = computer.getDiscontinued();
        boolean isValid = false;
        if(introduced == null && discontinued != null){
            isValid = false;
        }else {
            if(introduced.isAfter(discontinued)) {
                throw new IncorrectDateException("la date de production est supérieur à la date de fin");

            }
            else
                isValid = true;
        }
        return isValid;
    }
}
