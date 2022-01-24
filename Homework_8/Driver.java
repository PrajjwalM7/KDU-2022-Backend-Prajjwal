import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        PlayGame playGame = context.getBean(PlayGame.class);
        playGame.startGame();

        Validator validator = context.getBean(Validator.class);

        final Game game = context.getBean(Cricket.class);
        Set<ConstraintViolation<PlayGame>> playGameViolations = validator.validate(playGame);
        Set<ConstraintViolation<Game>> gameViolations = validator.validate(game);

        for (ConstraintViolation<Game> violation : gameViolations) {
            System.err.println(violation.getMessage());
        }

        for (ConstraintViolation<PlayGame> violation : playGameViolations) {
            System.err.println(violation.getMessage());
        }

    }
}
