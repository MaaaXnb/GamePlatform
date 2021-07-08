package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.util.*;

// line 20 "model.ump"
// line 72 "model.ump"
public class Game1 extends Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game1(int aRoomID, int aMaxPlayer, String aGameMode, boolean aIsPublic, int aPasswordForRoom, User aHost, GamePlatformSystem aGamePlatformSystem, ChatBox aChatBox)
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