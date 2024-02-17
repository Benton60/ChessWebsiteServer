package com.example.ChessWebsiteServer.Engine;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class EngineController {
    @MessageMapping("/Engine.getMoves")
    @SendTo("/topic/public")
    public String getMoves(
            @Payload String pos
    ) throws JsonProcessingException {
        Position req = new  ObjectMapper().readValue(pos, Position.class);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(req.getAllMoves());
        System.out.println(json);
        return json;
    }
    @MessageMapping("/Engine.getComputerMove")
    @SendTo("topic/public")
    public Move getComputerMove(
            @Payload Position req
    ){
        return new EngineRunner(req, 100).getBestMove();
    }
}
