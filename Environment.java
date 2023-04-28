public class Environment {
    static float lightModifier;
    static float tempModifier;
    static float humidityModifier;
    static float light, temp, humidity;

    /**
     * Method to adjust environment based on current event modifiers
     * 
     * @param lightLevel
     * @param tempLevel
     * @param humidityLevel
     */
    public static void setEventEnvironmentLevels(float lightLevel, float tempLevel, float humidityLevel) {
        lightModifier = lightLevel;
        tempModifier = tempLevel;
        humidityModifier = humidityLevel;
        // System.out.println(lightModifier + " " + tempModifier + " " +
        // humidityModifier);
    }

    /**
     * Method to set the environmental data ingame
     * 
     * @return nothing
     */
    public static void setEnvironmentLevels(float lightLevel, float tempLevel, float humidityLevel) {

        light = lightLevel + lightModifier;
        temp = tempLevel + tempModifier;
        humidity = humidityLevel + humidityModifier;

        System.out.println();
        System.out.println("Light = " + light + " with life mod: " + lightModifier);
        System.out.println("Temperature = " + temp + " with temp mod: " + tempModifier);
        System.out.println("Humidity = " + humidity + " with life mod: " + humidityModifier);
        // System.out.println(light + " " + temp + " " + humidity);

    }

    /**
     * Method to return enviromental properties
     * 
     * @return environmentProperties
     */
    public static float[] getEnvironmentLevels() {
        float[] environmentProperties = { light, temp, humidity };
        return environmentProperties;
    }
}
