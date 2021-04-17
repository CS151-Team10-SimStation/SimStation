package simstation;

import mvc.Utilities;

// Revision History:
// 4/16/21: Paul updated Heading class.
//          Added enum constants and methods.
public enum Heading {
    NORTH, EAST, SOUTH, WEST;

    // Convert String to Heading.
    public static Heading parse(String heading) {
        if (heading.equalsIgnoreCase("north")) return NORTH;
        if (heading.equalsIgnoreCase("south")) return SOUTH;
        if (heading.equalsIgnoreCase("east")) return EAST;
        if (heading.equalsIgnoreCase("west")) return WEST;
        Utilities.error("Invalid heading: " + heading);
        return null;
    }

    // Generate random heading.
    public static Heading random() {
        int luck = Utilities.rng.nextInt(4);
        if (luck == 0) return NORTH;
        if (luck == 1) return SOUTH;
        if (luck == 2) return EAST;
        return WEST;
    }
}
