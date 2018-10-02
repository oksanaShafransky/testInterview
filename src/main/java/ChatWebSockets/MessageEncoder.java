package ChatWebSockets;


import org.json.JSONObject;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder {//} implements Encoder.Text<Message> {
/*    @Override
    public String encode(final Message message) throws EncodeException {
        JSONObject obj = new JSONObject();
        obj.put("message", message.getContent());
        obj.put("sender", message.getSender());
        obj.put("received", "");
        return obj.toString();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }*/
}
