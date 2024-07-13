package me.saif.betterenderchests.lang.inventory;

import me.saif.betterenderchests.enderchest.EnderChest;
import me.saif.betterenderchests.lang.MessageKey;
import me.saif.betterenderchests.lang.placeholder.Placeholder;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InvMultilangCommons {

    public static final Map<Integer, MessageKey> SIZE_NAME_MAP;

    static {
        Map<Integer, MessageKey> temp = new HashMap<>();
        temp.put(1, MessageKey.ENDERCHEST_1_ROWS);
        temp.put(2, MessageKey.ENDERCHEST_2_ROWS);
        temp.put(3, MessageKey.ENDERCHEST_3_ROWS);
        temp.put(4, MessageKey.ENDERCHEST_4_ROWS);
        temp.put(5, MessageKey.ENDERCHEST_5_ROWS);
        temp.put(6, MessageKey.ENDERCHEST_6_ROWS);
        SIZE_NAME_MAP = Collections.unmodifiableMap(temp);
    }

    public static final Placeholder<String> PLAYER_NAME_PLACEHOLDER = new Placeholder<String>("player") {
        @Override
        public String getValue(String s) {
            return s;
        }
    };

    public static Map.Entry<String, Integer> parseInventoryName(String name) {
        String[] strings = name.split(";");

        if (strings.length != 3)
            return null;

        if (!strings[0].equals(EnderChest.PREFIX))
            return null;

        try {
            int size = Integer.parseInt(strings[1]);
            String player = strings[2];

            return new AbstractMap.SimpleEntry<>(player, size);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
