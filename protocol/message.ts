// TODO: convert to svelte store
type messageHandler = (data: Message) => Message;

export interface Message {
  messageType: string;
  data: {
    p1: {
      name: string;
    };
    p2: {
      name: string;
    };
    board: {
      p1Store: any[];
      p2Store: any[];
      pits: Pit[];
      gamePieceTotal: number;
    };
  };
}

interface Pit {
  stones: number[];
  stonesCount: number;
}

function startGame(gameBoard) {
  console.log("game ", gameBoard);
  return gameBoard;
}

const messageMap = new Map<string, messageHandler>();
messageMap.set("START_GAME", startGame);

export function processMessage(messageType: string, data: Message) {
  try {
    const handler = messageMap.get(messageType);
    return handler(data);
  } catch (error) {
    throw new Error("cannot process message");
  }
}
