
package com.makersharks.suppliersearch.util;

public class ValidationUtils {
    public static boolean isValidLocation(String location) {
        // Implement location validation logic
        return location != null && !location.trim().isEmpty();
    }
}

