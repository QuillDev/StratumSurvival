package tech.quilldev.Serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import org.bukkit.inventory.ItemStack;

public class StratumSerialization {
    private static final Kryo kryo = new Kryo();

    public static void init() {
        kryo.setRegistrationRequired(false);
        kryo.addDefaultSerializer(Float.class, DefaultSerializers.FloatSerializer.class);
        kryo.addDefaultSerializer(String.class, DefaultSerializers.StringSerializer.class);
        kryo.addDefaultSerializer(Boolean.class, DefaultSerializers.BooleanSerializer.class);
    }

    /**
     * Serialize the boolean into bytes
     *
     * @param value to serialize into bytes
     * @return the boolean constructed from the bytes
     */
    public static byte[] serializeBoolean(Boolean value) {
        final var output = new Output(1);
        kryo.writeObject(output, value);
        return output.getBuffer();
    }

    /**
     * Deserialize the item from bytes into a boolean
     *
     * @param bytes to make a boolean from
     * @return a boolean from the bytes
     */
    public static Boolean deserializeBoolean(byte[] bytes) {
        final var input = new Input(bytes);
        return kryo.readObject(input, Boolean.class);
    }

    /**
     * Serialize the item stack into bytes
     *
     * @param itemStack to turn serialize into bytes
     * @return the bytes from the item stack
     */
    public static byte[] serializeItemStack(ItemStack itemStack) {
        return itemStack.serializeAsBytes();
    }

    /**
     * Deserialize bytes into an item stack
     *
     * @param bytes to deserialize the item from
     * @return the item stack from the bytes
     */
    public static ItemStack deserializeItemStack(byte[] bytes) {
        return ItemStack.deserializeBytes(bytes);
    }

    /**
     * Serialize the string into raw bytes
     *
     * @param value to convert to bytes
     * @return the string from the raw bytes
     */
    public static byte[] serializeString(String value) {
        final var output = new Output(2048);
        kryo.writeObject(output, value);
        return output.getBuffer();
    }

    /**
     * Deserialize the string from the byte values
     *
     * @param bytes to convert to string from bytes
     * @return the string from the raw bytes
     */
    public static String deserializeString(byte[] bytes) {
        final var input = new Input(bytes);
        return kryo.readObject(input, String.class);
    }

    /**
     * Serialize and deserialize floats
     *
     * @param value of the float to encode
     * @return the bytes for that float
     */
    public static byte[] serializeFloat(float value) {
        final var output = new Output(4);
        kryo.writeObject(output, value);
        return output.getBuffer();
    }

    /**
     * Deserialize the float from the byte values
     *
     * @param bytes to convert to float objects
     * @return the float from the given raw bytes
     */
    public static float deserializeFloat(byte[] bytes) {
        final var input = new Input(bytes);
        return kryo.readObject(input, Float.class);
    }
}