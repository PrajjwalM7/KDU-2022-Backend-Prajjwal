import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;

@Component
@Data
public class PlayGame {
    @Autowired
    @Qualifier("myCricketGame")
    private Game cricketGame;

    @Autowired
    @Qualifier("myFootballGame")
    private Game footballGame;

    @Email(message = "Email not valid!")
    private String email;

    public void startGame() {
        cricketGame.playGame();
        footballGame.playGame();
    }

    public Game getCricketGame() { return cricketGame; }
    public Game getFootballGame() { return footballGame; }
    public void setCricketGame(Game g) { this.cricketGame = g; }
    public void setFootballGame(Game g) { this.footballGame = g; }
}
