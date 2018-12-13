package com.iheartradio.m3u8;

public class ParsingMode {
    public static final ParsingMode STRICT = new Builder().build();

    public static final ParsingMode LENIENT = new Builder()
            .allowUnknownTags()
            .allowNegativeNumbers()
            .ignoreUnknownAttributes()
            .build();

    /**
     * If true, unrecognized tags will not throw an exception. Instead, they will be made available in the playlist for custom parsing.
     */
    public final boolean allowUnknownTags;

    /**
     * If true, negative numbers in violation of the specification will not throw an exception.
     */
    public final boolean allowNegativeNumbers;

    public final boolean ignoreUnknownAttributes;

    private ParsingMode(final boolean allowUnknownTags, final boolean allowNegativeNumbers, final boolean ignoreUnknownAttributes) {
        this.allowUnknownTags = allowUnknownTags;
        this.allowNegativeNumbers = allowNegativeNumbers;
        this.ignoreUnknownAttributes = ignoreUnknownAttributes;
    }

    public static class Builder {
        private boolean mAllowUnknownTags = false;
        private boolean mAllowNegativeNumbers = false;
        private boolean mIngoreUnknownAttributes = false;

        /**
         * Call to prevent throwing an exception when parsing unrecognized tags.
         */
        public Builder allowUnknownTags() {
            mAllowUnknownTags = true;
            return this;
        }

        /**
         * Call to prevent throwing an exception when parsing negative numbers in violation of the specification.
         */
        public Builder allowNegativeNumbers() {
            mAllowNegativeNumbers = true;
            return this;
        }

        public Builder ignoreUnknownAttributes() {
            mIngoreUnknownAttributes = true;
            return this;
        }

        public ParsingMode build() {
            return new ParsingMode(mAllowUnknownTags, mAllowNegativeNumbers, mIngoreUnknownAttributes);
        }
    }
}
