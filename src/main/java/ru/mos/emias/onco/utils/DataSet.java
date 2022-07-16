package ru.mos.emias.onco.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataSet {
    private static final String specSymbols = "!@#$%^&*()-=[]{}''<>/?|+_`~;:№";

    static Stream<Arguments> positiveCasesForOmsFields() {
        return Stream.of(
                Arguments.of("минимальное значение 1 символ", "1"),
                Arguments.of("максимальное значение 16 символов", RandomStringUtils.randomNumeric(16)),
                Arguments.of("ввод с пробелом в начале строки", " " + RandomStringUtils.randomNumeric(16)),
                Arguments.of("ввод с пробелом в кноце строки", RandomStringUtils.randomNumeric(16) + " "),
                Arguments.of("ввод с пробелом в начале и в кноце строки", " " + RandomStringUtils.randomNumeric(16) + " "),
                Arguments.of("ввод с пробелом в середине строки", RandomStringUtils.randomNumeric(8) + " " + RandomStringUtils.randomNumeric(8)),
                Arguments.of("очень большая числовая строка", RandomStringUtils.randomNumeric(512)),
                Arguments.of("очень большая буквенно-числовая строка", RandomStringUtils.randomAlphanumeric(512))
        );
    }

    static Stream<Arguments> negativeCasesForOmsFields() {
        return Stream.of(
                Arguments.of("ввод кириллицы", "абвгде"),
                Arguments.of("ввод латиницы", "qwertyuiopasdfghjk"),
                Arguments.of("ввод спец-символов", specSymbols),
                Arguments.of("ввод пробела", " ")
        );
    }
}
