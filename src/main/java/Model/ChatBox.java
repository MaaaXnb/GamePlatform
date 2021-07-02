package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.util.*;
import java.sql.Time;

// line 37 "model.ump"
// line 82 "model.ump"
public class ChatBox
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ChatBox Associations
  private Room room;
  private List<Message> messages;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ChatBox(Room aRoom)
  {
    if (aRoom == null || aRoom.getChatBox() != null)
    {
      throw new RuntimeException("Unable to create ChatBox due to aRoom. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    room = aRoom;
    messages = new ArrayList<Message>();
  }

  public ChatBox(String aRoomIDForRoom, int aMaxPlayerForRoom, String aGameModeForRoom, boolean aIsPublicForRoom, int aPasswordForRoomForRoom, User aHostForRoom, GamePlatformSystem aGamePlatformSystemForRoom)
  {
    room = new Room(aRoomIDForRoom, aMaxPlayerForRoom, aGameModeForRoom, aIsPublicForRoom, aPasswordForRoomForRoom, aHostForRoom, aGamePlatformSystemForRoom, this);
    messages = new ArrayList<Message>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Room getRoom()
  {
    return room;
  }
  /* Code from template association_GetMany */
  public Message getMessage(int index)
  {
    Message aMessage = messages.get(index);
    return aMessage;
  }

  public List<Message> getMessages()
  {
    List<Message> newMessages = Collections.unmodifiableList(messages);
    return newMessages;
  }

  public int numberOfMessages()
  {
    int number = messages.size();
    return number;
  }

  public boolean hasMessages()
  {
    boolean has = messages.size() > 0;
    return has;
  }

  public int indexOfMessage(Message aMessage)
  {
    int index = messages.indexOf(aMessage);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMessages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Message addMessage(Time aTime, String aContent, Enum aMessageType)
  {
    return new Message(aTime, aContent, aMessageType, this);
  }

  public boolean addMessage(Message aMessage)
  {
    boolean wasAdded = false;
    if (messages.contains(aMessage)) { return false; }
    ChatBox existingChatBox = aMessage.getChatBox();
    boolean isNewChatBox = existingChatBox != null && !this.equals(existingChatBox);
    if (isNewChatBox)
    {
      aMessage.setChatBox(this);
    }
    else
    {
      messages.add(aMessage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMessage(Message aMessage)
  {
    boolean wasRemoved = false;
    //Unable to remove aMessage, as it must always have a chatBox
    if (!this.equals(aMessage.getChatBox()))
    {
      messages.remove(aMessage);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMessageAt(Message aMessage, int index)
  {  
    boolean wasAdded = false;
    if(addMessage(aMessage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMessages()) { index = numberOfMessages() - 1; }
      messages.remove(aMessage);
      messages.add(index, aMessage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMessageAt(Message aMessage, int index)
  {
    boolean wasAdded = false;
    if(messages.contains(aMessage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMessages()) { index = numberOfMessages() - 1; }
      messages.remove(aMessage);
      messages.add(index, aMessage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMessageAt(aMessage, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Room existingRoom = room;
    room = null;
    if (existingRoom != null)
    {
      existingRoom.delete();
    }
    for(int i=messages.size(); i > 0; i--)
    {
      Message aMessage = messages.get(i - 1);
      aMessage.delete();
    }
  }

}