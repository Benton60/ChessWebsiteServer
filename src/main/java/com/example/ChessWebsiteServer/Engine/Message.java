package com.example.ChessWebsiteServer.Engine;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {


    private int player;
    private List<Move> moves;
    private int[][] gameBoard;
    private Move lastMove;

}
