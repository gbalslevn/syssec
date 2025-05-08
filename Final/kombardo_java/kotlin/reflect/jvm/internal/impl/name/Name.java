package kotlin.reflect.jvm.internal.impl.name;

/* loaded from: classes3.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str = (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) ? 2 : 3];
        if (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i5 == 1) {
            objArr[1] = "asString";
        } else if (i5 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i5 == 3 || i5 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i5) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "identifierIfValid";
                break;
            case 8:
                objArr[2] = "special";
                break;
            case 9:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i5 != 1 && i5 != 2 && i5 != 3 && i5 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private Name(String str, boolean z5) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        this.name = str;
        this.special = z5;
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            $$$reportNull$$$0(9);
        }
        return str.startsWith("<") ? special(str) : identifier(str);
    }

    public static Name identifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        return new Name(str, false);
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String str) {
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public String asString() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.special == name.special && this.name.equals(name.name);
    }

    public String getIdentifier() {
        if (this.special) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String asString = asString();
        if (asString == null) {
            $$$reportNull$$$0(2);
        }
        return asString;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        return this.name.compareTo(name.name);
    }
}
