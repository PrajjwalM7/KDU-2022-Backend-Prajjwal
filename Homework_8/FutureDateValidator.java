import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class FutureDateValidator implements
        ConstraintValidator<ValidFutureDate, Date> {

    @Override
    public void initialize(ValidFutureDate validFutureDate) {
    }

    @Override
    public boolean isValid(Date  givenDate, ConstraintValidatorContext cxt) {
        // Current Date
        Date currDate = new Date();
        return (givenDate.compareTo(currDate) > 0) ? true : false;
    }

}