package com.example.firebase_chat_basic.model;

/**
 * [ChatListModel]
 *
 * chatName, chatDate, chatContent, chatCount
 * @TODO create ChatProfile
 */
public class ChatListModel {
    String chatName;
    String chatDate;
    String chatContent;
    String chatCount;
    String chatKey;
    String getOtherUID;
    String getCurrentUserUID;

    public ChatListModel(String chatName, String chatDate, String chatContent, String chatCount, String chatKey, String getOtherUID, String getCurrentUserUID) {
        this.chatName = chatName;
        this.chatDate = chatDate;
        this.chatContent = chatContent;
        this.chatCount = chatCount;
        this.chatKey = chatKey;
        this.getOtherUID = getOtherUID;
        this.getCurrentUserUID = getCurrentUserUID;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public String getChatCount() {
        return chatCount;
    }

    public void setChatCount(String chatCount) {
        this.chatCount = chatCount;
    }

    public String getChatKey() {
        return chatKey;
    }

    public void setChatKey(String chatKey) {
        this.chatKey = chatKey;
    }

    public String getGetOtherUID() {
        return getOtherUID;
    }

    public void setGetOtherUID(String getOtherUID) {
        this.getOtherUID = getOtherUID;
    }

    public String getGetCurrentUserUID() {
        return getCurrentUserUID;
    }

    public void setGetCurrentUserUID(String getCurrentUserUID) {
        this.getCurrentUserUID = getCurrentUserUID;
    }
}
