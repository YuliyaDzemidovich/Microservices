package com.example.microservice2.util;

import java.util.UUID;

public final class Utils {

    public static String getOrGenerateFlowId(String input) {
        if (isValidUuid(input)) {
            return input;
        } else {
            return UUID.randomUUID().toString();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static boolean isValidUuid(String input) {
        if (input == null) {
            return false;
        }
        try {
            UUID.fromString(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}