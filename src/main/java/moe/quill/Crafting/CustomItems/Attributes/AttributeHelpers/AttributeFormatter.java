package moe.quill.Crafting.CustomItems.Attributes.AttributeHelpers;

public class AttributeFormatter {

    /**
     * Format the items value as a % increase
     *
     * @param value to format
     * @return the formatted value
     */
    public String formatPercent(float value) {
        return ": " + Math.round(value * 100) + "%";
    }

    /**
     * Format the item as a float with 1 decimal
     * @param value to format
     * @return the formatted value
     */
    public String formatFloat(float value) {
        return ": +" + Math.round(value * 10) / 10.f;
    }
}
