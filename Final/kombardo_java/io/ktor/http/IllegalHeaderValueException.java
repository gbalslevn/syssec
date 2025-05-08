package io.ktor.http;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/IllegalHeaderValueException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", BuildConfig.FLAVOR, "headerValue", "Ljava/lang/String;", "getHeaderValue", "()Ljava/lang/String;", BuildConfig.FLAVOR, "position", "I", "getPosition", "()I", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IllegalHeaderValueException extends IllegalArgumentException {
    private final String headerValue;
    private final int position;
}
