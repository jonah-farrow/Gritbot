public class Environment {
    static float lightModifier;
    static float tempModifier;
    static float humidityModifier;
    static float light, temp, humidity;

    public Environment() {
        if (Event.getEvent() == "") {
            lightModifier = 0;
            tempModifier = 0;
            humidityModifier = 0;
        }
        light = 0;
        temp = 0;
        humidity = 0;

    }

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

        System.out.println(light + " " + temp + " " + humidity);

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

    /**
     * Method to return current events environmental properties
     * 
     * @return eventEnvironmentalProperties
     */
    public static float[] getEventEnvironmentLevels() {
        float[] eventEnvironmentProperties = { light, temp, humidity };
        return eventEnvironmentProperties;
    }
}
