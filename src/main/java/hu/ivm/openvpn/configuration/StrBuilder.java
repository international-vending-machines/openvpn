/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ivm.openvpn.configuration;

import java.nio.CharBuffer;
import java.util.Iterator;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.text.TextStringBuilder;

/**
 *
 * @author gergely.asztalos
 */
public class StrBuilder extends org.apache.commons.text.TextStringBuilder {

	public StrBuilder() {
	}

	public StrBuilder(int initialCapacity) {
		super(initialCapacity);
	}

	public StrBuilder(String str) {
		super(str);
	}
	
	private int skips = 0;
	
	public StrBuilder ifTrue(boolean value) {
		if(!value) {
			skips++;
		}
		return this;
	}
	
	public StrBuilder ifTrue(boolean value, int count) {
		if(!value) {
			skips += count;
		}
		return this;
	}	
	
	private boolean doAppend() {
		boolean doAppend = true;
		if(skips > 0) {
			doAppend = false;
			skips--;
		}
		return doAppend;
	}

	@Override
	public StrBuilder appendFixedWidthPadRight(int value, int width, char padChar) {
		if(doAppend()) super.appendFixedWidthPadRight(value, width, padChar);
		return this;
	}

	@Override
	public StrBuilder appendFixedWidthPadRight(Object obj, int width, char padChar) {
		if(doAppend()) super.appendFixedWidthPadRight(obj, width, padChar);
		return this;
	}

	@Override
	public StrBuilder appendFixedWidthPadLeft(int value, int width, char padChar) {
		if(doAppend()) super.appendFixedWidthPadLeft(value, width, padChar);
		return this;
	}

	@Override
	public StrBuilder appendFixedWidthPadLeft(Object obj, int width, char padChar) {
		if(doAppend()) super.appendFixedWidthPadLeft(obj, width, padChar);
		return this;
	}

	@Override
	public StrBuilder appendPadding(int length, char padChar) {
		if(doAppend()) super.appendPadding(length, padChar);
		return this;
	}

	@Override
	public StrBuilder appendSeparator(char separator, int loopIndex) {
		if(doAppend()) super.appendSeparator(separator, loopIndex);
		return this;
	}

	@Override
	public StrBuilder appendSeparator(String separator, int loopIndex) {
		if(doAppend()) super.appendSeparator(separator, loopIndex);
		return this;
	}

	@Override
	public StrBuilder appendSeparator(char standard, char defaultIfEmpty) {
		if(doAppend()) super.appendSeparator(standard, defaultIfEmpty);
		return this;
	}

	@Override
	public StrBuilder appendSeparator(char separator) {
		if(doAppend()) super.appendSeparator(separator);
		return this;
	}

	@Override
	public StrBuilder appendSeparator(String standard, String defaultIfEmpty) {
		if(doAppend()) super.appendSeparator(standard, defaultIfEmpty);
		return this;
	}

	@Override
	public StrBuilder appendSeparator(String separator) {
		if(doAppend()) super.appendSeparator(separator);
		return this;
	}

	@Override
	public StrBuilder appendWithSeparators(Iterator<?> it, String separator) {
		if(doAppend()) super.appendWithSeparators(it, separator);
		return this;
	}

	@Override
	public StrBuilder appendWithSeparators(Iterable<?> iterable, String separator) {
		if(doAppend()) super.appendWithSeparators(iterable, separator);
		return this;
	}

	@Override
	public StrBuilder appendWithSeparators(Object[] array, String separator) {
		if(doAppend()) super.appendWithSeparators(array, separator);
		return this;
	}

	@Override
	public StrBuilder appendAll(Iterator<?> it) {
		if(doAppend()) super.appendAll(it);
		return this;
	}

	@Override
	public StrBuilder appendAll(Iterable<?> iterable) {
		if(doAppend()) super.appendAll(iterable);
		return this;
	}

	@SafeVarargs
	@Override
	public final <T> StrBuilder appendAll(T... array) {
		if(doAppend()) super.appendAll(array);
		return this;
	}

	@Override
	public StrBuilder appendln(double value) {
		if(doAppend()) super.appendln(value);
		return this;
	}

	@Override
	public StrBuilder appendln(float value) {
		if(doAppend()) super.appendln(value);
		return this;
	}

	@Override
	public StrBuilder appendln(long value) {
		if(doAppend()) super.appendln(value);
		return this;
	}

	@Override
	public StrBuilder appendln(int value) {
		if(doAppend()) super.appendln(value);
		return this;
	}

	@Override
	public StrBuilder appendln(char ch) {
		if(doAppend()) super.appendln(ch);
		return this;
	}

	@Override
	public StrBuilder appendln(boolean value) {
		if(doAppend()) super.appendln(value);
		return this;
	}

