// TODO: convert to svelte store
type messageHandler = (data: any) => any;

function startGame(gameBoard) {
  console.log("game ", gameBoard);
  return gameBoard;
}

const messageMap = new Map<string, messageHandler>();
messageMap.set("START_GAME", startGame);

export function processMessage(messageType: string, data: any) {
  try {
    const handler = messageMap.get(messageType);
    return handler(data);
  } catch (error) {
    return new Error("cannot process message");
  }
}
