package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class info extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
            if (e.getAuthor().isBot()){
                return;
            }
        //OnlineStatus status = OnlineStatus.fromKey(e.getMember().getOnlineStatus().getKey());
        String[] quote = new String[] {
                "Computers are useless. They can only give you answers. (Pablo Picasso)",
                "Computers are like bikinis. They save people a lot of guesswork. (Sam Ewing)",
                "They have computers, and they may have other weapons of mass destruction. (Janet Reno)",
                "The city’s central computer told you?  R2D2, you know better than to trust a strange computer!, (C3PO)",
                "The Internet?  Is that thing still around? (Homer Simpson)"
        };
        String randomQuote = quote[(int) (Math.random() * quote.length)];


        if (e.getMessage().getContentRaw().startsWith(Constant.prefix+"info")){
            List<Member> mentionedMembers = e.getMessage().getMentionedMembers();
            if (mentionedMembers.isEmpty()){
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setAuthor(e.getMember().getEffectiveName(),e.getMember().getUser().getAvatarUrl(),e.getMember().getUser().getAvatarUrl());

                embedBuilder.addField("Created in : ",e.getMember().getTimeCreated().getMonth()+
                        " "+e.getMember().getTimeCreated().getDayOfMonth()+", "
                        +e.getMember().getTimeCreated().getYear(),true);
                embedBuilder.addField("Joined in : ",e.getMember().getTimeJoined().getMonth()+
                        " "+e.getMember().getTimeJoined().getDayOfMonth()+", "
                        +e.getMember().getTimeJoined().getYear(),true);
               // embedBuilder.setThumbnail(e.getMember().getUser().getAvatarUrl());
                embedBuilder.setTitle(randomQuote);
                embedBuilder.setDescription("<@"+e.getMember().getId()+">");
                embedBuilder.setColor(new Color(100,149,237));
                if (e.getMember().getUser().getJDA().getStatus().equals(JDA.Status.CONNECTED)){
                    embedBuilder.addField("Status : ","\uD83D\uDFE2 "+e.getMember().getUser().getJDA().getStatus().toString(),false);
                }


                embedBuilder.setFooter(e.getJDA().getSelfUser().getAsTag(),e.getJDA().getSelfUser().getAvatarUrl());
                int names = e.getMember().getRoles().size();
                for (int i=0;i<names;i++){
                    embedBuilder.addField("Role "+i+" : ",e.getMember().getRoles().get(i).getAsMention(),true);
                }
                embedBuilder.setTimestamp(e.getMessage().getTimeCreated());
                e.getChannel().sendMessage(embedBuilder.build()).queue();
            } else {
                EmbedBuilder embedBuilder = new EmbedBuilder();
                //System.out.println(mentionedMembers.get(0).getOnlineStatus());
                //System.out.println(e.getMessage().getMentionedMembers().get(0).getJDA().getPresence());
                embedBuilder.addField("Created in : ",mentionedMembers.get(0).getTimeCreated().getMonth()+
                        " "+mentionedMembers.get(0).getTimeCreated().getDayOfMonth()+", "
                        +mentionedMembers.get(0).getTimeCreated().getYear(),true);
                embedBuilder.addField("Joined in : ",mentionedMembers.get(0).getTimeJoined().getMonth()+
                        " "+mentionedMembers.get(0).getTimeJoined().getDayOfMonth()+", "
                        +mentionedMembers.get(0).getTimeJoined().getYear(),true);
                embedBuilder.setDescription("<@"+mentionedMembers.get(0).getId()+">");
                embedBuilder.setAuthor(mentionedMembers.get(0).getEffectiveName(),"https://github.com/AatroxMainBTW",mentionedMembers.get(0).getUser().getAvatarUrl());
               // embedBuilder.setThumbnail(mentionedMembers.get(0).getUser().getAvatarUrl());
                embedBuilder.setTitle(randomQuote);
                embedBuilder.setFooter(e.getJDA().getSelfUser().getAsTag(),e.getJDA().getSelfUser().getAvatarUrl());
                embedBuilder.setTimestamp(e.getMessage().getTimeCreated());


                int names = mentionedMembers.get(0).getRoles().size();
                if (mentionedMembers.get(0).getJDA().getStatus().equals(JDA.Status.CONNECTED)){
                    embedBuilder.addField("Status : ","\uD83D\uDFE2 "+e.getMember().getUser().getJDA().getStatus().toString(),false);
                }
                for (int i= 0;i<names ;i++){
                    embedBuilder.addField("Role "+i+" : ",mentionedMembers.get(0).getRoles().get(i).getAsMention(),true);
                }
                embedBuilder.setColor(new Color(100,149,237));

                e.getChannel().sendMessage(embedBuilder.build()).queue();
            }
        }
    }




}
