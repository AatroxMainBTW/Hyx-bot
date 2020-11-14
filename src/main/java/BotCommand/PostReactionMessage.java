package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class PostReactionMessage extends ListenerAdapter {
    final long channelID = 776253949724196867L;

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()){

            return;
        }
        if (e.getMessage().getContentRaw().startsWith("-post")){
            if (e.getTextChannel().getIdLong() == channelID){
                EmbedBuilder Message_reac =new EmbedBuilder();
                Message_reac.setTitle("Choose one !");
                Message_reac.addField("Are u an gamer","\uD83C\uDFAE",false);
                Message_reac.addField("Or an programmer ","\uD83D\uDDA5",false);
                Message_reac.setDescription("Choose "+"\uD83D\uDC41️\u200D\uD83D\uDDE8 \uD83D\uDC41️\u200D\uD83D\uDDE8️" +
                        "");
                Message_reac.setColor(Color.CYAN);
                e.getChannel().sendMessage(Message_reac.build()).queue(message -> {
                    message.addReaction("\uD83C\uDFAE").queue();
                    message.addReaction("\uD83D\uDDA5").queue();
                });

                e.getChannel().deleteMessageById(e.getMessage().getId()).queue();




            }

        }
    }
}
