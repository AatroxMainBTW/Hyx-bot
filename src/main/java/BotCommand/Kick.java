package BotCommand;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()){
            return;
        }
        if (e.getMessage().getContentRaw().startsWith(Constant.prefix+"kick")){
                if (e.getMember().hasPermission(Permission.KICK_MEMBERS)){
                    for (Member member : e.getMessage().getMentionedMembers()){
                        member.kick("The bad guy has been kicked").queue();

                    }
                }
        }
    }
}
