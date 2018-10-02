package ChatWebSockets;

import org.json.JSONObject;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;

public class MessageDecoder { /*implements Decoder.Text<Message> {

    @Override
    public Message decode(final String textMessage) throws DecodeException {
        Message message = new Message();
        JSONObject obj = new JSONObject(textMessage);
        message.setContent(obj.getString("message"));
        message.setSender(obj.getString("sender"));tes
        message.setReceived(new Date());
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }*/
}
