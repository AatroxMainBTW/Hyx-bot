package BotCommand.Games;

import BotCommand.Constant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuessTheNumber extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if (event.getMessage().getContentRaw().equals("!guess")){
            if (event.getAuthor().isBot()){
                return;
            }
            EmbedBuilder Message_Guess =new EmbedBuilder();
            Message_Guess.setTitle("Guess Number Game !");
            Message_Guess.addField("Easy","\uD83D\uDFE9",true);
            Message_Guess.addField("Medium","\uD83D\uDFE7",true);
            Message_Guess.addField("Hard","\uD83D\uDFE5",true);
            Message_Guess.setDescription("\uD83C\uDFAF Welcome to the guess number game ");
            event.getChannel().sendMessage(Message_Guess.build()).queue(message -> {
                message.addReaction("\uD83D\uDFE9").queue();
                message.addReaction("\uD83D\uDFE7").queue();
                message.addReaction("\uD83D\uDFE5").queue();
            });

        }
    }



}
