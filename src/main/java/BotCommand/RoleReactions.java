package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.WidgetUtil;

import java.awt.*;
import java.util.HashMap;

public class RoleReactions extends ListenerAdapter {

    final long channelID = 776253949724196867L;
    final String EmoteG ="\uD83C\uDFAE";
    final String EmoteP ="\uD83D\uDDA5";
    final long RankG =775463265856782336L;
    final long RankP =775466827748605993L;
    HashMap<Long, Long> reactionroleID = new HashMap<Long, Long>();

    public RoleReactions(){
        reactionroleID.put(775466247252738049L,775463265856782336L); //little designer
        reactionroleID.put(775466638010613760L,775466827748605993L); //Advanced designer
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){

        if (e.getTextChannel().getIdLong() == channelID){
            if (e.getUser().getJDA().getSelfUser().isBot()){
                return;
            }
           if (e.getReactionEmote().getEmoji().equals(EmoteG)){
               e.getGuild().addRoleToMember(e.getMember(),e.getJDA().getRoleById(RankG)).queue();
           } else if (e.getReactionEmote().getEmoji().equals(EmoteP)){
               e.getGuild().addRoleToMember(e.getMember(),e.getJDA().getRoleById(RankP)).queue();
           }
          /* Long RoleID = reactionroleID.get(e.getReactionEmote().getIdLong());
            if (RoleID == null){
                return;
            } else {
                System.out.println(e.getReactionEmote().getIdLong());
                    e.getGuild().addRoleToMember(e.getMember(),e.getJDA().getRoleById(RoleID)).queue();

            }*/

            }


            }



    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e){
        if (e.getTextChannel().getIdLong() == channelID){

            if (e.getReactionEmote().getEmoji().equals(EmoteG)){
                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(RankG)).queue();
            } else if (e.getReactionEmote().getEmoji().equals(EmoteP)){
                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(RankP)).queue();
        }

           /* Long RoleID = reactionroleID.get(e.getReactionEmote().getIdLong());
            if (RoleID == null){
                return;
            }

            e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(RoleID)).queue();

        }*/
    }
    }

}
