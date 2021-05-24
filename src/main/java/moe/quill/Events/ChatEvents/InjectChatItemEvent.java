package moe.quill.Events.ChatEvents;

import io.papermc.paper.event.player.AsyncChatEvent;
import moe.quill.PlayerHelpers.PlayerInventoryHelper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InjectChatItemEvent implements Listener {

    private final static PlayerInventoryHelper inventoryHelper = new PlayerInventoryHelper();

    //Patterns for parsing text chat data
    private final static Pattern numberPattern = Pattern.compile("[1-9]");
    private final static Pattern itemNodePattern = Pattern.compile("(\\{item[1-9]})");

    @EventHandler(priority = EventPriority.HIGHEST)
    public void injectOnChatEvent(AsyncChatEvent event) {

        // Get the message content and an empty component for adding additional data
        var content = getTextContent(event.message());
        var chunks = Component.empty();

        //Get all item matches
        final var matches = itemNodePattern
                .matcher(content)
                .results()
                .collect(Collectors.toList());

        //Parse the message and split the components into special ones, and raw ones
        MatchResult lastChunk = null;
        for (final MatchResult match : matches) {

            //Get the item display content for the item @ the given slot
            final var itemDisplay = getItemDisplay(match.group(), event.getPlayer());

            //If the last chunk is null (the first loop)
            if (lastChunk == null) {
                chunks = chunks.append(Component.text(content.substring(0, match.start())));
                lastChunk = match;
                chunks = chunks.append(itemDisplay);
                continue;
            }

            // Append the item display chunk & other data chunks
            chunks = chunks.append(Component.text(content.substring(lastChunk.end(), match.start())))
                    .append(itemDisplay);
            lastChunk = match;
        }

        //If the last chunk value was never changed, just return out
        if (lastChunk == null) return;

        //if there is remaining text go ahead and append it at the end
        if (lastChunk.end() != content.length()) {
            chunks = chunks.append(Component.text(content.substring(lastChunk.end())));
        }

        //Compose the message using data from the player
        var message = event.composer().composeChat(event.getPlayer(), event.getPlayer().displayName(), Component.empty());
        message = message.append(chunks);

        //Send the message to the server and set the event to cancelled
        event.getPlayer().getServer().sendMessage(message);
        event.setCancelled(true);
    }

    /**
     * Get the text content from the given component
     *
     * @param component to get text from
     * @return the raw text from that component
     */
    private String getTextContent(Component component) {
        return ((TextComponent) component).content();
    }

    /**
     * Get the item display for the given string (parse it up)
     *
     * @param query  the query to check an item for
     * @param player to check the item of
     * @return the component containing data for that item
     */
    private Component getItemDisplay(String query, Player player) {
        //Create a matcher for the given query
        final var matcher = numberPattern.matcher(query);

        //Try to find the first match
        if (!matcher.find()) return Component.empty();

        //Parse that match as an integer
        final var number = Integer.parseInt(matcher.group());

        //If it is not a number, just return out
        if (Float.isNaN(number)) {
            return Component.empty();
        }

        return inventoryHelper.getItemDisplayAtSlot(player, number);
    }
}
