package moe.quill.stratumsurvival.Adventuring.NPCManager.NPCs;

public enum NPCType {
    CRYPTOLOGIST("npc_cryptologist"),
    BLACKSMITH("npc_blacksmith")
    ;

    public String key;

    NPCType(String key) {
        this.key = key;
    }

    public NPCType fromKeyString(String string) {
        for (final var type : NPCType.values()) {
            if (type.key.equalsIgnoreCase(string)) {
                return type;
            }
        }
        return null;
    }
}
