package ChatWebSockets;

import java.util.Date;

public class Message {
    private String content;
    private String sender;
    private Date received;

    public Message(String content, String sender, Date received) {
        this.content = content;
        this.sender = sender;
        this.received = received;
    }
    public Message() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }
}
