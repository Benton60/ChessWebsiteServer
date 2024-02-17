export class Position{
    constructor(
        _GameBoard,
        _Color,
        _LastMove,
        _WhiteCanCastleLong,
        _WhiteCanCastleShort,
        _BlackCanCastleLong,
        _BlackCanCastleShort,
    ){
        this.board = _GameBoard;
        this.c = _Color;
        this.l = _LastMove;
        this.cl = _WhiteCanCastleLong;
        this.cs = _WhiteCanCastleShort;
        this.bcl = _BlackCanCastleLong;
        this.bcs = _BlackCanCastleShort;

    }
}