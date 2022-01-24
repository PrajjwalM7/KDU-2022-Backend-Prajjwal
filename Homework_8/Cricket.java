import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class Cricket implements Game{

    @NotNull(message = "Team cannot be null")
    @Size(min = 2, max = 10, message
            = "Team name must be between 2 and 10 characters")
    private String team1;

    @NotNull(message = "Team cannot be null")
    @Size(min = 2, max = 10, message
            = "Team name must be between 2 and 10 characters")
    private String team2;

    // Custom Validator to check if the given date lies in the future
    @ValidFutureDate
    private Date date;

    @Min(value = 1000, message = "Minimum 1000 seats madatory.")
    @Max(value= 12000, message = "Maximum of 12000 seats allowed.")
    private int seats;

    @Override
    public void playGame() {
        System.out.println("Cricket : " + this.team1 + " playing " + this.team2 + " on " + this.date);
    }
}
