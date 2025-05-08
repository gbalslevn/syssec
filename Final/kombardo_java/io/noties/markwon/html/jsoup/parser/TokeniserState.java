package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum TokeniserState {
    Data { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.1
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                tokeniser.emit(characterReader.consume());
            } else {
                if (current == '&') {
                    tokeniser.advanceTransition(TokeniserState.CharacterReferenceInData);
                    return;
                }
                if (current == '<') {
                    tokeniser.advanceTransition(TokeniserState.TagOpen);
                } else if (current != 65535) {
                    tokeniser.emit(characterReader.consumeData());
                } else {
                    tokeniser.emit(new Token.EOF());
                }
            }
        }
    },
    CharacterReferenceInData { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.2
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, TokeniserState.Data);
        }
    },
    Rcdata { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.3
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else {
                if (current == '&') {
                    tokeniser.advanceTransition(TokeniserState.CharacterReferenceInRcdata);
                    return;
                }
                if (current == '<') {
                    tokeniser.advanceTransition(TokeniserState.RcdataLessthanSign);
                } else if (current != 65535) {
                    tokeniser.emit(characterReader.consumeToAny('&', '<', 0));
                } else {
                    tokeniser.emit(new Token.EOF());
                }
            }
        }
    },
    CharacterReferenceInRcdata { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.4
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, TokeniserState.Rcdata);
        }
    },
    Rawtext { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.5
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readData(tokeniser, characterReader, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.6
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readData(tokeniser, characterReader, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.7
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeTo((char) 0));
            } else {
                tokeniser.emit(new Token.EOF());
            }
        }
    },
    TagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.8
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == '!') {
                tokeniser.advanceTransition(TokeniserState.MarkupDeclarationOpen);
                return;
            }
            if (current == '/') {
                tokeniser.advanceTransition(TokeniserState.EndTagOpen);
                return;
            }
            if (current == '?') {
                tokeniser.advanceTransition(TokeniserState.BogusComment);
                return;
            }
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(true);
                tokeniser.transition(TokeniserState.TagName);
            } else {
                tokeniser.error(this);
                tokeniser.emit('<');
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    EndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.9
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.Data);
            } else if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(TokeniserState.TagName);
            } else if (characterReader.matches('>')) {
                tokeniser.error(this);
                tokeniser.advanceTransition(TokeniserState.Data);
            } else {
                tokeniser.error(this);
                tokeniser.advanceTransition(TokeniserState.BogusComment);
            }
        }
    },
    TagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.10
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendTagName(characterReader.consumeTagName());
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                return;
            }
            if (consume != ' ') {
                if (consume == '/') {
                    tokeniser.transition(TokeniserState.SelfClosingStartTag);
                    return;
                }
                if (consume == '>') {
                    tokeniser.emitTagPending();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                } else if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.transition(TokeniserState.Data);
                    return;
                } else if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                    tokeniser.tagPending.appendTagName(consume);
                    return;
                }
            }
            tokeniser.transition(TokeniserState.BeforeAttributeName);
        }
    },
    RcdataLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.11
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (characterReader.matchesLetter() && tokeniser.appropriateEndTagName() != null) {
                if (!characterReader.containsIgnoreCase("</" + tokeniser.appropriateEndTagName())) {
                    tokeniser.tagPending = tokeniser.createTagPending(false).name(tokeniser.appropriateEndTagName());
                    tokeniser.emitTagPending();
                    characterReader.unconsume();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
            }
            tokeniser.emit("<");
            tokeniser.transition(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.12
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.Rcdata);
            } else {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(TokeniserState.RCDATAEndTagName);
            }
        }
    },
    RCDATAEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.13
        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit("</" + tokeniser.dataBuffer.toString());
            characterReader.unconsume();
            tokeniser.transition(TokeniserState.Rcdata);
        }

        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                String consumeLetterSequence = characterReader.consumeLetterSequence();
                tokeniser.tagPending.appendTagName(consumeLetterSequence);
                tokeniser.dataBuffer.append(consumeLetterSequence);
                return;
            }
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(TokeniserState.BeforeAttributeName);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            if (consume == '/') {
                if (tokeniser.isAppropriateEndTagToken()) {
                    tokeniser.transition(TokeniserState.SelfClosingStartTag);
                    return;
                } else {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
            }
            if (consume != '>') {
                anythingElse(tokeniser, characterReader);
            } else if (!tokeniser.isAppropriateEndTagToken()) {
                anythingElse(tokeniser, characterReader);
            } else {
                tokeniser.emitTagPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    RawtextLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.14
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(TokeniserState.RawtextEndTagOpen);
            } else {
                tokeniser.emit('<');
                tokeniser.transition(TokeniserState.Rawtext);
            }
        }
    },
    RawtextEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.15
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.16
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.17
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '!') {
                tokeniser.emit("<!");
                tokeniser.transition(TokeniserState.ScriptDataEscapeStart);
            } else if (consume == '/') {
                tokeniser.createTempBuffer();
                tokeniser.transition(TokeniserState.ScriptDataEndTagOpen);
            } else {
                tokeniser.emit("<");
                characterReader.unconsume();
                tokeniser.transition(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.18
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.19
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.20
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('-')) {
                tokeniser.transition(TokeniserState.ScriptData);
            } else {
                tokeniser.emit('-');
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapeStartDash);
            }
        }
    },
    ScriptDataEscapeStartDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.21
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('-')) {
                tokeniser.transition(TokeniserState.ScriptData);
            } else {
                tokeniser.emit('-');
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedDashDash);
            }
        }
    },
    ScriptDataEscaped { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.22
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else if (current == '-') {
                tokeniser.emit('-');
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedDash);
            } else if (current != '<') {
                tokeniser.emit(characterReader.consumeToAny('-', '<', 0));
            } else {
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.23
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataEscapedDashDash);
            } else if (consume == '<') {
                tokeniser.transition(TokeniserState.ScriptDataEscapedLessthanSign);
            } else {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.24
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else {
                if (consume == '-') {
                    tokeniser.emit(consume);
                    return;
                }
                if (consume == '<') {
                    tokeniser.transition(TokeniserState.ScriptDataEscapedLessthanSign);
                } else if (consume != '>') {
                    tokeniser.emit(consume);
                    tokeniser.transition(TokeniserState.ScriptDataEscaped);
                } else {
                    tokeniser.emit(consume);
                    tokeniser.transition(TokeniserState.ScriptData);
                }
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.25
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                if (characterReader.matches('/')) {
                    tokeniser.createTempBuffer();
                    tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedEndTagOpen);
                    return;
                } else {
                    tokeniser.emit('<');
                    tokeniser.transition(TokeniserState.ScriptDataEscaped);
                    return;
                }
            }
            tokeniser.createTempBuffer();
            tokeniser.dataBuffer.append(characterReader.current());
            tokeniser.emit("<" + characterReader.current());
            tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapeStart);
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.26
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matchesLetter()) {
                tokeniser.emit("</");
                tokeniser.transition(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(characterReader.current());
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(TokeniserState.ScriptDataEscapedEndTagName);
            }
        }
    },
    ScriptDataEscapedEndTagName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.27
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.28
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.29
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.emit(TokeniserState.replacementChar);
            } else if (current == '-') {
                tokeniser.emit(current);
                tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (current == '<') {
                tokeniser.emit(current);
                tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (current != 65535) {
                tokeniser.emit(characterReader.consumeToAny('-', '<', 0));
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.30
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else if (consume == '-') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (consume == '<') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (consume != 65535) {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.31
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.emit(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            if (consume == '-') {
                tokeniser.emit(consume);
                return;
            }
            if (consume == '<') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (consume == '>') {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptData);
            } else if (consume != 65535) {
                tokeniser.emit(consume);
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.32
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.matches('/')) {
                tokeniser.transition(TokeniserState.ScriptDataDoubleEscaped);
                return;
            }
            tokeniser.emit('/');
            tokeniser.createTempBuffer();
            tokeniser.advanceTransition(TokeniserState.ScriptDataDoubleEscapeEnd);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.33
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.34
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                characterReader.unconsume();
                tokeniser.transition(TokeniserState.AttributeName);
                return;
            }
            if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    }
                    if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    }
                    switch (consume) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        default:
                            tokeniser.tagPending.newAttribute();
                            characterReader.unconsume();
                            tokeniser.transition(TokeniserState.AttributeName);
                            return;
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
                tokeniser.transition(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.35
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendAttributeName(characterReader.consumeToAnySorted(TokeniserState.attributeNameCharsSorted));
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeName(TokeniserState.replacementChar);
                return;
            }
            if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    }
                    if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                        switch (consume) {
                            case '<':
                                break;
                            case '=':
                                tokeniser.transition(TokeniserState.BeforeAttributeValue);
                                return;
                            case '>':
                                tokeniser.emitTagPending();
                                tokeniser.transition(TokeniserState.Data);
                                return;
                            default:
                                tokeniser.tagPending.appendAttributeName(consume);
                                return;
                        }
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeName(consume);
                return;
            }
            tokeniser.transition(TokeniserState.AfterAttributeName);
        }
    },
    AfterAttributeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.36
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeName(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.AttributeName);
                return;
            }
            if (consume != ' ') {
                if (consume != '\"' && consume != '\'') {
                    if (consume == '/') {
                        tokeniser.transition(TokeniserState.SelfClosingStartTag);
                        return;
                    }
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    }
                    if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    }
                    switch (consume) {
                        case '<':
                            break;
                        case '=':
                            tokeniser.transition(TokeniserState.BeforeAttributeValue);
                            return;
                        case '>':
                            tokeniser.emitTagPending();
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        default:
                            tokeniser.tagPending.newAttribute();
                            characterReader.unconsume();
                            tokeniser.transition(TokeniserState.AttributeName);
                            return;
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.newAttribute();
                tokeniser.tagPending.appendAttributeName(consume);
                tokeniser.transition(TokeniserState.AttributeName);
            }
        }
    },
    BeforeAttributeValue { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.37
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.AttributeValue_unquoted);
                return;
            }
            if (consume != ' ') {
                if (consume == '\"') {
                    tokeniser.transition(TokeniserState.AttributeValue_doubleQuoted);
                    return;
                }
                if (consume != '`') {
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.emitTagPending();
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    }
                    if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                        return;
                    }
                    if (consume == '&') {
                        characterReader.unconsume();
                        tokeniser.transition(TokeniserState.AttributeValue_unquoted);
                        return;
                    }
                    if (consume == '\'') {
                        tokeniser.transition(TokeniserState.AttributeValue_singleQuoted);
                        return;
                    }
                    switch (consume) {
                        case '<':
                        case '=':
                            break;
                        case '>':
                            tokeniser.error(this);
                            tokeniser.emitTagPending();
                            tokeniser.transition(TokeniserState.Data);
                            return;
                        default:
                            characterReader.unconsume();
                            tokeniser.transition(TokeniserState.AttributeValue_unquoted);
                            return;
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(consume);
                tokeniser.transition(TokeniserState.AttributeValue_unquoted);
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.38
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny(TokeniserState.attributeDoubleValueCharsSorted);
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.AfterAttributeValue_quoted);
                return;
            }
            if (consume != '&') {
                if (consume != 65535) {
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                } else {
                    tokeniser.eofError(this);
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
            }
            int[] consumeCharacterReference = tokeniser.consumeCharacterReference('\"', true);
            if (consumeCharacterReference != null) {
                tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
            } else {
                tokeniser.tagPending.appendAttributeValue('&');
            }
        }
    },
    AttributeValue_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.39
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny(TokeniserState.attributeSingleValueCharsSorted);
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            } else {
                tokeniser.tagPending.setEmptyAttributeValue();
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != '&') {
                if (consume != '\'') {
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                } else {
                    tokeniser.transition(TokeniserState.AfterAttributeValue_quoted);
                    return;
                }
            }
            int[] consumeCharacterReference = tokeniser.consumeCharacterReference('\'', true);
            if (consumeCharacterReference != null) {
                tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
            } else {
                tokeniser.tagPending.appendAttributeValue('&');
            }
        }
    },
    AttributeValue_unquoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.40
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAnySorted = characterReader.consumeToAnySorted(TokeniserState.attributeValueUnquoted);
            if (consumeToAnySorted.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAnySorted);
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                return;
            }
            if (consume != ' ') {
                if (consume != '\"' && consume != '`') {
                    if (consume == 65535) {
                        tokeniser.eofError(this);
                        tokeniser.transition(TokeniserState.Data);
                        return;
                    }
                    if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                        if (consume == '&') {
                            int[] consumeCharacterReference = tokeniser.consumeCharacterReference('>', true);
                            if (consumeCharacterReference != null) {
                                tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                                return;
                            } else {
                                tokeniser.tagPending.appendAttributeValue('&');
                                return;
                            }
                        }
                        if (consume != '\'') {
                            switch (consume) {
                                case '<':
                                case '=':
                                    break;
                                case '>':
                                    tokeniser.emitTagPending();
                                    tokeniser.transition(TokeniserState.Data);
                                    return;
                                default:
                                    tokeniser.tagPending.appendAttributeValue(consume);
                                    return;
                            }
                        }
                    }
                }
                tokeniser.error(this);
                tokeniser.tagPending.appendAttributeValue(consume);
                return;
            }
            tokeniser.transition(TokeniserState.BeforeAttributeName);
        }
    },
    AfterAttributeValue_quoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.41
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeAttributeName);
                return;
            }
            if (consume == '/') {
                tokeniser.transition(TokeniserState.SelfClosingStartTag);
                return;
            }
            if (consume == '>') {
                tokeniser.emitTagPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            } else {
                tokeniser.error(this);
                characterReader.unconsume();
                tokeniser.transition(TokeniserState.BeforeAttributeName);
            }
        }
    },
    SelfClosingStartTag { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.42
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.tagPending.selfClosing = true;
                tokeniser.emitTagPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.transition(TokeniserState.Data);
            } else {
                tokeniser.error(this);
                characterReader.unconsume();
                tokeniser.transition(TokeniserState.BeforeAttributeName);
            }
        }
    },
    BogusComment { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.43
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.unconsume();
            Token.Comment comment = new Token.Comment();
            comment.bogus = true;
            comment.data.append(characterReader.consumeTo('>'));
            tokeniser.emit(comment);
            tokeniser.advanceTransition(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.44
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchConsume("--")) {
                tokeniser.createCommentPending();
                tokeniser.transition(TokeniserState.CommentStart);
            } else if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniser.transition(TokeniserState.Doctype);
            } else if (characterReader.matchConsume("[CDATA[")) {
                tokeniser.createTempBuffer();
                tokeniser.transition(TokeniserState.CdataSection);
            } else {
                tokeniser.error(this);
                tokeniser.advanceTransition(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.45
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.transition(TokeniserState.CommentStartDash);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.commentPending.data.append(consume);
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentStartDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.46
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.transition(TokeniserState.CommentStartDash);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.commentPending.data.append(consume);
                tokeniser.transition(TokeniserState.Comment);
            } else {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    Comment { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.47
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                tokeniser.error(this);
                characterReader.advance();
                tokeniser.commentPending.data.append(TokeniserState.replacementChar);
            } else if (current == '-') {
                tokeniser.advanceTransition(TokeniserState.CommentEndDash);
            } else {
                if (current != 65535) {
                    tokeniser.commentPending.data.append(characterReader.consumeToAny('-', 0));
                    return;
                }
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CommentEndDash { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.48
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                StringBuilder sb = tokeniser.commentPending.data;
                sb.append('-');
                sb.append(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.transition(TokeniserState.CommentEnd);
                return;
            }
            if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else {
                StringBuilder sb2 = tokeniser.commentPending.data;
                sb2.append('-');
                sb2.append(consume);
                tokeniser.transition(TokeniserState.Comment);
            }
        }
    },
    CommentEnd { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.49
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                StringBuilder sb = tokeniser.commentPending.data;
                sb.append("--");
                sb.append(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.Comment);
                return;
            }
            if (consume == '!') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.CommentEndBang);
                return;
            }
            if (consume == '-') {
                tokeniser.error(this);
                tokeniser.commentPending.data.append('-');
                return;
            }
            if (consume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else {
                tokeniser.error(this);
                StringBuilder sb2 = tokeniser.commentPending.data;
                sb2.append("--");
                sb2.append(consume);
                tokeniser.transition(TokeniserState.Comment);
            }
        }
    },
    CommentEndBang { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.50
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                StringBuilder sb = tokeniser.commentPending.data;
                sb.append("--!");
                sb.append(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.Comment);
                return;
            }
            if (consume == '-') {
                tokeniser.commentPending.data.append("--!");
                tokeniser.transition(TokeniserState.CommentEndDash);
                return;
            }
            if (consume == '>') {
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume == 65535) {
                tokeniser.eofError(this);
                tokeniser.emitCommentPending();
                tokeniser.transition(TokeniserState.Data);
            } else {
                StringBuilder sb2 = tokeniser.commentPending.data;
                sb2.append("--!");
                sb2.append(consume);
                tokeniser.transition(TokeniserState.Comment);
            }
        }
    },
    Doctype { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.51
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeDoctypeName);
                return;
            }
            if (consume != '>') {
                if (consume != 65535) {
                    tokeniser.error(this);
                    tokeniser.transition(TokeniserState.BeforeDoctypeName);
                    return;
                }
                tokeniser.eofError(this);
            }
            tokeniser.error(this);
            tokeniser.createDoctypePending();
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(TokeniserState.Data);
        }
    },
    BeforeDoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.52
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(TokeniserState.DoctypeName);
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append(TokeniserState.replacementChar);
                tokeniser.transition(TokeniserState.DoctypeName);
                return;
            }
            if (consume != ' ') {
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
                if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r') {
                    return;
                }
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.name.append(consume);
                tokeniser.transition(TokeniserState.DoctypeName);
            }
        }
    },
    DoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.53
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence());
                return;
            }
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.name.append(TokeniserState.replacementChar);
                return;
            }
            if (consume != ' ') {
                if (consume == '>') {
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
                if (consume == 65535) {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(TokeniserState.Data);
                    return;
                }
                if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r') {
                    tokeniser.doctypePending.name.append(consume);
                    return;
                }
            }
            tokeniser.transition(TokeniserState.AfterDoctypeName);
        }
    },
    AfterDoctypeName { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.54
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (characterReader.matchesAny('\t', '\n', '\r', '\f', ' ')) {
                characterReader.advance();
                return;
            }
            if (characterReader.matches('>')) {
                tokeniser.emitDoctypePending();
                tokeniser.advanceTransition(TokeniserState.Data);
                return;
            }
            if (characterReader.matchConsumeIgnoreCase("PUBLIC")) {
                tokeniser.doctypePending.pubSysKey = "PUBLIC";
                tokeniser.transition(TokeniserState.AfterDoctypePublicKeyword);
            } else if (characterReader.matchConsumeIgnoreCase("SYSTEM")) {
                tokeniser.doctypePending.pubSysKey = "SYSTEM";
                tokeniser.transition(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.advanceTransition(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.55
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeDoctypePublicIdentifier);
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.56
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.57
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.doctypePending.publicIdentifier.append(consume);
                return;
            }
            tokeniser.eofError(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(TokeniserState.Data);
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.58
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.publicIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(TokeniserState.AfterDoctypePublicIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.doctypePending.publicIdentifier.append(consume);
                return;
            }
            tokeniser.eofError(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(TokeniserState.Data);
        }
    },
    AfterDoctypePublicIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.59
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.60
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.61
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(TokeniserState.BeforeDoctypeSystemIdentifier);
                return;
            }
            if (consume == '\"') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.62
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.63
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\"') {
                tokeniser.transition(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.doctypePending.systemIdentifier.append(consume);
                return;
            }
            tokeniser.eofError(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(TokeniserState.Data);
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.64
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == 0) {
                tokeniser.error(this);
                tokeniser.doctypePending.systemIdentifier.append(TokeniserState.replacementChar);
                return;
            }
            if (consume == '\'') {
                tokeniser.transition(TokeniserState.AfterDoctypeSystemIdentifier);
                return;
            }
            if (consume == '>') {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
                return;
            }
            if (consume != 65535) {
                tokeniser.doctypePending.systemIdentifier.append(consume);
                return;
            }
            tokeniser.eofError(this);
            tokeniser.doctypePending.forceQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(TokeniserState.Data);
        }
    },
    AfterDoctypeSystemIdentifier { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.65
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                return;
            }
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else if (consume != 65535) {
                tokeniser.error(this);
                tokeniser.transition(TokeniserState.BogusDoctype);
            } else {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    BogusDoctype { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.66
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            if (consume == '>') {
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            } else {
                if (consume != 65535) {
                    return;
                }
                tokeniser.emitDoctypePending();
                tokeniser.transition(TokeniserState.Data);
            }
        }
    },
    CdataSection { // from class: io.noties.markwon.html.jsoup.parser.TokeniserState.67
        @Override // io.noties.markwon.html.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.dataBuffer.append(characterReader.consumeTo("]]>"));
            if (characterReader.matchConsume("]]>") || characterReader.isEmpty()) {
                tokeniser.emit(new Token.CData(tokeniser.dataBuffer.toString()));
                tokeniser.transition(TokeniserState.Data);
            }
        }
    };

    private static final char eof = 65535;
    static final char[] attributeSingleValueCharsSorted = {0, '&', '\''};
    static final char[] attributeDoubleValueCharsSorted = {0, '\"', '&'};
    static final char[] attributeNameCharsSorted = {0, '\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>'};
    static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    private static final char replacementChar = 65533;
    private static final String replacementStr = String.valueOf(replacementChar);

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(consumeLetterSequence);
            tokeniser.emit(consumeLetterSequence);
            return;
        }
        char consume = characterReader.consume();
        if (consume != '\t' && consume != '\n' && consume != '\f' && consume != '\r' && consume != ' ' && consume != '/' && consume != '>') {
            characterReader.unconsume();
            tokeniser.transition(tokeniserState2);
        } else {
            if (tokeniser.dataBuffer.toString().equals("script")) {
                tokeniser.transition(tokeniserState);
            } else {
                tokeniser.transition(tokeniserState2);
            }
            tokeniser.emit(consume);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.tagPending.appendTagName(consumeLetterSequence);
            tokeniser.dataBuffer.append(consumeLetterSequence);
            return;
        }
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char consume = characterReader.consume();
            if (consume == '\t' || consume == '\n' || consume == '\f' || consume == '\r' || consume == ' ') {
                tokeniser.transition(BeforeAttributeName);
                return;
            }
            if (consume == '/') {
                tokeniser.transition(SelfClosingStartTag);
                return;
            } else {
                if (consume == '>') {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                }
                tokeniser.dataBuffer.append(consume);
            }
        }
        tokeniser.emit("</" + tokeniser.dataBuffer.toString());
        tokeniser.transition(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
        if (consumeCharacterReference == null) {
            tokeniser.emit('&');
        } else {
            tokeniser.emit(consumeCharacterReference);
        }
        tokeniser.transition(tokeniserState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readData(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char current = characterReader.current();
        if (current == 0) {
            tokeniser.error(tokeniserState);
            characterReader.advance();
            tokeniser.emit(replacementChar);
        } else if (current == '<') {
            tokeniser.advanceTransition(tokeniserState2);
        } else if (current != 65535) {
            tokeniser.emit(characterReader.consumeToAny('<', 0));
        } else {
            tokeniser.emit(new Token.EOF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            tokeniser.createTagPending(false);
            tokeniser.transition(tokeniserState);
        } else {
            tokeniser.emit("</");
            tokeniser.transition(tokeniserState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);
}
