package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.util.*;

// line 32 "model.ump"
// line 77 "model.ump"
public class Game2 extends Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game2(String aRoomID, int aMaxPlayer, String aGameMode, boolean aIsPublic, int aPasswordForRoom, User aHost, GamePlatformSystem aGamePlatformSystem, ChatBox aChatBox)
  {
    super(aRoomID, aMaxPlayer, aGameMode, aIsPublic, aPasswordForRoom, aHost, aGamePlatformSystem, aChatBox);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}