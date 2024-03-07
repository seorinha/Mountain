package com.project.mountain.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MountainTest {

	@Test
    void testMountainBuilder() {
        Mountain mountain = Mountain.builder()
                                    .id(1)
                                    .mtName("Mount Everest")
                                    .mtLocation("Himalayas")
                                    .mtHeight(8848.86)
                                    .mtLot(new BigDecimal("27.9881"))
                                    .mtLat(new BigDecimal("86.9250"))
                                    .createdAt(new Date())
                                    .updatedAt(new Date())
                                    .build();

        assertNotNull(mountain);
        assertEquals(1, mountain.getId());
        assertEquals("Mount Everest", mountain.getMtName());
        assertEquals("Himalayas", mountain.getMtLocation());
        assertEquals(8848.86, mountain.getMtHeight());
        assertEquals(new BigDecimal("27.9881"), mountain.getMtLot());
        assertEquals(new BigDecimal("86.9250"), mountain.getMtLat());
        assertNotNull(mountain.getCreatedAt());
        assertNotNull(mountain.getUpdatedAt());
    }

    @Test
    void testToString() {
        Mountain mountain = Mountain.builder()
                                    .id(1)
                                    .mtName("Mount Everest")
                                    .mtLocation("Himalayas")
                                    .mtHeight(8848.86)
                                    .mtLot(new BigDecimal("27.9881"))
                                    .mtLat(new BigDecimal("86.9250"))
                                    .createdAt(new Date())
                                    .updatedAt(new Date())
                                    .build();

        assertNotNull(mountain);
        assertNotNull(mountain.toString());
    }
	
}
