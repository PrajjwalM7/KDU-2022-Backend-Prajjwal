import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    // Throwing exception
    @Bean(name = "myCricketGame")
    @Scope("singleton")
    public Game createCricketGame() throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Cricket c = new Cricket();
        c.setTeam1("CSK");
        c.setTeam2("M");
        c.setDate(sdformat.parse("2020-12-12"));
        c.setSeats(100);
        return c;
    }

    // No need to throw ParseException here as we have used SneakyThrows to avoid writing checked exceptions
    @Bean(name = "myFootballGame")
    @Scope("singleton")
    @SneakyThrows
    public Game createFootballGame() {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Football f =  new Football();
        f.setDate(sdformat.parse("2024-05-08"));
        f.setTeam1("Madrid");
        f.setTeam2("Barca");
        f.setSeats(1200);
        return f;
    }

    @Bean(name = "playGame")
    @Scope("singleton")
    public PlayGame createPlayGame() {
        PlayGame playGame = new PlayGame();
        playGame.setEmail("prajjwal");
        return playGame;
    }

    @Bean
    public Validator createValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
