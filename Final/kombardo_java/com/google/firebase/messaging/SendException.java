package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class SendException extends Exception {
    private final int errorCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SendException(String str) {
        super(str);
        this.errorCode = parseErrorCode(str);
    }

    private int parseErrorCode(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        char c5 = 65535;
        switch (lowerCase.hashCode()) {
            case -1743242157:
                if (lowerCase.equals("service_not_available")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1290953729:
                if (lowerCase.equals("toomanymessages")) {
                    c5 = 1;
                    break;
                }
                break;
            case -920906446:
                if (lowerCase.equals("invalid_parameters")) {
                    c5 = 2;
                    break;
                }
                break;
            case -617027085:
                if (lowerCase.equals("messagetoobig")) {
                    c5 = 3;
                    break;
                }
                break;
            case -95047692:
                if (lowerCase.equals("missing_to")) {
                    c5 = 4;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return 3;
            case 1:
                return 4;
            case 2:
            case 4:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }
}
