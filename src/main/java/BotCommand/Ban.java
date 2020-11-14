package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class Ban extends ListenerAdapter {
    int i;
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()){
            return;
        }
        List<Member> mentionedMembers = e.getMessage().getMentionedMembers();

        if (e.getMessage().getContentRaw().startsWith(Constant.prefix+"ban")){
            if (e.getMember().hasPermission(Permission.BAN_MEMBERS)){
                i++;
                for (Member member : e.getMessage().getMentionedMembers()){
                    EmbedBuilder BanR = new EmbedBuilder();
                    BanR.setAuthor(e.getJDA().getSelfUser().getAsTag(),e.getJDA().getSelfUser().getAvatarUrl());
                    BanR.setTitle("Ban Tab");
                    BanR.setDescription("Name : "+"<@"+mentionedMembers.get(0).getId()+">");
                    BanR.addField("Ban reason : ","He,her didnt respected the rules",true);
                    BanR.addField("Case n : "+i,"Date : "+e.getMessage().getTimeCreated(),true);
                    BanR.setFooter(e.getJDA().getSelfUser().getAsTag(),e.getJDA().getSelfUser().getAvatarUrl());
                    BanR.setTimestamp(e.getMessage().getTimeCreated());
                    BanR.setColor(Color.RED);
                    e.getChannel().sendMessage(BanR.build()).queue();
                    member.ban(1).queue();

                }
            } else {
                // cant
                EmbedBuilder Cant = new EmbedBuilder();
                Cant.setAuthor(e.getJDA().getSelfUser().getAsTag(),e.getJDA().getSelfUser().getAvatarUrl());
                Cant.setTitle("Ban Tab");
                Cant.setColor(Color.ORANGE);
                Cant.setDescription("\uD83D\uDD34 Cant Ban member you don't have the permission for it");
                e.getChannel().sendMessage(Cant.build()).queue();


            }
        }
    }
}
