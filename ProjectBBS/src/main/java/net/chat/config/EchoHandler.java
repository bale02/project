package net.chat.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import net.user.domain.userVO;

public class EchoHandler extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		sessionList.add(session);
	}
	
	@Override 
	protected void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception{
		Map<String,Object> map = session.getAttributes();
		userVO userVO = (userVO)map.get("login");
		String userid = "";
		
		if(userVO != null) {
			userid = userVO.getUser_Id();
		}else {
			userid = session.getId();
		}
		for(WebSocketSession sess: sessionList) {
			sess.sendMessage(new TextMessage(userid+": " + message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,CloseStatus status) throws Exception{
		sessionList.remove(session);
	}
}
