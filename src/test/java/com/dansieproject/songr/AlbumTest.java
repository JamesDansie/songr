package com.dansieproject.songr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {
    Album test;
    @Before
    public void setUp() throws Exception {
        test = new Album("Power In Numbers", "Jurassic 5", 17, (56*60 + 11), "https://upload.wikimedia.org/wikipedia/en/e/e8/Power_in_Numbers.jpg");
    }

    @Test
    public void testToString() {
        assertEquals("The album is Jurassic 5's 'Power in Numbers'",
                "The Power In Numbers was written by Jurassic 5. It has 17 songs, and is 56 minutes and 11 seconds long.",
                test.toString());
    }
}