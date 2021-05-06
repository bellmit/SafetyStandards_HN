package org.springblade.anbiao.qiyeshouye.springTemplate.basicJsonBean;


public class JsonBean {
    private String messageId;
    private String messageContent;
    public JsonBean(){}

    public JsonBean(String messageId , String messageContent){
        this.messageId = messageId;
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
	public String toString() {
        return String.format("%s:%s", messageId, messageContent);
    }
}
