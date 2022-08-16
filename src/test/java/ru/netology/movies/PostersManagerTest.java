package ru.netology.movies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostersManagerTest {

  @Mock
  private PostersRepository repository;
  private PostersManager manager;

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
  void findLastElevenPosters() {
    Posters[] mockStub = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    doReturn(mockStub).when(repository).findAll();
    manager = new PostersManager(repository, 11);
    Posters[] expected = new Posters[]{madagascar, locke, execution, theAdjustmentBureau, domino, shotCaller, cloudAtlas, fightClub, numberOne, trolls, theInvisibleMan};
    Posters[] actual = manager.findLast();

    assertArrayEquals(expected, actual);
    verify(repository).findAll();
  }

  @Test
  void findLessPosters() {
    Posters[] mockStub = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas};
    doReturn(mockStub).when(repository).findAll();
    manager = new PostersManager(repository);
    Posters[] expected = new Posters[]{cloudAtlas, fightClub, numberOne, trolls, theInvisibleMan, theGentlemen};
    Posters[] actual = manager.findLast();

    assertArrayEquals(expected, actual);
    verify(repository).findAll();
  }

  @Test
  void findLastPosters() {
    Posters[] mockStub = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    doReturn(mockStub).when(repository).findAll();
    manager = new PostersManager(repository, 5);
    Posters[] expected = new Posters[]{madagascar, locke, execution, theAdjustmentBureau, domino};
    Posters[] actual = manager.findLast();

    assertArrayEquals(expected, actual);
    verify(repository).findAll();
  }

  @Test
  void findZeroPosters() {
    Posters[] mockStub = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    doReturn(mockStub).when(repository).findAll();
    manager = new PostersManager(repository, 0);
    Posters[] expected = new Posters[0];
    Posters[] actual = manager.findLast();

    assertArrayEquals(expected, actual);
    verify(repository).findAll();
  }

  @Test
  void findDownZeroPosters() {
    Posters[] mockStub = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    doReturn(mockStub).when(repository).findAll();
    manager = new PostersManager(repository, -1);
    Posters[] expected = new Posters[]{theGentlemen, theInvisibleMan, trolls, numberOne, fightClub, cloudAtlas, shotCaller, domino, theAdjustmentBureau, execution, locke, madagascar};
    Posters[] actual = manager.findAll();

    assertArrayEquals(expected, actual);
    verify(repository).findAll();
  }

  @Test
  void AddPosters() {
    doNothing().when(repository).save(any(Posters.class));
    manager = new PostersManager(repository);
    manager.add(trolls);
    manager.add(fightClub);

    verify(repository).save(trolls);
    verify(repository).save(fightClub);
  }
}

