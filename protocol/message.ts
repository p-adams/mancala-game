// TODO: convert to svelte store
type messageHandler = (data: SocketMessage) => SocketMessage;

interface SocketGameData {
  p1: {
    name: string;
  };
  p2: {
    name: string;
  };
  board: {
    p1Store: Pit[];
    p2Store: Pit[];
    pits: Pit[];
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
  try {
    const handler = messageMap.get(messageType);
    return handler(data);
  } catch (error) {
    throw new Error("cannot process message");
  }
}
