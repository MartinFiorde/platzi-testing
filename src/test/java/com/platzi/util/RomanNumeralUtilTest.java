package com.platzi.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralUtilTest {

    @Test
    void return_roman_numeral_for_range_to_100() {
        List<String> expected = Arrays.asList(
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        );
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), RomanNumeralUtil.arabicToRoman(i + 1));
            System.out.println((i + 1) + ": " + RomanNumeralUtil.arabicToRoman(i + 1));
        }
    }

    @Test
    void return_roman_numeral_for_range_to_1000_by_tens() {
        List<String> expected = Arrays.asList(
                "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C",
                "CX", "CXX", "CXXX", "CXL", "CL", "CLX", "CLXX", "CLXXX", "CXC", "CC",
                "CCX", "CCXX", "CCXXX", "CCXL", "CCL", "CCLX", "CCLXX", "CCLXXX", "CCXC", "CCC",
                "CCCX", "CCCXX", "CCCXXX", "CCCXL", "CCCL", "CCCLX", "CCCLXX", "CCCLXXX", "CCCXC", "CD",
                "CDX", "CDXX", "CDXXX", "CDXL", "CDL", "CDLX", "CDLXX", "CDLXXX", "CDXC", "D",
                "DX", "DXX", "DXXX", "DXL", "DL", "DLX", "DLXX", "DLXXX", "DXC", "DC",
                "DCX", "DCXX", "DCXXX", "DCXL", "DCL", "DCLX", "DCLXX", "DCLXXX", "DCXC", "DCC",
                "DCCX", "DCCXX", "DCCXXX", "DCCXL", "DCCL", "DCCLX", "DCCLXX", "DCCLXXX", "DCCXC", "DCCC",
                "DCCCX", "DCCCXX", "DCCCXXX", "DCCCXL", "DCCCL", "DCCCLX", "DCCCLXX", "DCCCLXXX", "DCCCXC", "CM",
                "CMX", "CMXX", "CMXXX", "CMXL", "CML", "CMLX", "CMLXX", "CMLXXX", "CMXC", "M"
        );
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), RomanNumeralUtil.arabicToRoman((i + 1) * 10));
            //System.out.println(((i + 1) * 10) + ": " + RomanNumeralUtil.arabicToRoman((i + 1) * 10));
        }
    }

    @Test
    void return_roman_numeral_for_1100_to_2000_by_tens() {
        List<String> expected = Arrays.asList(
                "MX", "MXX", "MXXX", "MXL", "ML", "MLX", "MLXX", "MLXXX", "MXC", "MC",
                "MCX", "MCXX", "MCXXX", "MCXL", "MCL", "MCLX", "MCLXX", "MCLXXX", "MCXC", "MCC",
                "MCCX", "MCCXX", "MCCXXX", "MCCXL", "MCCL", "MCCLX", "MCCLXX", "MCCLXXX", "MCCXC", "MCCC",
                "MCCCX", "MCCCXX", "MCCCXXX", "MCCCXL", "MCCCL", "MCCCLX", "MCCCLXX", "MCCCLXXX", "MCCCXC", "MCD",
                "MCDX", "MCDXX", "MCDXXX", "MCDXL", "MCDL", "MCDLX", "MCDLXX", "MCDLXXX", "MCDXC", "MD",
                "MDX", "MDXX", "MDXXX", "MDXL", "MDL", "MDLX", "MDLXX", "MDLXXX", "MDXC", "MDC",
                "MDCX", "MDCXX", "MDCXXX", "MDCXL", "MDCL", "MDCLX", "MDCLXX", "MDCLXXX", "MDCXC", "MDCC",
                "MDCCX", "MDCCXX", "MDCCXXX", "MDCCXL", "MDCCL", "MDCCLX", "MDCCLXX", "MDCCLXXX", "MDCCXC", "MDCCC",
                "MDCCCX", "MDCCCXX", "MDCCCXXX", "MDCCCXL", "MDCCCL", "MDCCCLX", "MDCCCLXX", "MDCCCLXXX", "MDCCCXC", "MCM",
                "MCMX", "MCMXX", "MCMXXX", "MCMXL", "MCML", "MCMLX", "MCMLXX", "MCMLXXX", "MCMXC", "MM"
        );
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), RomanNumeralUtil.arabicToRoman(1000 + (i + 1) * 10));
            //System.out.println((1000 + (i + 1) * 10) + ": " + RomanNumeralUtil.arabicToRoman(1000 + (i + 1) * 10));
        }
    }

    @Test
    void return_roman_numeral_for_2100_to_3000_by_tens() {
        List<String> expected = Arrays.asList(
                "MMX", "MMXX", "MMXXX", "MMXL", "MML", "MMLX", "MMLXX", "MMLXXX", "MMXC", "MMC",
                "MMCX", "MMCXX", "MMCXXX", "MMCXL", "MMCL", "MMCLX", "MMCLXX", "MMCLXXX", "MMCXC", "MMCC",
                "MMCCX", "MMCCXX", "MMCCXXX", "MMCCXL", "MMCCL", "MMCCLX", "MMCCLXX", "MMCCLXXX", "MMCCXC", "MMCCC",
                "MMCCCX", "MMCCCXX", "MMCCCXXX", "MMCCCXL", "MMCCCL", "MMCCCLX", "MMCCCLXX", "MMCCCLXXX", "MMCCCXC", "MMCD",
                "MMCDX", "MMCDXX", "MMCDXXX", "MMCDXL", "MMCDL", "MMCDLX", "MMCDLXX", "MMCDLXXX", "MMCDXC", "MMD",
                "MMDX", "MMDXX", "MMDXXX", "MMDXL", "MMDL", "MMDLX", "MMDLXX", "MMDLXXX", "MMDXC", "MMDC",
                "MMDCX", "MMDCXX", "MMDCXXX", "MMDCXL", "MMDCL", "MMDCLX", "MMDCLXX", "MMDCLXXX", "MMDCXC", "MMDCC",
                "MMDCCX", "MMDCCXX", "MMDCCXXX", "MMDCCXL", "MMDCCL", "MMDCCLX", "MMDCCLXX", "MMDCCLXXX", "MMDCCXC", "MMDCCC",
                "MMDCCCX", "MMDCCCXX", "MMDCCCXXX", "MMDCCCXL", "MMDCCCL", "MMDCCCLX", "MMDCCCLXX", "MMDCCCLXXX", "MMDCCCXC", "MMCM",
                "MMCMX", "MMCMXX", "MMCMXXX", "MMCMXL", "MMCML", "MMCMLX", "MMCMLXX", "MMCMLXXX", "MMCMXC", "MMM"
        );
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), RomanNumeralUtil.arabicToRoman(2000 + (i + 1) * 10));
            //System.out.println((2000 + (i + 1) * 10) + ": " + RomanNumeralUtil.arabicToRoman(2000 + (i + 1) * 10));
        }
    }

    @Test
    void return_roman_numeral_for_3100_to_3000_by_tens() {
        List<String> expected = Arrays.asList(
                "MMMX", "MMMXX", "MMMXXX", "MMMXL", "MMML", "MMMLX", "MMMLXX", "MMMLXXX", "MMMXC", "MMMC",
                "MMMCX", "MMMCXX", "MMMCXXX", "MMMCXL", "MMMCL", "MMMCLX", "MMMCLXX", "MMMCLXXX", "MMMCXC", "MMMCC",
                "MMMCCX", "MMMCCXX", "MMMCCXXX", "MMMCCXL", "MMMCCL", "MMMCCLX", "MMMCCLXX", "MMMCCLXXX", "MMMCCXC", "MMMCCC",
                "MMMCCCX", "MMMCCCXX", "MMMCCCXXX", "MMMCCCXL", "MMMCCCL", "MMMCCCLX", "MMMCCCLXX", "MMMCCCLXXX", "MMMCCCXC", "MMMCD",
                "MMMCDX", "MMMCDXX", "MMMCDXXX", "MMMCDXL", "MMMCDL", "MMMCDLX", "MMMCDLXX", "MMMCDLXXX", "MMMCDXC", "MMMD",
                "MMMDX", "MMMDXX", "MMMDXXX", "MMMDXL", "MMMDL", "MMMDLX", "MMMDLXX", "MMMDLXXX", "MMMDXC", "MMMDC",
                "MMMDCX", "MMMDCXX", "MMMDCXXX", "MMMDCXL", "MMMDCL", "MMMDCLX", "MMMDCLXX", "MMMDCLXXX", "MMMDCXC", "MMMDCC",
                "MMMDCCX", "MMMDCCXX", "MMMDCCXXX", "MMMDCCXL", "MMMDCCL", "MMMDCCLX", "MMMDCCLXX", "MMMDCCLXXX", "MMMDCCXC", "MMMDCCC",
                "MMMDCCCX", "MMMDCCCXX", "MMMDCCCXXX", "MMMDCCCXL", "MMMDCCCL", "MMMDCCCLX", "MMMDCCCLXX", "MMMDCCCLXXX", "MMMDCCCXC", "MMMCM",
                "MMMCMX", "MMMCMXX", "MMMCMXXX", "MMMCMXL", "MMMCML", "MMMCMLX", "MMMCMLXX", "MMMCMLXXX", "MMMCMXC", "M+"
        );
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), RomanNumeralUtil.arabicToRoman(3000 + (i + 1) * 10));
            //System.out.println((3000 + (i + 1) * 10) + ": " + RomanNumeralUtil.arabicToRoman(3000 + (i + 1) * 10));
        }
    }

    @Test
    void return_roman_numeral_for_special_cases() {
        assertEquals("-0", RomanNumeralUtil.arabicToRoman(-100000));
        assertEquals("-0", RomanNumeralUtil.arabicToRoman(-1));
        assertEquals("0", RomanNumeralUtil.arabicToRoman(0));
        assertEquals("MMMCMXCIII", RomanNumeralUtil.arabicToRoman(3993));
        assertEquals("MMMCMXCIV", RomanNumeralUtil.arabicToRoman(3994));
        assertEquals("MMMCMXCV", RomanNumeralUtil.arabicToRoman(3995));
        assertEquals("MMMCMXCVI", RomanNumeralUtil.arabicToRoman(3996));
        assertEquals("MMMCMXCVII", RomanNumeralUtil.arabicToRoman(3997));
        assertEquals("MMMCMXCVIII", RomanNumeralUtil.arabicToRoman(3998));
        assertEquals("MMMCMXCIX", RomanNumeralUtil.arabicToRoman(3999));
    }
}
