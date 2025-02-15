package baseball.deprecated;

public class GameController {
    private static final UserService userService = new UserService();
    private static final ComputerService computerService = new ComputerService();
    private static final GameViewer gameViewer = new GameViewer();
    private static final Game game = new Game();

    public void startGame(){
        GameViewer.startGameMessage();

        boolean willRestart = true;
        Computer computer = computerService.createComputer();

        while (willRestart) {
            User user = userService.createUser(gameViewer.getUserGuess());

            boolean won = game.checkAndCalcUserGuess(user, computer);

            gameViewer.displayGuessResult(game.getStrike(), game.getBall());

            if (won) {
                computer = computerService.createComputer();
                willRestart = gameViewer.hasNewGameMessage();
            }
        }

    }
}
