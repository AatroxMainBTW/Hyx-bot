package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ClientType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class PingPong extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()){
            return;
        }
        long time = System.currentTimeMillis();
        if (e.getMessage().getContentRaw().equals(Constant.prefix+"ping")){
            e.getChannel().sendMessage("pong ! ").queue(response -> {
                response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
            });
        }
    }

   /* public MessageEmbed createEmbed(){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("!ping");
        embedBuilder.addField("pong!","Good game really !",true);
        embedBuilder.setThumbnail("https://www.ippinka.com/wp-content/uploads/2017/05/Pong-1.jpg");
        embedBuilder.setFooter("Really its a good game ! u should play it");
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setAuthor("Hyx ");

        return embedBuilder.build();
    }*/
}
