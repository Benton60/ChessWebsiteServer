import { Move } from "./Move.js";
import { Coord } from "./Coord.js";
import { Position } from "./Position.js";

let gameBoard = [
    [-500,-300,-350,-900,-10000,-350,-300,-500],
    [-100,-100,-100,-100,-100,-100,-100,-100],
    [0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0],
    [100,100,100,100,100,100,100,100],
    [500,300,350,900,10000,350,300,500],
];

var socket = new SockJS('/chat');
let stompClient = Stomp.over(socket);

//setting up the button listeners
document.getElementById("sendMessage").onclick = sendMessage();




console.log("Starting...");
connect();
console.log(JSON.stringify(
    new Position(
        gameBoard,
        1,
        new Move(
            new Coord(0,0),
             new Coord(0,0)
             ),
        true,
        true,
        true,
        true
    )
));


function connect(){
    stompClient.connect({}, function(frame){
        setConnected(true);
        stompClient.subscribe('topic/public', function(messageOutput){
               console.log(messageOutput);
        });
    });
}
function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function sendMessage() {
    var pos = new Position(gameBoard, 1, new Move(new Coord(0,0), new Coord(0,0)), true, true, true, true);
    stompClient.send("/Engine.getMoves", {}, JSON.stringify(pos));
    console.log("Sent");
}