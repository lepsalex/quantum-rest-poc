package com.alexlepsa.contoller.common;

import lombok.val;

import java.util.Locale;

public class AuthUtils {
    public static final String AUTH_HEADER = "X-Fake-Auth";
    public static final String ALLOWED_ROOM = "alex-demo";

    public static Boolean isAccountIdAuthed(final String authToken) {
        val normalizedToken = authToken.toLowerCase(Locale.ROOT);

        return normalizedToken.contains("alex") || normalizedToken.equals("server");
    }

    public static Boolean isAccountIdAuthedForRoom(final String authToken, final String roomId) {
        return isAccountIdAuthed(authToken) && roomId.equalsIgnoreCase(ALLOWED_ROOM);
    }
}
