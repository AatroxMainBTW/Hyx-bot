package BotCommand;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class invite extends ListenerAdapter {
    String url = "https://discord.com/oauth2/authorize?client_id=%s&scope=bot";
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()){
            return;
        }
        if (e.getMessage().getContentRaw().equals(Constant.prefix+"invite")){
            e.getChannel().sendMessage(String.format(url,e.getJDA().getSelfUser().getId())).queue();
        }
    }
}
