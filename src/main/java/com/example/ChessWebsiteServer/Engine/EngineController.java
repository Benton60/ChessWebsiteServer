package com.example.ChessWebsiteServer.Engine;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class EngineController {
    @MessageMapping("/Engine.getMoves")
    @SendTo("/topic/public")
    public ArrayList<Move> getMoves(
            @Payload Position req
    ){
        return req.getAllMoves();
    }
    @MessageMapping("/Engine.getComputerMove")
    @SendTo("/topic/public");
    public Move getComputerMove(
            @Payload Position req
    ){
        return new EngineRunner(req, 100).getBestMove();
    }
}
