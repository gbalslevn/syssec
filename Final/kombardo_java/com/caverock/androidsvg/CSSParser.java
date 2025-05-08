package com.caverock.androidsvg;

import android.util.Log;
import androidx.appcompat.R$styleable;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CSSParser {
    private static final String CLASS = "class";
    private static final String ID = "id";
    private static final int SPECIFICITY_ATTRIBUTE_OR_PSEUDOCLASS = 1000;
    private static final int SPECIFICITY_ELEMENT_OR_PSEUDOELEMENT = 1;
    private static final int SPECIFICITY_ID_ATTRIBUTE = 1000000;
    private static final String TAG = "CSSParser";
    private MediaType deviceMediaType;
    private boolean inMediaRule;
    private Source source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.CSSParser$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents;

        static {
            int[] iArr = new int[PseudoClassIdents.values().length];
            $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp = iArr2;
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Attrib {
        public final String name;
        final AttribOp operation;
        public final String value;

        Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CSSTextScanner extends SVGParser.TextScanner {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class AnPlusB {

            /* renamed from: a, reason: collision with root package name */
            public int f4237a;

            /* renamed from: b, reason: collision with root package name */
            public int f4238b;

            AnPlusB(int i5, int i6) {
                this.f4237a = i5;
                this.f4238b = i6;
            }
        }

        CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", BuildConfig.FLAVOR));
        }

        private int hexChar(int i5) {
            if (i5 >= 48 && i5 <= 57) {
                return i5 - 48;
            }
            if (i5 >= 65 && i5 <= 70) {
                return i5 - 55;
            }
            if (i5 < 97 || i5 > 102) {
                return -1;
            }
            return i5 - 87;
        }

        private AnPlusB nextAnPlusB() {
            IntegerParser integerParser;
            AnPlusB anPlusB;
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            int i6 = 1;
            if (consume("odd")) {
                anPlusB = new AnPlusB(2, 1);
            } else {
                if (consume("even")) {
                    anPlusB = new AnPlusB(2, 0);
                } else {
                    int i7 = (!consume('+') && consume('-')) ? -1 : 1;
                    IntegerParser parseInt = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                    if (parseInt != null) {
                        this.position = parseInt.getEndPos();
                    }
                    if (consume('n') || consume('N')) {
                        if (parseInt == null) {
                            parseInt = new IntegerParser(1L, this.position);
                        }
                        skipWhitespace();
                        boolean consume = consume('+');
                        if (!consume && (consume = consume('-'))) {
                            i6 = -1;
                        }
                        if (consume) {
                            skipWhitespace();
                            integerParser = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                            if (integerParser == null) {
                                this.position = i5;
                                return null;
                            }
                            this.position = integerParser.getEndPos();
                        } else {
                            integerParser = null;
                        }
                        int i8 = i6;
                        i6 = i7;
                        i7 = i8;
                    } else {
                        integerParser = parseInt;
                        parseInt = null;
                    }
                    anPlusB = new AnPlusB(parseInt == null ? 0 : i6 * parseInt.value(), integerParser != null ? i7 * integerParser.value() : 0);
                }
            }
            skipWhitespace();
            if (consume(')')) {
                return anPlusB;
            }
            this.position = i5;
            return null;
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String nextQuotedString = nextQuotedString();
            return nextQuotedString != null ? nextQuotedString : nextIdentifier();
        }

        private List<String> nextIdentListParam() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            ArrayList arrayList = null;
            do {
                String nextIdentifier = nextIdentifier();
                if (nextIdentifier == null) {
                    this.position = i5;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextIdentifier);
                skipWhitespace();
            } while (skipCommaWhitespace());
            if (consume(')')) {
                return arrayList;
            }
            this.position = i5;
            return null;
        }

        private List<Selector> nextPseudoNotParam() {
            List<SimpleSelector> list;
            List<PseudoClass> list2;
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            if (!consume('(')) {
                return null;
            }
            skipWhitespace();
            List<Selector> nextSelectorGroup = nextSelectorGroup();
            if (nextSelectorGroup == null) {
                this.position = i5;
                return null;
            }
            if (!consume(')')) {
                this.position = i5;
                return null;
            }
            Iterator<Selector> it = nextSelectorGroup.iterator();
            while (it.hasNext() && (list = it.next().simpleSelectors) != null) {
                Iterator<SimpleSelector> it2 = list.iterator();
                while (it2.hasNext() && (list2 = it2.next().pseudos) != null) {
                    Iterator<PseudoClass> it3 = list2.iterator();
                    while (it3.hasNext()) {
                        if (it3.next() instanceof PseudoClassNot) {
                            return null;
                        }
                    }
                }
            }
            return nextSelectorGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Selector> nextSelectorGroup() {
            AnonymousClass1 anonymousClass1 = null;
            if (empty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            Selector selector = new Selector(anonymousClass1);
            while (!empty() && nextSimpleSelector(selector)) {
                if (skipCommaWhitespace()) {
                    arrayList.add(selector);
                    selector = new Selector(anonymousClass1);
                }
            }
            if (!selector.isEmpty()) {
                arrayList.add(selector);
            }
            return arrayList;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        private void parsePseudoClass(Selector selector, SimpleSelector simpleSelector) {
            PseudoClass pseudoClassAnPlusB;
            PseudoClassAnPlusB pseudoClassAnPlusB2;
            String nextIdentifier = nextIdentifier();
            if (nextIdentifier == null) {
                throw new CSSParseException("Invalid pseudo class");
            }
            PseudoClassIdents fromString = PseudoClassIdents.fromString(nextIdentifier);
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[fromString.ordinal()]) {
                case 1:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, false, null);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 2:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, false, false, null);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 3:
                    pseudoClassAnPlusB = new PseudoClassOnlyChild(false, null);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 4:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, true, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 5:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, false, true, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 6:
                    pseudoClassAnPlusB = new PseudoClassOnlyChild(true, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 7:
                    pseudoClassAnPlusB = new PseudoClassRoot(anonymousClass1);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 8:
                    pseudoClassAnPlusB = new PseudoClassEmpty(anonymousClass1);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 9:
                case 10:
                case 11:
                case 12:
                    boolean z5 = fromString == PseudoClassIdents.nth_child || fromString == PseudoClassIdents.nth_of_type;
                    boolean z6 = fromString == PseudoClassIdents.nth_of_type || fromString == PseudoClassIdents.nth_last_of_type;
                    AnPlusB nextAnPlusB = nextAnPlusB();
                    if (nextAnPlusB == null) {
                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + nextIdentifier);
                    }
                    PseudoClassAnPlusB pseudoClassAnPlusB3 = new PseudoClassAnPlusB(nextAnPlusB.f4237a, nextAnPlusB.f4238b, z5, z6, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    pseudoClassAnPlusB2 = pseudoClassAnPlusB3;
                    pseudoClassAnPlusB = pseudoClassAnPlusB2;
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 13:
                    List<Selector> nextPseudoNotParam = nextPseudoNotParam();
                    if (nextPseudoNotParam == null) {
                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + nextIdentifier);
                    }
                    PseudoClassNot pseudoClassNot = new PseudoClassNot(nextPseudoNotParam);
                    selector.specificity = pseudoClassNot.getSpecificity();
                    pseudoClassAnPlusB2 = pseudoClassNot;
                    pseudoClassAnPlusB = pseudoClassAnPlusB2;
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 14:
                    pseudoClassAnPlusB = new PseudoClassTarget(anonymousClass1);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 15:
                    nextIdentListParam();
                    pseudoClassAnPlusB = new PseudoClassNotSupported(nextIdentifier);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    pseudoClassAnPlusB = new PseudoClassNotSupported(nextIdentifier);
                    selector.addedAttributeOrPseudo();
                    simpleSelector.addPseudo(pseudoClassAnPlusB);
                    return;
                default:
                    throw new CSSParseException("Unsupported pseudo class: " + nextIdentifier);
            }
        }

        private int scanForIdentifier() {
            int i5;
            if (empty()) {
                return this.position;
            }
            int i6 = this.position;
            int charAt = this.input.charAt(i6);
            if (charAt == 45) {
                charAt = advanceChar();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i5 = i6;
            } else {
                int advanceChar = advanceChar();
                while (true) {
                    if ((advanceChar < 65 || advanceChar > 90) && ((advanceChar < 97 || advanceChar > 122) && !((advanceChar >= 48 && advanceChar <= 57) || advanceChar == 45 || advanceChar == 95))) {
                        break;
                    }
                    advanceChar = advanceChar();
                }
                i5 = this.position;
            }
            this.position = i6;
            return i5;
        }

        String nextCSSString() {
            int hexChar;
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.position++;
            int intValue = nextChar().intValue();
            while (intValue != -1 && intValue != charAt) {
                if (intValue == 92) {
                    intValue = nextChar().intValue();
                    if (intValue != -1) {
                        if (intValue == 10 || intValue == 13 || intValue == 12) {
                            intValue = nextChar().intValue();
                        } else {
                            int hexChar2 = hexChar(intValue);
                            if (hexChar2 != -1) {
                                for (int i5 = 1; i5 <= 5 && (hexChar = hexChar((intValue = nextChar().intValue()))) != -1; i5++) {
                                    hexChar2 = (hexChar2 * 16) + hexChar;
                                }
                                sb.append((char) hexChar2);
                            }
                        }
                    }
                }
                sb.append((char) intValue);
                intValue = nextChar().intValue();
            }
            return sb.toString();
        }

        String nextIdentifier() {
            int scanForIdentifier = scanForIdentifier();
            int i5 = this.position;
            if (scanForIdentifier == i5) {
                return null;
            }
            String substring = this.input.substring(i5, scanForIdentifier);
            this.position = scanForIdentifier;
            return substring;
        }

        String nextLegacyURL() {
            char charAt;
            int hexChar;
            StringBuilder sb = new StringBuilder();
            while (!empty() && (charAt = this.input.charAt(this.position)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !isWhitespace(charAt) && !Character.isISOControl((int) charAt)) {
                this.position++;
                if (charAt == '\\') {
                    if (!empty()) {
                        String str = this.input;
                        int i5 = this.position;
                        this.position = i5 + 1;
                        charAt = str.charAt(i5);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int hexChar2 = hexChar(charAt);
                            if (hexChar2 != -1) {
                                for (int i6 = 1; i6 <= 5 && !empty() && (hexChar = hexChar(this.input.charAt(this.position))) != -1; i6++) {
                                    this.position++;
                                    hexChar2 = (hexChar2 * 16) + hexChar;
                                }
                                sb.append((char) hexChar2);
                            }
                        }
                    }
                }
                sb.append(charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            int charAt = this.input.charAt(i5);
            int i6 = i5;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !isEOL(charAt)) {
                if (!isWhitespace(charAt)) {
                    i6 = this.position + 1;
                }
                charAt = advanceChar();
            }
            if (this.position > i5) {
                return this.input.substring(i5, i6);
            }
            this.position = i5;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean nextSimpleSelector(Selector selector) {
            Combinator combinator;
            SimpleSelector simpleSelector;
            String str;
            if (empty()) {
                return false;
            }
            int i5 = this.position;
            if (!selector.isEmpty()) {
                if (consume('>')) {
                    combinator = Combinator.CHILD;
                    skipWhitespace();
                } else if (consume('+')) {
                    combinator = Combinator.FOLLOWS;
                    skipWhitespace();
                }
                if (consume('*')) {
                    String nextIdentifier = nextIdentifier();
                    if (nextIdentifier != null) {
                        SimpleSelector simpleSelector2 = new SimpleSelector(combinator, nextIdentifier);
                        selector.addedElement();
                        simpleSelector = simpleSelector2;
                    } else {
                        simpleSelector = null;
                    }
                } else {
                    simpleSelector = new SimpleSelector(combinator, null);
                }
                while (!empty()) {
                    if (!consume('.')) {
                        if (!consume('#')) {
                            if (!consume('[')) {
                                if (!consume(':')) {
                                    break;
                                }
                                if (simpleSelector == null) {
                                    simpleSelector = new SimpleSelector(combinator, null);
                                }
                                parsePseudoClass(selector, simpleSelector);
                            } else {
                                if (simpleSelector == null) {
                                    simpleSelector = new SimpleSelector(combinator, null);
                                }
                                skipWhitespace();
                                String nextIdentifier2 = nextIdentifier();
                                if (nextIdentifier2 == null) {
                                    throw new CSSParseException("Invalid attribute simpleSelectors");
                                }
                                skipWhitespace();
                                AttribOp attribOp = consume('=') ? AttribOp.EQUALS : consume("~=") ? AttribOp.INCLUDES : consume("|=") ? AttribOp.DASHMATCH : null;
                                if (attribOp != null) {
                                    skipWhitespace();
                                    str = nextAttribValue();
                                    if (str == null) {
                                        throw new CSSParseException("Invalid attribute simpleSelectors");
                                    }
                                    skipWhitespace();
                                } else {
                                    str = null;
                                }
                                if (!consume(']')) {
                                    throw new CSSParseException("Invalid attribute simpleSelectors");
                                }
                                if (attribOp == null) {
                                    attribOp = AttribOp.EXISTS;
                                }
                                simpleSelector.addAttrib(nextIdentifier2, attribOp, str);
                                selector.addedAttributeOrPseudo();
                            }
                        } else {
                            if (simpleSelector == null) {
                                simpleSelector = new SimpleSelector(combinator, null);
                            }
                            String nextIdentifier3 = nextIdentifier();
                            if (nextIdentifier3 == null) {
                                throw new CSSParseException("Invalid \"#id\" simpleSelectors");
                            }
                            simpleSelector.addAttrib("id", AttribOp.EQUALS, nextIdentifier3);
                            selector.addedIdAttribute();
                        }
                    } else {
                        if (simpleSelector == null) {
                            simpleSelector = new SimpleSelector(combinator, null);
                        }
                        String nextIdentifier4 = nextIdentifier();
                        if (nextIdentifier4 == null) {
                            throw new CSSParseException("Invalid \".class\" simpleSelectors");
                        }
                        simpleSelector.addAttrib(CSSParser.CLASS, AttribOp.EQUALS, nextIdentifier4);
                        selector.addedAttributeOrPseudo();
                    }
                }
                if (simpleSelector == null) {
                    selector.add(simpleSelector);
                    return true;
                }
                this.position = i5;
                return false;
            }
            combinator = null;
            if (consume('*')) {
            }
            while (!empty()) {
            }
            if (simpleSelector == null) {
            }
        }

        String nextURL() {
            if (empty()) {
                return null;
            }
            int i5 = this.position;
            if (!consume("url(")) {
                return null;
            }
            skipWhitespace();
            String nextCSSString = nextCSSString();
            if (nextCSSString == null) {
                nextCSSString = nextLegacyURL();
            }
            if (nextCSSString == null) {
                this.position = i5;
                return null;
            }
            skipWhitespace();
            if (empty() || consume(")")) {
                return nextCSSString;
            }
            this.position = i5;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface PseudoClass {
        boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassAnPlusB implements PseudoClass {

        /* renamed from: a, reason: collision with root package name */
        private int f4239a;

        /* renamed from: b, reason: collision with root package name */
        private int f4240b;
        private boolean isFromStart;
        private boolean isOfType;
        private String nodeName;

        PseudoClassAnPlusB(int i5, int i6, boolean z5, boolean z6, String str) {
            this.f4239a = i5;
            this.f4240b = i6;
            this.isFromStart = z5;
            this.isOfType = z6;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i5;
            int i6;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            SVG.SvgContainer svgContainer = svgElementBase.parent;
            if (svgContainer != null) {
                Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
                i5 = 0;
                i6 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (svgElementBase2 == svgElementBase) {
                        i5 = i6;
                    }
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i6++;
                    }
                }
            } else {
                i5 = 0;
                i6 = 1;
            }
            int i7 = this.isFromStart ? i5 + 1 : i6 - i5;
            int i8 = this.f4239a;
            if (i8 == 0) {
                return i7 == this.f4240b;
            }
            int i9 = this.f4240b;
            if ((i7 - i9) % i8 == 0) {
                return Integer.signum(i7 - i9) == 0 || Integer.signum(i7 - this.f4240b) == Integer.signum(this.f4239a);
            }
            return false;
        }

        public String toString() {
            String str = this.isFromStart ? BuildConfig.FLAVOR : "last-";
            return this.isOfType ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f4239a), Integer.valueOf(this.f4240b), this.nodeName) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f4239a), Integer.valueOf(this.f4240b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassEmpty implements PseudoClass {
        private PseudoClassEmpty() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return !(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0;
        }

        public String toString() {
            return "empty";
        }

        /* synthetic */ PseudoClassEmpty(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            return pseudoClassIdents != null ? pseudoClassIdents : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassNot implements PseudoClass {
        private List<Selector> selectorGroup;

        PseudoClassNot(List<Selector> list) {
            this.selectorGroup = list;
        }

        int getSpecificity() {
            Iterator<Selector> it = this.selectorGroup.iterator();
            int i5 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                int i6 = it.next().specificity;
                if (i6 > i5) {
                    i5 = i6;
                }
            }
            return i5;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            Iterator<Selector> it = this.selectorGroup.iterator();
            while (it.hasNext()) {
                if (CSSParser.ruleMatch(ruleMatchContext, it.next(), svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return "not(" + this.selectorGroup + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassNotSupported implements PseudoClass {
        private String clazz;

        PseudoClassNotSupported(String str) {
            this.clazz = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return false;
        }

        public String toString() {
            return this.clazz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassOnlyChild implements PseudoClass {
        private boolean isOfType;
        private String nodeName;

        public PseudoClassOnlyChild(boolean z5, String str) {
            this.isOfType = z5;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i5;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            SVG.SvgContainer svgContainer = svgElementBase.parent;
            if (svgContainer != null) {
                Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
                i5 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i5++;
                    }
                }
            } else {
                i5 = 1;
            }
            return i5 == 1;
        }

        public String toString() {
            return this.isOfType ? String.format("only-of-type <%s>", this.nodeName) : String.format("only-child", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassRoot implements PseudoClass {
        private PseudoClassRoot() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return svgElementBase.parent == null;
        }

        public String toString() {
            return "root";
        }

        /* synthetic */ PseudoClassRoot(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassTarget implements PseudoClass {
        private PseudoClassTarget() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return ruleMatchContext != null && svgElementBase == ruleMatchContext.targetElement;
        }

        public String toString() {
            return "target";
        }

        /* synthetic */ PseudoClassTarget(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Rule {
        Selector selector;
        Source source;
        SVG.Style style;

        Rule(Selector selector, SVG.Style style, Source source) {
            this.selector = selector;
            this.style = style;
            this.source = source;
        }

        public String toString() {
            return String.valueOf(this.selector) + " {...} (src=" + this.source + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RuleMatchContext {
        SVG.SvgElementBase targetElement;

        public String toString() {
            SVG.SvgElementBase svgElementBase = this.targetElement;
            return svgElementBase != null ? String.format("<%s id=\"%s\">", svgElementBase.getNodeName(), this.targetElement.id) : BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Ruleset {
        private List<Rule> rules = null;

        void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i5 = 0; i5 < this.rules.size(); i5++) {
                if (this.rules.get(i5).selector.specificity > rule.selector.specificity) {
                    this.rules.add(i5, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addAll(Ruleset ruleset) {
            if (ruleset.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new ArrayList(ruleset.rules.size());
            }
            Iterator<Rule> it = ruleset.rules.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Rule> getRules() {
            return this.rules;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            List<Rule> list = this.rules;
            return list == null || list.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeFromSource(Source source) {
            List<Rule> list = this.rules;
            if (list == null) {
                return;
            }
            Iterator<Rule> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().source == source) {
                    it.remove();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ruleCount() {
            List<Rule> list = this.rules;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.rules == null) {
                return BuildConfig.FLAVOR;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SimpleSelector {
        Combinator combinator;
        String tag;
        List<Attrib> attribs = null;
        List<PseudoClass> pseudos = null;

        SimpleSelector(Combinator combinator, String str) {
            this.combinator = null;
            this.tag = null;
            this.combinator = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        void addPseudo(PseudoClass pseudoClass) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.combinator;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb.append('[');
                    sb.append(attrib.name);
                    int i5 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[attrib.operation.ordinal()];
                    if (i5 == 1) {
                        sb.append('=');
                        sb.append(attrib.value);
                    } else if (i5 == 2) {
                        sb.append("~=");
                        sb.append(attrib.value);
                    } else if (i5 == 3) {
                        sb.append("|=");
                        sb.append(attrib.value);
                    }
                    sb.append(']');
                }
            }
            List<PseudoClass> list2 = this.pseudos;
            if (list2 != null) {
                for (PseudoClass pseudoClass : list2) {
                    sb.append(':');
                    sb.append(pseudoClass);
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Source {
        Document,
        RenderOptions
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    private static int getChildPosition(List<SVG.SvgContainer> list, int i5, SVG.SvgElementBase svgElementBase) {
        int i6 = 0;
        if (i5 < 0) {
            return 0;
        }
        SVG.SvgContainer svgContainer = list.get(i5);
        SVG.SvgContainer svgContainer2 = svgElementBase.parent;
        if (svgContainer != svgContainer2) {
            return -1;
        }
        Iterator<SVG.SvgObject> it = svgContainer2.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next() == svgElementBase) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean mediaMatches(String str, MediaType mediaType) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return mediaMatches(parseMediaList(cSSTextScanner), mediaType);
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) {
        String nextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (nextIdentifier == null) {
            throw new CSSParseException("Invalid '@' rule");
        }
        if (!this.inMediaRule && nextIdentifier.equals("media")) {
            List<MediaType> parseMediaList = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.consume('{')) {
                throw new CSSParseException("Invalid @media rule: missing rule set");
            }
            cSSTextScanner.skipWhitespace();
            if (mediaMatches(parseMediaList, this.deviceMediaType)) {
                this.inMediaRule = true;
                ruleset.addAll(parseRuleset(cSSTextScanner));
                this.inMediaRule = false;
            } else {
                parseRuleset(cSSTextScanner);
            }
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume('}')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (this.inMediaRule || !nextIdentifier.equals("import")) {
            warn("Ignoring @%s rule", nextIdentifier);
            skipAtRule(cSSTextScanner);
        } else {
            String nextURL = cSSTextScanner.nextURL();
            if (nextURL == null) {
                nextURL = cSSTextScanner.nextCSSString();
            }
            if (nextURL == null) {
                throw new CSSParseException("Invalid @import rule: expected string or url()");
            }
            cSSTextScanner.skipWhitespace();
            parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume(';')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
            SVG.getFileResolver();
        }
        cSSTextScanner.skipWhitespace();
    }

    public static List<String> parseClassAttribute(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String nextToken = cSSTextScanner.nextToken();
            if (nextToken != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextToken);
                cSSTextScanner.skipWhitespace();
            }
        }
        return arrayList;
    }

    private SVG.Style parseDeclarations(CSSTextScanner cSSTextScanner) {
        SVG.Style style = new SVG.Style();
        do {
            String nextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(':')) {
                throw new CSSParseException("Expected ':'");
            }
            cSSTextScanner.skipWhitespace();
            String nextPropertyValue = cSSTextScanner.nextPropertyValue();
            if (nextPropertyValue == null) {
                throw new CSSParseException("Expected property value");
            }
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('!')) {
                cSSTextScanner.skipWhitespace();
                if (!cSSTextScanner.consume("important")) {
                    throw new CSSParseException("Malformed rule set: found unexpected '!'");
                }
                cSSTextScanner.skipWhitespace();
            }
            cSSTextScanner.consume(';');
            SVGParser.processStyleProperty(style, nextIdentifier, nextPropertyValue);
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.empty()) {
                break;
            }
        } while (!cSSTextScanner.consume('}'));
        return style;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) {
        String nextWord;
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty() && (nextWord = cSSTextScanner.nextWord()) != null) {
            try {
                arrayList.add(MediaType.valueOf(nextWord));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.skipCommaWhitespace()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) {
        List nextSelectorGroup = cSSTextScanner.nextSelectorGroup();
        if (nextSelectorGroup == null || nextSelectorGroup.isEmpty()) {
            return false;
        }
        if (!cSSTextScanner.consume('{')) {
            throw new CSSParseException("Malformed rule block: expected '{'");
        }
        cSSTextScanner.skipWhitespace();
        SVG.Style parseDeclarations = parseDeclarations(cSSTextScanner);
        cSSTextScanner.skipWhitespace();
        Iterator it = nextSelectorGroup.iterator();
        while (it.hasNext()) {
            ruleset.add(new Rule((Selector) it.next(), parseDeclarations, this.source));
        }
        return true;
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            try {
                if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                    if (!cSSTextScanner.consume('@')) {
                        if (!parseRule(ruleset, cSSTextScanner)) {
                            break;
                        }
                    } else {
                        parseAtRule(ruleset, cSSTextScanner);
                    }
                }
            } catch (CSSParseException e5) {
                Log.e(TAG, "CSS parser terminated early due to error: " + e5.getMessage());
            }
        }
        return ruleset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = svgElementBase.parent; obj != null; obj = ((SVG.SvgObject) obj).parent) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(ruleMatchContext, selector.get(0), arrayList, size, svgElementBase);
        }
        return ruleMatch(ruleMatchContext, selector, selector.size() - 1, arrayList, size, svgElementBase);
    }

    private static boolean ruleMatchOnAncestors(RuleMatchContext ruleMatchContext, Selector selector, int i5, List<SVG.SvgContainer> list, int i6) {
        SimpleSelector simpleSelector = selector.get(i5);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i6);
        if (!selectorMatch(ruleMatchContext, simpleSelector, list, i6, svgElementBase)) {
            return false;
        }
        Combinator combinator = simpleSelector.combinator;
        if (combinator == Combinator.DESCENDANT) {
            if (i5 == 0) {
                return true;
            }
            while (i6 > 0) {
                i6--;
                if (ruleMatchOnAncestors(ruleMatchContext, selector, i5 - 1, list, i6)) {
                    return true;
                }
            }
            return false;
        }
        if (combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(ruleMatchContext, selector, i5 - 1, list, i6 - 1);
        }
        int childPosition = getChildPosition(list, i6, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(ruleMatchContext, selector, i5 - 1, list, i6, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }

    private static boolean selectorMatch(RuleMatchContext ruleMatchContext, SimpleSelector simpleSelector, List<SVG.SvgContainer> list, int i5, SVG.SvgElementBase svgElementBase) {
        List<String> list2;
        String str = simpleSelector.tag;
        if (str != null && !str.equals(svgElementBase.getNodeName().toLowerCase(Locale.US))) {
            return false;
        }
        List<Attrib> list3 = simpleSelector.attribs;
        if (list3 != null) {
            for (Attrib attrib : list3) {
                String str2 = attrib.name;
                str2.hashCode();
                if (str2.equals("id")) {
                    if (!attrib.value.equals(svgElementBase.id)) {
                        return false;
                    }
                } else if (!str2.equals(CLASS) || (list2 = svgElementBase.classNames) == null || !list2.contains(attrib.value)) {
                    return false;
                }
            }
        }
        List<PseudoClass> list4 = simpleSelector.pseudos;
        if (list4 == null) {
            return true;
        }
        Iterator<PseudoClass> it = list4.iterator();
        while (it.hasNext()) {
            if (!it.next().matches(ruleMatchContext, svgElementBase)) {
                return false;
            }
        }
        return true;
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i5 = 0;
        while (!cSSTextScanner.empty()) {
            int intValue = cSSTextScanner.nextChar().intValue();
            if (intValue == 59 && i5 == 0) {
                return;
            }
            if (intValue == 123) {
                i5++;
            } else if (intValue == 125 && i5 > 0 && i5 - 1 == 0) {
                return;
            }
        }
    }

    private static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ruleset parse(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(MediaType mediaType, Source source) {
        this.inMediaRule = false;
        this.deviceMediaType = mediaType;
        this.source = source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Selector {
        List<SimpleSelector> simpleSelectors;
        int specificity;

        private Selector() {
            this.simpleSelectors = null;
            this.specificity = 0;
        }

        void add(SimpleSelector simpleSelector) {
            if (this.simpleSelectors == null) {
                this.simpleSelectors = new ArrayList();
            }
            this.simpleSelectors.add(simpleSelector);
        }

        void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        void addedElement() {
            this.specificity++;
        }

        void addedIdAttribute() {
            this.specificity += CSSParser.SPECIFICITY_ID_ATTRIBUTE;
        }

        SimpleSelector get(int i5) {
            return this.simpleSelectors.get(i5);
        }

        boolean isEmpty() {
            List<SimpleSelector> list = this.simpleSelectors;
            return list == null || list.isEmpty();
        }

        int size() {
            List<SimpleSelector> list = this.simpleSelectors;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<SimpleSelector> it = this.simpleSelectors.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(' ');
            }
            sb.append('[');
            sb.append(this.specificity);
            sb.append(']');
            return sb.toString();
        }

        /* synthetic */ Selector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, int i5, List<SVG.SvgContainer> list, int i6, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = selector.get(i5);
        if (!selectorMatch(ruleMatchContext, simpleSelector, list, i6, svgElementBase)) {
            return false;
        }
        Combinator combinator = simpleSelector.combinator;
        if (combinator == Combinator.DESCENDANT) {
            if (i5 == 0) {
                return true;
            }
            while (i6 >= 0) {
                if (ruleMatchOnAncestors(ruleMatchContext, selector, i5 - 1, list, i6)) {
                    return true;
                }
                i6--;
            }
            return false;
        }
        if (combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(ruleMatchContext, selector, i5 - 1, list, i6);
        }
        int childPosition = getChildPosition(list, i6, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(ruleMatchContext, selector, i5 - 1, list, i6, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }
}
