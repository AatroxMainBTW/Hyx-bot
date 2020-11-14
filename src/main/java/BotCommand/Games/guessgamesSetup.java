package BotCommand.Games;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class guessgamesSetup extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){
        if (e.getReactionEmote().getEmoji().equals("\uD83D\uDFE9")){
            if (e.getUser().isBot()){
                return;
            }
            EmbedBuilder Message_Guess =new EmbedBuilder();
            Message_Guess.setTitle("\uD83D\uDFE9 You selected easy mode ");
            Message_Guess.setDescription("\uD83C\uDFAF guess a number between 1-10 ");
            e.getChannel().sendMessage(Message_Guess.build()).queue();
            int secretnumber = getRandomInteger(10,1);
            System.out.println(secretnumber);
            
        }

    }
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum; }
}
