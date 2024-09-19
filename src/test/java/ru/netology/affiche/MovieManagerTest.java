package ru.netology.affiche;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test
    public void testNotAddMovie() { // Тестируем случай ни разу не вызывая метод добавления
        String[] expected = {}; // ожидаемый результат пустой массив
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOneMovie() { // Тестируем случай при добавлении 1 фильма
        manager.addMovie("Film I");

        String[] expected = {"Film I"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddSomeMovies() { // Тестируем случай при добавлении нескольких фильмов
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");

        String[] expected = {"Film I", "Film II", "Film III"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    //// тестируем findLast
    @Test
    public void testFindLastLessThanLimit() { // тестируем findLast 1. меньше лимита
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");

        String[] expected = {"Film III", "Film II", "Film I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastEqualsLimit() { // тестируем findLast 2. равно лимиту,
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        manager.addMovie("Film IV");
        manager.addMovie("Film V");

        String[] expected = {"Film V", "Film IV", "Film III", "Film II", "Film I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastMoreLimit() { // тестируем findLast 3. больше лимита
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        manager.addMovie("Film IV");
        manager.addMovie("Film V");
        manager.addMovie("Film VI");
        manager.addMovie("Film VII");

        String[] expected = {"Film VII", "Film VI", "Film V", "Film IV", "Film III"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    // тестируем findLast при установлении лимата
    MovieManager managerLimit = new MovieManager(10);

    @Test
    public void testLimitSetFindLastLessThanLimit() { // тестируем findLast при установлении лимата 1. меньше лимита
        managerLimit.addMovie("Film I");
        managerLimit.addMovie("Film II");
        managerLimit.addMovie("Film III");

        String[] expected = {"Film III", "Film II", "Film I"};
        String[] actual = managerLimit.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLimitSetFindLastEqualsLimit() { // тестируем findLast при установлении лимата 2. равно лимиту,
        managerLimit.addMovie("Film I");
        managerLimit.addMovie("Film II");
        managerLimit.addMovie("Film III");
        managerLimit.addMovie("Film IV");
        managerLimit.addMovie("Film V");
        managerLimit.addMovie("Film VI");
        managerLimit.addMovie("Film VII");
        managerLimit.addMovie("Film VIII");
        managerLimit.addMovie("Film IX");
        managerLimit.addMovie("Film X");

        String[] expected = {"Film X", "Film IX", "Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I"};
        String[] actual = managerLimit.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLimitSetFindLastMoreLimit() { // тестируем findLast при установлении лимата 3. больше лимита
        managerLimit.addMovie("Film I");
        managerLimit.addMovie("Film II");
        managerLimit.addMovie("Film III");
        managerLimit.addMovie("Film IV");
        managerLimit.addMovie("Film V");
        managerLimit.addMovie("Film VI");
        managerLimit.addMovie("Film VII");
        managerLimit.addMovie("Film VIII");
        managerLimit.addMovie("Film IX");
        managerLimit.addMovie("Film X");
        managerLimit.addMovie("Film XI");
        managerLimit.addMovie("Film XII");

        String[] expected = {"Film XII", "Film XI", "Film X", "Film IX", "Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III"};
        String[] actual = managerLimit.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}

