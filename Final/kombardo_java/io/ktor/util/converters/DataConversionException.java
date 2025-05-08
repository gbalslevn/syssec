package io.ktor.util.converters;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/util/converters/DataConversionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class DataConversionException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public DataConversionException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataConversionException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ DataConversionException(String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "Invalid data format" : str);
    }
}
