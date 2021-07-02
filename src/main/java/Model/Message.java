package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.sql.Time;

// line 43 "model.ump"
// line 89 "model.ump"
public class Message
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Message Attributes
  private Time time;
  private String content;
  private Enum messageType;

  //Message Associations
  private User user;
  private ChatBox chatBox;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Message(Time aTime, String aContent, Enum aMessageType, ChatBox aChatBox)
  {
    time = aTime;
    content = aContent;
    messageType = aMessageType;
    boolean didAddChatBox = setChatBox(aChatBox);
    if (!didAddChatBox)
    {
      throw new RuntimeException("Unable to create message due to chatBox. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setContent(String aContent)
  {
    boolean wasSet = false;
    content = aContent;
    wasSet = true;
    return wasSet;
  }

  public boolean setMessageType(Enum aMessageType)
  {
    boolean wasSet = false;
    messageType = aMessageType;
    wasSet = true;
    return wasSet;
  }

  public Time getTime()
  {
    return time;
  }

  public String getContent()
  {
    return content;
  }

  public Enum getMessageType()
  {
    return messageType;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }

  public boolean hasUser()
  {
    boolean has = user != null;
    return has;
  }
  /* Code from template association_GetOne */
  public ChatBox getChatBox()
  {
    return chatBox;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      existingUser.removeMessage(this);
    }
    if (aUser != null)
    {
      aUser.addMessage(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setChatBox(ChatBox aChatBox)
  {
    boolean wasSet = false;
    if (aChatBox == null)
    {
      return wasSet;
    }

    ChatBox existingChatBox = chatBox;
    chatBox = aChatBox;
    if (existingChatBox != null && !existingChatBox.equals(aChatBox))
    {
      existingChatBox.removeMessage(this);
    }
    chatBox.addMessage(this);
    wasSet = true;
    return wasSet;
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


  public String toString()
  {
    return super.toString() + "["+
            "content" + ":" + getContent()+ "]" + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "messageType" + "=" + (getMessageType() != null ? !getMessageType().equals(this)  ? getMessageType().toString().replaceAll("  ","    ") : "this" : "null") + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(java.lang.System.identityHashCode(getUser())):"null") + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "chatBox = "+(getChatBox()!=null?Integer.toHexString(java.lang.System.identityHashCode(getChatBox())):"null");
  }
}