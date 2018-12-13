package com.iheartradio.m3u8;

interface LineParser {
    void parse(String line, ParseState state, boolean ignoreUnknownAttributes) throws ParseException;
}
