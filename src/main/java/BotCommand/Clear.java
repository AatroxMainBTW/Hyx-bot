package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class Clear extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String arg [] = e.getMessage().getContentRaw().split("\\s+");
        if (e.getMessage().getContentRaw().startsWith(Constant.prefix+"clear")){
            if (arg.length < 2){
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.ORANGE);
                usage.setTitle("\uD83C\uDE51️Specify amount to delete");
                usage.setDescription("Usage : "+"!clear [# number of messages]");
                e.getChannel().sendMessage(usage.build()).queue();
            }
            else {
                try {
                    List<Message> messages = e.getChannel().getHistory().retrievePast(Integer.parseInt(arg[1])).complete();
                    e.getChannel().deleteMessages(messages).queue();
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(Color.GREEN);
                    success.setTitle("\uD83C\uDE2F️successfully deleted ! "+ arg[1] + ".");
                    e.getChannel().sendMessage(success.build()).queue();
                }catch (IllegalArgumentException ex){
                    if (ex.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                    // too many messages
                    EmbedBuilder errorTooMany = new EmbedBuilder();
                    errorTooMany.setColor(Color.RED);
                    errorTooMany.setTitle("\uD83C\uDE32️Too many Messages Selected");
                    errorTooMany.setDescription("Between 1 - 100 messages can be deleted");
                    e.getChannel().sendMessage(errorTooMany.build()).queue();
                } else {
                        //too old messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(Color.RED);
                        error.setTitle("\uD83C\uDE32️Selected messages are older than 2 weeks");
                        error.setDescription("Messages older than two weeks cannot be deleted");
                        e.getChannel().sendMessage(error.build()).queue();
                    }

            }

        }
    }
}
}
