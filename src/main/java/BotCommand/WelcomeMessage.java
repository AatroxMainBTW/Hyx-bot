package BotCommand;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WelcomeMessage extends ListenerAdapter {
    final long RoleMember = 775548973435715625L;
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        Member member = e.getMember();
        member.getUser().openPrivateChannel().queue(channel -> {
            channel.sendMessage("Welcome to my discord, I hope u will enjoy ur self here ").queue();
        });

        e.getGuild().addRoleToMember(member,e.getJDA().getRoleById(RoleMember)).queue();
    }
}
