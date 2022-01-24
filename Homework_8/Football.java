import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Football implements Game{
    @NotNull(message = "Team cannot be null")
    @Size(min = 2, max = 10, message
            = "Team name must be between 2 and 10 characters")
    private String team1;

    @NotNull(message = "Team cannot be null")
    @Size(min = 2, max = 10, message
            = "Team name must be between 2 and 10 characters")
    private String team2;

    @Size(min = 1000, max = 15000, message = "Seats must be between 1000 and 15000")
    private int seats;

    // Custom Validator to check if the given date lies in the future
    @ValidFutureDate
    private Date date;

    @Override
    public void playGame() {
        System.out.println("Football : " + team1 + " playing " + team2 + " on " + date);
    }
}
