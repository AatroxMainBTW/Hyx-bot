package BotCommand;

import BotCommand.*;
import BotCommand.Games.GuessTheNumber;
import BotCommand.Games.guessgamesSetup;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Scanner;

public class Bot {

        GatewayIntent[] gatewayIntents = new GatewayIntent[]{};
        ListenerAdapter[] listenerAdapters = new ListenerAdapter[]{new guessgamesSetup(),new GuessTheNumber(),new Ban(),new PostReactionMessage(),new Clear(),new info(),new Kick(),new Avatar(),new RoleReactions(),new WelcomeMessage(), new invite(), new PingPong()};
        String token;
        JDA jda;

        public Bot(String token){
            this.token = token;
        }

        public void Build(){
            JDABuilder jdaBuilder = JDABuilder.createDefault(token);

            jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS,gatewayIntents);


            jdaBuilder.addEventListeners(listenerAdapters);


            jdaBuilder.setActivity(Activity.playing("Dazai Programming Me !"));

            try {
                jda = jdaBuilder.build();
                jda.awaitReady();
                BotInitialized();
            } catch (Exception e){
                e.printStackTrace();
            }

        }

        public void BotInitialized(){
            Thread thread = new Thread(() -> {
                TextChannel textChannel = jda.getTextChannelById(775433999752757251L);
                while (true){
                    Scanner scanner = new Scanner(System.in);
                    String message = scanner.nextLine();
                    if (message != null && message != "" && message != "\n"){
                        textChannel.sendMessage(message).queue();
                    }
                }
            });
            thread.start();
        }




}
