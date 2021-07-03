package moe.quill.stratumsurvival.Crafting.Items.TrinketEffects;

import moe.quill.StratumCommonApi.KeyManager.IKeyManager;
import moe.quill.StratumCommonApi.Serialization.ISerializer;
import moe.quill.stratumsurvival.Crafting.Items.MaterialManager.StratumMaterials.MaterialManager;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.HashSet;

public abstract class TrinketEffect implements ExecutableEffect {

    protected final Plugin plugin;
    protected final MaterialManager materialManager;
    protected final IKeyManager keyManager;
    protected final ISerializer serializer;

    //Things that will be implemented now shall be done at the lowest level
    private final HashSet<Class<Event>> eventTriggers;
    private final TrinketEffectKey trinketEffectKey;

    public TrinketEffect(Plugin plugin,
                         MaterialManager materialManager,
                         IKeyManager keyManager,
                         ISerializer serializer,
                         HashSet<Class<Event>> eventTriggers,
                         TrinketEffectKey trinketEffectKey
    ) {
        this.plugin = plugin;
        this.materialManager = materialManager;
        this.keyManager = keyManager;
        this.serializer = serializer;
        this.eventTriggers = eventTriggers;
        this.trinketEffectKey = trinketEffectKey;
    }

    /**
     * Get all of the event types that we will be handing
     *
     * @return the list of event types that we'll need to trigger for this
     */
    public Collection<Class<Event>> getEventTriggers() {
        return eventTriggers;
    }

    /**
     * Get the trinket effect ket for this trinket
     *
     * @return the effect key for this trinket
     */
    public TrinketEffectKey getTrinketEffectKey() {
        return trinketEffectKey;
    }
}
