package ru.netology.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostersRepositoryTest {

  private PostersRepository repository = new PostersRepository();
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

  @BeforeEach
  public void saveMethod() {
    repository.save(theGentlemen);
    repository.save(theInvisibleMan);
    repository.save(trolls);
    repository.save(numberOne);
    repository.save(fightClub);
    repository.save(cloudAtlas);
    repository.save(shotCaller);
    repository.save(domino);
    repository.save(theAdjustmentBureau);
    repository.save(execution);
    repository.save(locke);
    repository.save(madagascar);
  }

  @Test
  void FindAllPosters() {
    Posters[] actual = repository.findAll();
    Posters[] expected = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    assertArrayEquals(expected, actual);
  }

  @Test
  void FindByIdPoster() {
    Posters actual = repository.findById(555);
    Posters expected = theInvisibleMan;
    assertEquals(expected, actual);
  }

  @Test
  void FindByIdPosterFalse() {
    Posters actual = repository.findById(111);
    assertNull(actual);
  }

  @Test
  void removeByIdMovie() {
    repository.removeById(888);
    Posters[] actual = repository.findAll();
    Posters[] expected = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldRemoveAllMovie() {
    repository.removeAll();
    Posters[] actual = repository.findAll();
    Posters[] expected = new Posters[0];
    assertArrayEquals(expected, actual);
  }
}
