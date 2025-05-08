package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "constructor-impl", "(I)I", "equals", BuildConfig.FLAVOR, "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardType {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m2408constructorimpl(0);
    private static final int Text = m2408constructorimpl(1);
    private static final int Ascii = m2408constructorimpl(2);
    private static final int Number = m2408constructorimpl(3);
    private static final int Phone = m2408constructorimpl(4);
    private static final int Uri = m2408constructorimpl(5);
    private static final int Email = m2408constructorimpl(6);
    private static final int Password = m2408constructorimpl(7);
    private static final int NumberPassword = m2408constructorimpl(8);
    private static final int Decimal = m2408constructorimpl(9);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR&\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR&\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR&\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR&\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\bR&\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\bR&\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001d\u0010\bR&\u0010\u001f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u0012\u0004\b!\u0010\u0003\u001a\u0004\b \u0010\bR&\u0010\"\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u0012\u0004\b$\u0010\u0003\u001a\u0004\b#\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/input/KeyboardType;", "Unspecified", "I", "getUnspecified-PjHm6EE", "()I", "getUnspecified-PjHm6EE$annotations", "Text", "getText-PjHm6EE", "getText-PjHm6EE$annotations", "Ascii", "getAscii-PjHm6EE", "getAscii-PjHm6EE$annotations", "Number", "getNumber-PjHm6EE", "getNumber-PjHm6EE$annotations", "Phone", "getPhone-PjHm6EE", "getPhone-PjHm6EE$annotations", "Uri", "getUri-PjHm6EE", "getUri-PjHm6EE$annotations", "Email", "getEmail-PjHm6EE", "getEmail-PjHm6EE$annotations", "Password", "getPassword-PjHm6EE", "getPassword-PjHm6EE$annotations", "NumberPassword", "getNumberPassword-PjHm6EE", "getNumberPassword-PjHm6EE$annotations", "Decimal", "getDecimal-PjHm6EE", "getDecimal-PjHm6EE$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAscii-PjHm6EE, reason: not valid java name */
        public final int m2414getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* renamed from: getDecimal-PjHm6EE, reason: not valid java name */
        public final int m2415getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }

        /* renamed from: getEmail-PjHm6EE, reason: not valid java name */
        public final int m2416getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* renamed from: getNumber-PjHm6EE, reason: not valid java name */
        public final int m2417getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* renamed from: getNumberPassword-PjHm6EE, reason: not valid java name */
        public final int m2418getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* renamed from: getPassword-PjHm6EE, reason: not valid java name */
        public final int m2419getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* renamed from: getPhone-PjHm6EE, reason: not valid java name */
        public final int m2420getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* renamed from: getText-PjHm6EE, reason: not valid java name */
        public final int m2421getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* renamed from: getUnspecified-PjHm6EE, reason: not valid java name */
        public final int m2422getUnspecifiedPjHm6EE() {
            return KeyboardType.Unspecified;
        }

        /* renamed from: getUri-PjHm6EE, reason: not valid java name */
        public final int m2423getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        private Companion() {
        }
    }

    private /* synthetic */ KeyboardType(int i5) {
        this.value = i5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m2407boximpl(int i5) {
        return new KeyboardType(i5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2408constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2409equalsimpl(int i5, Object obj) {
        return (obj instanceof KeyboardType) && i5 == ((KeyboardType) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2410equalsimpl0(int i5, int i6) {
        return i5 == i6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2411hashCodeimpl(int i5) {
        return Integer.hashCode(i5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2412toStringimpl(int i5) {
        return m2410equalsimpl0(i5, Unspecified) ? "Unspecified" : m2410equalsimpl0(i5, Text) ? "Text" : m2410equalsimpl0(i5, Ascii) ? "Ascii" : m2410equalsimpl0(i5, Number) ? "Number" : m2410equalsimpl0(i5, Phone) ? "Phone" : m2410equalsimpl0(i5, Uri) ? "Uri" : m2410equalsimpl0(i5, Email) ? "Email" : m2410equalsimpl0(i5, Password) ? "Password" : m2410equalsimpl0(i5, NumberPassword) ? "NumberPassword" : m2410equalsimpl0(i5, Decimal) ? "Decimal" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2409equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2411hashCodeimpl(this.value);
    }

    public String toString() {
        return m2412toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
