package io.michaelrocks.libphonenumber.android;

/* loaded from: classes2.dex */
public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    /* loaded from: classes2.dex */
    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }
}
