package com.platzi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateUtilLeapYearTest {

    /*
        All years divisible by 400 ARE leap years (1600, 2000, 2400)
        All years divisible by 100 but not by 400 are NOT leap years (1700, 1800, 1900)
        All years divisible by 4 but not by 100 ARE leap years (1996, 2004, 2008)
        All years not divisible by 4 are NOT leap years (2017, 2018, 2019)
    */

    @Test
    void should_return_true_when_divisible_by_400() {
        assertTrue(DateUtil.isLeapYear(1600));
        assertTrue(DateUtil.isLeapYear(2000));
        assertTrue(DateUtil.isLeapYear(2400));
    }

    @Test
    void should_return_false_when_divisible_by_100_but_not_400() {
        assertFalse(DateUtil.isLeapYear(1700));
        assertFalse(DateUtil.isLeapYear(1800));
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    void should_return_true_when_divisible_by_4_but_not_100() {
        assertTrue(DateUtil.isLeapYear(1996));
        assertTrue(DateUtil.isLeapYear(2004));
        assertTrue(DateUtil.isLeapYear(2008));
    }

    @Test
    void should_return_false_when_not_divisible() {
        assertFalse(DateUtil.isLeapYear(2017));
        assertFalse(DateUtil.isLeapYear(2018));
        assertFalse(DateUtil.isLeapYear(2019));
    }

    @Test
    void should_return_true_when_in_list_of_reference() {
        // Reference: https://en.wikipedia.org/wiki/Category:Leap_years_in_the_Gregorian_calendar as of 3-Sep-2024
        int[] years = {1584, 1588, 1592, 1596, 1600, 1604, 1608, 1612, 1616, 1620, 1624, 1628,
                1632, 1636, 1640, 1644, 1648, 1652, 1656, 1660, 1664, 1668, 1672, 1676, 1680, 1684,
                1688, 1692, 1696, 1704, 1708, 1712, 1716, 1720, 1724, 1728, 1732, 1736, 1740, 1744,
                1748, 1752, 1756, 1760, 1764, 1768, 1772, 1776, 1780, 1784, 1788, 1792, 1796, 1804,
                1808, 1812, 1816, 1820, 1824, 1828, 1832, 1836, 1840, 1844, 1848, 1852, 1856, 1860,
                1864, 1868, 1872, 1876, 1880, 1884, 1888, 1892, 1896, 1904, 1908, 1912, 1916, 1920,
                1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976,
                1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028};
        for (int year : years) {
            assertTrue(DateUtil.isLeapYear(year));
        }
    }

}
