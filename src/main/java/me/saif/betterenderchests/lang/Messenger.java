package me.saif.betterenderchests.lang;

import me.saif.betterenderchests.lang.locale.Locale;
import me.saif.betterenderchests.lang.locale.LocaleManager;
import me.saif.betterenderchests.lang.locale.PlayerLocaleLoader;
import me.saif.betterenderchests.lang.placeholder.PlaceholderResult;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messenger {

    private LocaleManager lm;
    private PlayerLocaleLoader pll;
    private final String systemLocale = java.util.Locale.getDefault().toLanguageTag().replace('-', '_');

    public Messenger(LocaleManager lm, PlayerLocaleLoader pll) {
        this.lm = lm;
        this.pll = pll;
    }

    public String[] getMessage(CommandSender sender, MessageKey messageKey, PlaceholderResult... placeholders) {
        String localeString = !(sender instanceof Player) ? systemLocale : pll.getLocale(((Player) sender));
        Locale locale = lm.getLocale(localeString);

        return locale.getFormattedMessage(messageKey, placeholders);
    }

    public void sendMessage(CommandSender sender, MessageKey messageKey, PlaceholderResult... placeholders) {
        for (String s : getMessage(sender, messageKey, placeholders)) {
            sender.sendMessage(s);
        }
    }


}