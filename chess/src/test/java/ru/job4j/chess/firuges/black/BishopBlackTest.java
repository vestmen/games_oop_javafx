package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void checkPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.D2);
        assertThat(bishopBlackCopy.position()).isEqualTo(Cell.D2);
    }

    @Test
    void whenC1toG5ThenD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(result);
    }

    @Test
    void whenException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.F5);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.F5);
                });
        String message = "Could not move by diagonal from "
                + bishopBlack.position() + " to " + bishopBlackCopy.position();
        assertThat(exception.getMessage()).isEqualTo(message);
    }
}