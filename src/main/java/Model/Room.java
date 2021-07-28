package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.util.*;

public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private int maxPlayer;
  private String gameMode;
  private boolean isPublic;
  private Integer passwordForRoom;
  private User host;

  //Room Associations
  private List<User> users;
  private GamePlatformSystem gamePlatformSystem;
  private ChatBox chatBox;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(int aMaxPlayer, String aGameMode, boolean aIsPublic, Integer aPasswordForRoom, User aHost, GamePlatformSystem aGamePlatformSystem)
  {
    maxPlayer = aMaxPlayer;
    gameMode = aGameMode;
    isPublic = aIsPublic;
    passwordForRoom = aPasswordForRoom;
    host = aHost;
    users = new ArrayList<User>();
    boolean didAddGamePlatformSystem = setGamePlatformSystem(aGamePlatformSystem);
    if (!didAddGamePlatformSystem)
    {
      throw new RuntimeException("Unable to create room due to gamePlatformSystem.");
    }
    chatBox = new ChatBox(this);
  }


  //------------------------
  // INTERFACE
  //------------------------

  public void setMaxPlayer(int aMaxPlayer)
  {
    maxPlayer = aMaxPlayer;
  }

  public boolean setGameMode(String aGameMode)
  {
    boolean wasSet = false;
    gameMode = aGameMode;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsPublic(boolean aIsPublic)
  {
    boolean wasSet = false;
    isPublic = aIsPublic;
    wasSet = true;
    return wasSet;
  }

  public boolean setPasswordForRoom(int aPasswordForRoom)
  {
    boolean wasSet = false;
    passwordForRoom = aPasswordForRoom;
    wasSet = true;
    return wasSet;
  }

  public boolean setHost(User aHost)
  {
    boolean wasSet = false;
    host = aHost;
    wasSet = true;
    return wasSet;
  }

  public int getMaxPlayer()
  {
    return maxPlayer;
  }

  public String getGameMode()
  {
    return gameMode;
  }

  public boolean getIsPublic()
  {
    return isPublic;
  }

  public Integer getPasswordForRoom()
  {
    return passwordForRoom;
  }

  public User getHost()
  {
    return host;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsPublic()
  {
    return isPublic;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> addHost = new ArrayList<>(users);
    addHost.add(host);
    return addHost;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number+1;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetOne */
  public GamePlatformSystem getGamePlatformSystem()
  {
    return gamePlatformSystem;
  }
  /* Code from template association_GetOne */
  public ChatBox getChatBox()
  {
    return chatBox;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    Room existingRoom = aUser.getRoom();
    if (existingRoom == null)
    {
      aUser.setRoom(this);
    }
    else if (!this.equals(existingRoom))
    {
      existingRoom.removeUser(aUser);
      addUser(aUser);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    if (users.contains(aUser))
    {
      users.remove(aUser);
      aUser.setRoom(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHostUser()
  {
    return 0;
  }

  /* Code from template association_SetOneToMany */
  public boolean setGamePlatformSystem(GamePlatformSystem aGamePlatformSystem)
  {
    boolean wasSet = false;
    if (aGamePlatformSystem == null)
    {
      return wasSet;
    }

    GamePlatformSystem existingGamePlatformSystem = gamePlatformSystem;
    gamePlatformSystem = aGamePlatformSystem;
    if (existingGamePlatformSystem != null && !existingGamePlatformSystem.equals(aGamePlatformSystem))
    {
      existingGamePlatformSystem.removeRoom(this);
    }
    gamePlatformSystem.addRoom(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !users.isEmpty() )
    {
      users.get(0).setRoom(null);
    }
    GamePlatformSystem placeholderGamePlatformSystem = gamePlatformSystem;
    this.gamePlatformSystem = null;
    if(placeholderGamePlatformSystem != null)
    {
      placeholderGamePlatformSystem.removeRoom(this);
    }
    ChatBox existingChatBox = chatBox;
    chatBox = null;
    if (existingChatBox != null)
    {
      existingChatBox.delete();
    }
  }
}