	@Override
	public StrBuilder appendln(char[] chars, int startIndex, int length) {
		if(doAppend()) super.appendln(chars, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder appendln(char[] chars) {
		if(doAppend()) super.appendln(chars);
		return this;
	}

	@Override
	public StrBuilder appendln(StringBuffer str, int startIndex, int length) {
		if(doAppend()) super.appendln(str, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder appendln(StringBuilder str, int startIndex, int length) {
		if(doAppend()) super.appendln(str, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder appendln(StringBuilder str) {
		if(doAppend()) super.appendln(str);
		return this;
	}

	@Override
	public StrBuilder appendln(StringBuffer str) {
		if(doAppend()) super.appendln(str);
		return this;
	}

	@Override
	public StrBuilder appendln(String format, Object... objs) {
		if(doAppend()) super.appendln(format, objs);
		return this;
	}

	@Override
	public StrBuilder appendln(String str, int startIndex, int length) {
		if(doAppend()) super.appendln(str, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder appendln(String str) {
		if(doAppend()) super.appendln(str);
		return this;
	}

	@Override
	public StrBuilder appendln(Object obj) {
		if(doAppend()) super.appendln(obj);
		return this;
	}

	@Override
	public StrBuilder append(double value) {
		if(doAppend()) super.append(value);
		return this;
	}

	@Override
	public StrBuilder append(float value) {
		if(doAppend()) super.append(value);
		return this;
	}

	@Override
	public StrBuilder append(long value) {
		if(doAppend()) super.append(value);
		return this;
	}

	@Override
	public StrBuilder append(int value) {
		if(doAppend()) super.append(value);
		return this;
	}

	@Override
	public StrBuilder append(char ch) {
		if(doAppend()) super.append(ch);
		return this;
	}

	@Override
	public StrBuilder append(boolean value) {
		if(doAppend()) super.append(value);
		return this;
	}

	@Override
	public StrBuilder append(char[] chars, int startIndex, int length) {
		if(doAppend()) super.append(chars, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder append(char[] chars) {
		if(doAppend()) super.append(chars);
		return this;
	}


	@Override
	public StrBuilder append(StringBuilder str, int startIndex, int length) {
		if(doAppend()) super.append(str, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder append(StringBuilder str) {
		if(doAppend()) super.append(str);
		return this;
	}

	@Override
	public StrBuilder append(StringBuffer str, int startIndex, int length) {
		if(doAppend()) super.append(str, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder append(StringBuffer str) {
		if(doAppend()) super.append(str);
		return this;
	}

	@Override
	public StrBuilder append(CharBuffer buf, int startIndex, int length) {
		if(doAppend()) super.append(buf, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder append(CharBuffer buf) {
		if(doAppend()) super.append(buf);
		return this;
	}

	@Override
	public StrBuilder append(String format, Object... objs) {
		if(doAppend()) super.append(format, objs);
		return this;
	}

	@Override
	public StrBuilder append(String str, int startIndex, int length) {
		if(doAppend()) super.append(str, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder append(String str) {
		if(doAppend()) super.append(str);
		return this;
	}

	@Override
	public StrBuilder append(CharSequence seq, int startIndex, int length) {
		if(doAppend()) super.append(seq, startIndex, length);
		return this;
	}

	@Override
	public StrBuilder append(CharSequence seq) {
		if(doAppend()) super.append(seq);
		return this;
	}

	@Override
	public StrBuilder append(Object obj) {
		if(doAppend()) super.append(obj);
		return this;
	}

	@Override
	public StrBuilder appendNull() {
		if(doAppend()) super.appendNull();
		return this;
	}

	@Override
	public StrBuilder appendNewLine() {
		if(doAppend()) super.appendNewLine();
		return this;
	}
	
	public StrBuilder space() {
		return append(' ');
	}

	public StrBuilder appendQuote(String str) {
		if(doAppend()) {
			super.append("\"");
			super.append(StringEscapeUtils.ESCAPE_JAVA.translate(str));
			super.append("\"");
		}
		return this;
	}

	@Override
	public TextStringBuilder append(TextStringBuilder str) {
		if(doAppend()) super.append(str);
		return this;
	}

	@Override
	public TextStringBuilder append(TextStringBuilder str, int startIndex, int length) {
		if(doAppend()) super.append(str, startIndex, length);
		return this;
	}

	@Override
	public TextStringBuilder appendln(TextStringBuilder str) {
		if(doAppend()) super.appendln(str);
		return this;
	}

	@Override
	public TextStringBuilder appendln(TextStringBuilder str, int startIndex, int length) {
		if(doAppend()) super.appendln(str, startIndex, length);
		return this;
	}
}
