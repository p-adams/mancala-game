// TODO: convert to svelte store
type messageHandler = (data: SocketMessage) => SocketMessage;

export interface SocketGameData {
  p1: {
    name: string;
  };
  p2: {
    name: string;
  };
  board: {
    p1Store: Pit;
    p2Store: Pit;
    pits: Pit[][];
    gamePieceTotal: number;
  };
}

export interface SocketMessage {
  messageType: string;
  data: SocketGameData;
}

interface Pit {
  label: string;
  stones: number[];
  stonesCount: number;
}

function startGame(gameBoard) {
  console.log("game ", gameBoard);
  return gameBoard;
}

const messageMap = new Map<string, messageHandler>();
messageMap.set("START_GAME", startGame);

export function processMessage(messageType: string, data: SocketMessage) {
  const handler = messageMap.get(messageType);
  if (handler) {
    return handler(data);
  }
  return null;
}
