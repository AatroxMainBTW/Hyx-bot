import BotCommand.Bot;
import BotCommand.Constant;

public class main {
    public static void main(String [] args){
        Bot bot = new Bot(Constant.TOKEN);
        bot.Build();

    }

}
