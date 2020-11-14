package BotCommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;


import java.awt.*;
import java.util.List;

public class Avatar extends ListenerAdapter {
        @Override
        public void onMessageReceived(MessageReceivedEvent e){
            if (e.getAuthor().isBot()){
                return;
            }
            if (e.getMessage().getContentRaw().startsWith(Constant.prefix+"pfp")){
                List<Member> mentionedMembers = e.getMessage().getMentionedMembers();

                if (mentionedMembers.isEmpty()){
                    e.getChannel().sendMessage(createEmbed(e.getAuthor())).queue();

                    System.out.println(e.getAuthor().getJDA().getRoles());
                } else {
                        System.out.println(mentionedMembers.get(0).getRoles().get(0).getName());


                    e.getChannel().sendMessage(createEmbed(mentionedMembers.get(0).getUser())).queue();
                }
            }

        }

        public MessageEmbed createEmbed(User user){
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setImage(user.getAvatarUrl());
            embedBuilder.setColor(Color.CYAN);
            return embedBuilder.build();
        }
}
