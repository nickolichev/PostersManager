package ru.netology.movies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PostersTest {

  Posters theGentlemen = new Posters(444, 4, "TheGentlemen", "action", "13th of February");
  Posters theInvisibleMan = new Posters(555, 5, "TheInvisibleMan", "horror", "5th of March");
  Posters trolls = new Posters(666, 6, "Trolls", "cartoon", "tomorrow");
  Posters numberOne = new Posters(777, 7, "NumberOne", "comedy", "tomorrow");
  Posters fightClub = new Posters(888, 8, "FightClub", "thriller", "18th July");
  Posters cloudAtlas = new Posters(999, 9, "CloudAtlas", "drama", "8th June");
  Posters shotCaller = new Posters(1010, 10, "ShotCaller", "thriller", "3th January");
  Posters domino = new Posters(1011, 11, "Domino", "action", "18th October");
  Posters theAdjustmentBureau = new Posters(1012, 12, "TheAdjustmentBureau", "drama", "25th September");
  Posters execution = new Posters(1013, 13, "Execution", "thriller", "11th September");
  Posters locke = new Posters(1014, 14, "Locke", "drama", "21th April");
  Posters madagascar = new Posters(1015, 15, "Madagascar", "Cartoon", "15th April");

  @Test
  public void findLimitDefaultTenPoster() {      //+ вывод 10 (по умолчанию) последних добавленных фильмов в обратном порядке
    PostersManager manager = new PostersManager();

    manager.add(theGentlemen);
    manager.add(theInvisibleMan);
    manager.add(trolls);
    manager.add(numberOne);
    manager.add(fightClub);
    manager.add(cloudAtlas);
    manager.add(shotCaller);
    manager.add(domino);
    manager.add(theAdjustmentBureau);
    manager.add(execution);
    manager.add(locke);
    manager.add(madagascar);

    Posters[] actual = manager.findLast();
    Posters[] expected = {madagascar, locke, execution, theAdjustmentBureau, domino, shotCaller, cloudAtlas, fightClub, numberOne, trolls};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void findUserSettingsPoster() {   // вывод 5 последних добавленных фильмов
    PostersManager manager = new PostersManager(5);

    manager.add(domino);
    manager.add(theAdjustmentBureau);
    manager.add(execution);
    manager.add(locke);
    manager.add(madagascar);

    Posters[] actual = manager.findLast();
    Posters[] expected = {madagascar, locke, execution, theAdjustmentBureau, domino};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void findAllPostersInAddingOrder() {    // Вывод всех фильмов в порядке добавления
    PostersManager manager = new PostersManager();

    manager.add(theGentlemen);
    manager.add(theInvisibleMan);
    manager.add(trolls);
    manager.add(numberOne);
    manager.add(fightClub);
    manager.add(cloudAtlas);
    manager.add(shotCaller);
    manager.add(domino);
    manager.add(theAdjustmentBureau);
    manager.add(execution);
    manager.add(locke);
    manager.add(madagascar);

    Posters[] actual = manager.findAll();
    Posters[] expected = {theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void addNewPoster() {
    PostersManager manager = new PostersManager(1);

    manager.add(domino);

    Posters[] actual = manager.findLast();
    Posters[] expected = {domino};
    assertArrayEquals(expected, actual);
  }
}


