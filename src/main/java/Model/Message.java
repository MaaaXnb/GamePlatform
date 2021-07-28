package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.sql.Time;
import java.util.UUID;

public class Message
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Message Attributes
  private Time time;
  private String content;
  private messageType messageType;

  //Message Associations
  private User user;
  private ChatBox chatBox;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Message(Time aTime, String aContent, messageType aMessageType, ChatBox aChatBox)
  {
    time = aTime;
    content = aContent;
    messageType = aMessageType;
    boolean didAddChatBox = setChatBox(aChatBox);
    if (!didAddChatBox)
    {
      throw new RuntimeException("Unable to create message due to chatBox.");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void setTime(Time aTime)
  {
    time = aTime;
  }

  public void setContent(String aContent)
  {
    content = aContent;
  }

  public void setMessageType(messageType aMessageType)
  {
    messageType = aMessageType;
  }

  public Time getTime()
  {
    return time;
  }

  public String getContent()
  {
    return content;
  }

  public messageType getMessageType()
  {
    return messageType;
  }


  public User getUser()
  {
    return user;
  }

  public ChatBox getChatBox()
  {
    return chatBox;
  }

  public boolean setUser(User aUser)
  {
    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser)) return false;
    if (aUser != null)
    {
      aUser.addMessage(this);
      return true;
    }
    return false;
  }
  /* Code from template association_SetOneToMany */
  public boolean setChatBox(ChatBox aChatBox)
  {
    if (aChatBox == null) return false;

    ChatBox existingChatBox = chatBox;
    chatBox = aChatBox;
    if (existingChatBox != null && !existingChatBox.equals(aChatBox)) return false;
    chatBox.addMessage(this);
    return true;
  }

  public void delete()
  {
    if (user != null)
    {
      User placeholderUser = user;
      this.user = null;
      placeholderUser.removeMessage(this);
    }
    ChatBox placeholderChatBox = chatBox;
    this.chatBox = null;
    if(placeholderChatBox != null)
    {
      placeholderChatBox.removeMessage(this);
    }
  }
}