package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.adjust.sdk.Constants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", "S", "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, Constants.LONG, "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");

    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = new HashMap();
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = new HashMap();
    private static final Set<String> WRAPPER_CLASS_INTERNAL_NAMES = new HashSet();
    private static final Map<String, String> OWNER_TO_BOXING_METHOD_DESCRIPTOR = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str;
        int i6;
        Object[] objArr;
        if (i5 != 4 && i5 != 6) {
            switch (i5) {
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i5 != 4 && i5 != 6) {
                switch (i5) {
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        i6 = 3;
                        break;
                }
                objArr = new Object[i6];
                switch (i5) {
                    case 1:
                        objArr[0] = "owner";
                        break;
                    case 2:
                        objArr[0] = "methodDescriptor";
                        break;
                    case 3:
                    case 9:
                        objArr[0] = "name";
                        break;
                    case 4:
                    case 6:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                        break;
                    case 5:
                        objArr[0] = "type";
                        break;
                    case 7:
                    case 10:
                        objArr[0] = "desc";
                        break;
                    case 8:
                        objArr[0] = "primitiveType";
                        break;
                    case 11:
                        objArr[0] = "wrapperClassName";
                        break;
                    default:
                        objArr[0] = "internalName";
                        break;
                }
                if (i5 == 4 && i5 != 6) {
                    switch (i5) {
                        case 12:
                            objArr[1] = "getPrimitiveType";
                            break;
                        case 13:
                            objArr[1] = "getJavaKeywordName";
                            break;
                        case 14:
                            objArr[1] = "getDesc";
                            break;
                        case 15:
                            objArr[1] = "getWrapperFqName";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                            break;
                    }
                } else {
                    objArr[1] = "get";
                }
                switch (i5) {
                    case 1:
                    case 2:
                        objArr[2] = "isBoxingMethodDescriptor";
                        break;
                    case 3:
                    case 5:
                        objArr[2] = "get";
                        break;
                    case 4:
                    case 6:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 7:
                        objArr[2] = "getByDesc";
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        objArr[2] = "<init>";
                        break;
                    default:
                        objArr[2] = "isWrapperClassInternalName";
                        break;
                }
                String format = String.format(str, objArr);
                if (i5 != 4 && i5 != 6) {
                    switch (i5) {
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i6 = 2;
            objArr = new Object[i6];
            switch (i5) {
            }
            if (i5 == 4) {
            }
            objArr[1] = "get";
            switch (i5) {
            }
            String format2 = String.format(str, objArr);
            if (i5 != 4) {
                switch (i5) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i5 != 4) {
            switch (i5) {
            }
            objArr = new Object[i6];
            switch (i5) {
            }
            if (i5 == 4) {
            }
            objArr[1] = "get";
            switch (i5) {
            }
            String format22 = String.format(str, objArr);
            if (i5 != 4) {
            }
            throw new IllegalStateException(format22);
        }
        i6 = 2;
        objArr = new Object[i6];
        switch (i5) {
        }
        if (i5 == 4) {
        }
        objArr[1] = "get";
        switch (i5) {
        }
        String format222 = String.format(str, objArr);
        if (i5 != 4) {
        }
        throw new IllegalStateException(format222);
    }

    static {
        for (JvmPrimitiveType jvmPrimitiveType : values()) {
            TYPE_BY_NAME.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            TYPE_BY_PRIMITIVE_TYPE.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            TYPE_BY_DESC.put(jvmPrimitiveType.getDesc(), jvmPrimitiveType);
            String replace = jvmPrimitiveType.wrapperFqName.asString().replace('.', '/');
            WRAPPER_CLASS_INTERNAL_NAMES.add(replace);
            OWNER_TO_BOXING_METHOD_DESCRIPTOR.put(replace, "(" + jvmPrimitiveType.desc + ")L" + replace + ";");
        }
    }

    JvmPrimitiveType(PrimitiveType primitiveType, String str, String str2, String str3) {
        if (primitiveType == null) {
            $$$reportNull$$$0(8);
        }
        if (str == null) {
            $$$reportNull$$$0(9);
        }
        if (str2 == null) {
            $$$reportNull$$$0(10);
        }
        if (str3 == null) {
            $$$reportNull$$$0(11);
        }
        this.primitiveType = primitiveType;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new FqName(str3);
    }

    public static JvmPrimitiveType get(String str) {
        if (str == null) {
            $$$reportNull$$$0(3);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_NAME.get(str);
        if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public String getDesc() {
        String str = this.desc;
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    public String getJavaKeywordName() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(13);
        }
        return str;
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.primitiveType;
        if (primitiveType == null) {
            $$$reportNull$$$0(12);
        }
        return primitiveType;
    }

    public FqName getWrapperFqName() {
        FqName fqName = this.wrapperFqName;
        if (fqName == null) {
            $$$reportNull$$$0(15);
        }
        return fqName;
    }

    public static JvmPrimitiveType get(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(5);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get(primitiveType);
        if (jvmPrimitiveType == null) {
            $$$reportNull$$$0(6);
        }
        return jvmPrimitiveType;
    }
}
