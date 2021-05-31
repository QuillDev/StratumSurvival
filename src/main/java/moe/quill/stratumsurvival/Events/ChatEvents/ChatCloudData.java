package moe.quill.stratumsurvival.Events.ChatEvents;

import net.kyori.adventure.text.Component;

public class ChatCloudData {

    public Component component;
    public long startTicks;

    public ChatCloudData(Component component, long startTicks) {
        this.component = component;
        this.startTicks = startTicks;
    }
}
